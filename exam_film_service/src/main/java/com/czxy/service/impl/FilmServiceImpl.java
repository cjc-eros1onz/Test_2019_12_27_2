package com.czxy.service.impl;

import com.czxy.domain.Film;
import com.czxy.domain.FilmCinema;
import com.czxy.mapper.FilmCinemaMapper;
import com.czxy.mapper.FilmMapper;
import com.czxy.service.FilmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    @Resource
    private FilmMapper filmMapper;
    @Resource
    private FilmCinemaMapper filmCinemaMapper;

    /**
     * 根据词典查询影片信息
     * @param cid
     * @return
     */
    @Override
    public List<Film> FindFilmByCid(Integer cid) {
        return filmMapper.FindFilmByCid(cid);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public void deleteByids(String ids) {
        for (String s : ids.split(",")) {
            Example example = new Example(FilmCinema.class);
            Example.Criteria c = example.createCriteria();
            c.andEqualTo("cid",Integer.parseInt(s));
            filmCinemaMapper.deleteByExample(example);
        }
    }
    /**
     * 查询所有影片信息
     * @return
     */
    @Override
    public List<Film> FindFilmList() {
        return filmMapper.selectAll();
    }

    @Override
    public void addCinema(FilmCinema filmCinema) {
        filmCinemaMapper.insertSelective(filmCinema);
    }
}
