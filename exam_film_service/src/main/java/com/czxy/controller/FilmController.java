package com.czxy.controller;

import com.czxy.domain.Film;
import com.czxy.domain.FilmCinema;
import com.czxy.service.FilmService;
import com.czxy.vo.BaseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Resource
    private FilmService filmService;

    /**
     * 根据词典查询影片信息
     * @param cid
     * @return
     */
 @GetMapping("/FindFilmByCid/{cid}")
    public BaseResult FindFilmByCid(@PathVariable("cid") Integer cid){
    List<Film> flist =  filmService.FindFilmByCid(cid);
    return BaseResult.ok("查询成功",flist);
 }

    /**
     * 批量删除
     * @param ids
     * @return
     */
 @DeleteMapping("/deleteByids/{ids}")
    public BaseResult deleteByids(@PathVariable("ids")String ids){
        filmService.deleteByids(ids);
        return BaseResult.ok("删除成功");
 }

    /**
     * 查询所有影片信息
     * @return
     */
 @GetMapping("/FindFilmList")
    public BaseResult FindFilmList(){
        List<Film> flist = filmService.FindFilmList();
        return BaseResult.ok("查询成功",flist);
 }

    /**
     * 添加
     * @param filmCinema
     * @return
     */
 @PostMapping("/addCinema")
    public BaseResult addCinema(@RequestBody FilmCinema filmCinema){
        filmService.addCinema(filmCinema);
        return BaseResult.ok("添加成功");
 }
}
