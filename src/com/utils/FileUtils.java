package com.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileUtils {
    public static Map<String, String> singleUpload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        StringBuilder fileName = new StringBuilder();
        //金句：防止中文乱码
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String imagePath = null;
        // 创建FileItemFactory 工厂实现类
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        //创建用于解析上传数据的工具类
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        try {
            //解析上传的数据 得到每一个表单项FileItem
            List<FileItem> list = servletFileUpload.parseRequest(request);
            //循环判断，每一个表单项 是普通类型 还是上传的文件
            for (FileItem fileItem :
                    list) {
                //上传的文件
                StringBuilder sb = new StringBuilder("D:\\project1205\\images");
                fileName.append(System.currentTimeMillis());
                fileName.append(fileItem.getName());
                sb.append(fileName);
                imagePath = sb.toString();
                fileItem.write(new File(imagePath));
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        //文件在硬盘中的绝对路径 从盘符开始
        map.put("imagePath", imagePath);
        //文件名
        map.put("fileName", fileName.toString());
        return map;
    }

    public static void singleDownload(HttpServletRequest request, HttpServletResponse response, String path) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //设置文件名
        //String fileName = "惊喜.jpg";
        //将响应的类型设置为图片
        response.setContentType("image/jpeg");
        //金句：下载文件中文乱码解决
        // 把中文名进行UTF-8 编码操作。
        //System.out.println("path:"+path);
        //String str = "attachment; fileName=" + URLEncoder.encode(path, "UTF-8");
        // 然后把编码后的字符串设置到响应头中
        //金句：文件下载
        //response.setHeader("Content-Disposition", str);
        //System.out.println("str:"+str);
        //如果要读取工程外部 硬盘里的资源 建议使用FileInputStream 以及 BufferedInputStream
        InputStream fileIn = new FileInputStream(new File(path));
        InputStream in = new BufferedInputStream(fileIn);
        //使用ServletContext获取输入流 只能获取到工程内部的资源
        //InputStream in = getServletContext().getResourceAsStream();
        OutputStream out = response.getOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = in.read(buff)) > -1) {
            out.write(buff, 0, len);
            out.flush();
        }
        out.close();
        in.close();
    }
}
