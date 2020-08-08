package com.czxy.feign;

import com.czxy.domain.FilmCinema;
import com.czxy.vo.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "examfilm",path = "/film")
public interface CinemaFeign {
    @GetMapping("/FindFilmByCid/{cid}")
    public BaseResult FindFilmByCid(@PathVariable("cid") Integer cid);
    @DeleteMapping("/deleteByids/{ids}")
    public BaseResult deleteByids(@PathVariable("ids")String ids);
    @PostMapping("/addCinema")
    public BaseResult addCinema(@RequestBody FilmCinema filmCinema);
}
