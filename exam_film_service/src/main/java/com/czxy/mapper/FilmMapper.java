package com.czxy.mapper;

import com.czxy.domain.Film;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FilmMapper extends Mapper<Film> {
    /**
     * 根据词典查询影片信息
     * @param cid
     * @return
     */
    @Select("SELECT * FROM tmp_film f,tmp_film_cinema fc WHERE f.fid=fc.fid AND fc.cid=#{cid}")
    List<Film> FindFilmByCid(@Param("cid") Integer cid);
}
