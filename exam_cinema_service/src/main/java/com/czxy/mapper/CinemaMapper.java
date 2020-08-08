package com.czxy.mapper;

import com.czxy.domain.Cinema;
import com.czxy.domain.CinemaPi;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CinemaMapper extends Mapper<Cinema> {
@Select("<script> select * from tmp_cinema where 1=1"+
        "<if test=\" cinemaPi.cname != null and cinemaPi.cname !='' \"> and cname like #{cinemaPi.cname} </if>"+
        "<if test=\" cinemaPi.area_id !=null and cinemaPi.area_id !='' \"> and area_id = #{cinemaPi.area_id} </if>"+
        "</script>")
@Results(id = "c1",value = {
        @Result(property = "area_id",column = "area_id"),
        @Result(property = "area",column = "area_id",one = @One(select = "com.czxy.mapper.AreaMapper.selectByPrimaryKey"))
})
    List<Cinema> FindCinemaListForPageNum(@Param("cinemaPi") CinemaPi cinemaPi);
    /**
     * 回显第一步
     * @param cid
     * @return
     */
    @Select("select * from tmp_cinema where cid =#{cid}")
    @ResultMap("c1")
    Cinema FindCinemaByCid(@Param("cid") Integer cid);
}
