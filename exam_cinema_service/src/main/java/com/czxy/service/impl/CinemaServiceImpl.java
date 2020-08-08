package com.czxy.service.impl;

import com.czxy.domain.*;
import com.czxy.feign.CinemaFeign;
import com.czxy.mapper.AreaMapper;
import com.czxy.mapper.CinemaMapper;
import com.czxy.service.CinemaService;
import com.czxy.vo.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {
    @Resource
    private CinemaMapper cinemaMapper;
    @Resource
    private AreaMapper areaMapper;
    @Resource
    private CinemaFeign cinemaFeign;
    /**
     * 分页+多条件
     * @param cinemaPi
     * @return
     */
    @Override
    public PageInfo<Cinema> FindCinemaListForPageNum(CinemaPi cinemaPi) {
        PageHelper.startPage(cinemaPi.getPageNum(),cinemaPi.getPageSize());
        if (cinemaPi.getCname() !=null && !"" .equals(cinemaPi.getCname())){
            cinemaPi.setCname("%"+cinemaPi.getCname()+"%");
        }
      List<Cinema> clist =  cinemaMapper.FindCinemaListForPageNum(cinemaPi);
        for (Cinema c : clist) {
            BaseResult baseResult = cinemaFeign.FindFilmByCid(c.getCid());
            List<Film> data = (List<Film>) baseResult.getData();
            c.setFilmList(data);
        }
        return new PageInfo<>(clist);
    }
    /**
     * 查询所有地区
     * @return
     */
    @Override
    public List<Area> FindAreaList() {
        return areaMapper.selectAll();
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public void deleteByids(String ids) {
        for (String s : ids.split(",")) {
            cinemaMapper.deleteByPrimaryKey(Integer.parseInt(s));
        }
    cinemaFeign.deleteByids(ids);
    }
    /**
     *  添加影院
     * @param cinema
     * @return
     */
    @Override
    public void addCinema(Cinema cinema) {
        cinemaMapper.insertSelective(cinema);
        for (Integer fid : cinema.getFidlist()) {
            cinemaFeign.addCinema(new FilmCinema(fid,cinema.getCid()));
        }
    }
    /**
     * 回显第一步
     * @param cid
     * @return
     */
    @Override
    public Cinema FindCinemaByCid(Integer cid) {
       Cinema cinema = cinemaMapper.FindCinemaByCid(cid);
        BaseResult baseResult = cinemaFeign.FindFilmByCid(cid);
        List<Film>  data = (List<Film>) baseResult.getData();
        cinema.setFilmList(data);
        return cinema;
    }

    @Override
    public void updateCinema(Cinema cinema) {
        cinemaMapper.updateByPrimaryKeySelective(cinema);
        cinemaFeign.deleteByids(cinema.getCid()+"");
        for (Integer fid : cinema.getFidlist()) {
            cinemaFeign.addCinema(new FilmCinema(fid,cinema.getCid()));
        }

    }
}
