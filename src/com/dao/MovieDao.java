package com.dao;

import com.entity.Movie;
import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:13
 * 描述:电影
 */
public interface MovieDao {
    //添加电影信息
    int insertMovie(Movie movie);

    //修改电影信息
    int updateMovie(Movie movie);

    //修改某个字段的电影信息
    int updateMovieColumnValue(Integer movieId, String columnName, String columnValue);

    //删除电影信息
    int deleteMovie(Integer movieId);

    //按名字查询电影
    Movie queryMovieByName(String movieName);

    //按类别查询电影
    Movie queryMovieByType(String movieType);

    //按导演查询电影
    Movie queryMovieByDirector(String director);

    //按主演查询电影
    Movie queryMovieByProtagonist(String protagonist);

    //按上映年份查询电影
    Movie queryMovieByShowTime(String showTime);

    //按id查询电影
    Movie queryMovieById(Integer id);

    //按浏览次数查询电影
    List<Movie> queryMovieByHits();

    List<Movie> queryMovieByVoteNum();

    Integer queryPageTotalCounts();

    List<Movie> queryMovieByPage(Integer pageNo, Integer pageSize);

    List<Movie> queryAllMovie();

    /**
     * 按条件查询
     *
     * @param movieName
     * @param type
     * @param protagonist
     * @param showTime
     * @return
     */
    List<Movie> queryAllMovie(String movieName, String type, String protagonist, String showTime);

    int addMovieHits(Integer movieId);

    Integer addMovieVote(Integer movieId);

    List<Movie> searchMovie(String searchMessage);


}
