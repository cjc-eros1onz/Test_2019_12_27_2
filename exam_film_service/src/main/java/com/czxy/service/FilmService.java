package com.czxy.service;

import com.czxy.domain.Film;
import com.czxy.domain.FilmCinema;

import java.util.List;

public interface FilmService {
    /**
     * 根据词典查询影片信息
     * @param cid
     * @return
     */
    List<Film> FindFilmByCid(Integer cid);
    /**
     * 批量删除
     * @param ids
     * @return
     */
    void deleteByids(String ids);
    /**
     * 查询所有影片信息
     * @return
     */
    List<Film> FindFilmList();
    /**
     * 添加
     * @param filmCinema
     * @return
     */
    void addCinema(FilmCinema filmCinema);
}
