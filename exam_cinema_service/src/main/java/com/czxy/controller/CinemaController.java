package com.czxy.controller;

import com.czxy.domain.Area;
import com.czxy.domain.Cinema;
import com.czxy.domain.CinemaPi;
import com.czxy.service.CinemaService;
import com.czxy.vo.BaseResult;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Resource
    private CinemaService cinemaService;

    /**
     * 分页+多条件
     * @param cinemaPi
     * @return
     */
    @PostMapping("/FindCinemaListForPageNum")
    public BaseResult FindCinemaListForPageNum(@RequestBody CinemaPi cinemaPi){
       PageInfo<Cinema> pageInfo =  cinemaService.FindCinemaListForPageNum(cinemaPi);
       return BaseResult.ok("查询成功",pageInfo);
    }

    /**
     * 查询所有地区
     * @return
     */
    @GetMapping("/FindAreaList")
    public BaseResult FindAreaList(){
        List<Area> alist = cinemaService.FindAreaList();
        return BaseResult.ok("查询成功",alist);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/deleteByids/{ids}")
    public BaseResult deleteByids(@PathVariable("ids")String ids){
        cinemaService.deleteByids(ids);
        return BaseResult.ok("删除成功");
    }

    /**
     *  添加影院
     * @param cinema
     * @return
     */
    @PostMapping("/addCinema")
    public BaseResult addCinema(@RequestBody Cinema cinema){
        cinemaService.addCinema(cinema);
        return BaseResult.ok("添加成功");
    }

    /**
     * 回显第一步
     * @param cid
     * @return
     */
    @GetMapping("/FindCinemaByCid/{cid}")
    public BaseResult FindCinemaByCid(@PathVariable("cid")Integer cid){
       Cinema cinema =  cinemaService.FindCinemaByCid(cid);
        System.out.println(cinema+"2312132132131231");
       return BaseResult.ok("查询成功",cinema);
    }
    @PutMapping("/updateCinema")
    public BaseResult updateCinema(@RequestBody Cinema cinema){
        cinemaService.updateCinema(cinema);
        return BaseResult.ok("修改成功");
    }
}
