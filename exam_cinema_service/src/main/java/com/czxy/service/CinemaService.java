package com.czxy.service;

import com.czxy.domain.Area;
import com.czxy.domain.Cinema;
import com.czxy.domain.CinemaPi;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CinemaService {
    /**
     * 分页+多条件
     * @param cinemaPi
     * @return
     */
    PageInfo<Cinema> FindCinemaListForPageNum(CinemaPi cinemaPi);
    /**
     * 查询所有地区
     * @return
     */
    List<Area> FindAreaList();
    /**
     * 批量删除
     * @param ids
     * @return
     */
    void deleteByids(String ids);
    /**
     *  添加影院
     * @param cinema
     * @return
     */
    void addCinema(Cinema cinema);
    /**
     * 回显第一步
     * @param cid
     * @return
     */
    Cinema FindCinemaByCid(Integer cid);

    void updateCinema(Cinema cinema);
}
