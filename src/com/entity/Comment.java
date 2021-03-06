package com.entity;

import java.util.Date;

/**
 * 作者：林星源
 * 日期: 2020/12/9 10:39
 * 描述:
 */
public class Comment {
    private Integer commentId;
    private Integer commentTypeId;
    private Integer movieId;
    private String movieName;
    private String commentUser;
    private String headPic ;
    private String commentContent;
    private Date createTime;
    private Date updateTime;

    public Comment() {
    }


    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentTypeId=" + commentTypeId +
                ", movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", commentUser='" + commentUser + '\'' +
                ", headPic='" + headPic + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Comment(Integer commentId, Integer commentTypeId, Integer movieId, String movieName, String commentUser, String userHead, String commentContent, Date createTime, Date updateTime) {
        this.commentId = commentId;
        this.commentTypeId = commentTypeId;
        this.movieId = movieId;
        this.movieName = movieName;
        this.commentUser = commentUser;

        this.commentContent = commentContent;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentTypeId() {
        return commentTypeId;
    }

    public void setCommentTypeId(Integer commentTypeId) {
        this.commentTypeId = commentTypeId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
