package com.czxy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tmp_cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cname;
    private String address;
    private Integer area_id;
    private Area area;
    private List<Integer> fidlist = new ArrayList<>();

    public List<Integer> getFidlist() {
        return fidlist;
    }

    public void setFidlist(List<Integer> fidlist) {
        this.fidlist = fidlist;
    }

    private List<Film> filmList = new ArrayList<>();

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                ", area_id=" + area_id +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public Cinema(Integer cid, String cname, String address, Integer area_id) {

        this.cid = cid;
        this.cname = cname;
        this.address = address;
        this.area_id = area_id;
    }

    public Cinema() {

    }
}
