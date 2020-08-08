package com.czxy.domain;

public class FilmCinema {
    private Integer fid;
    private Integer cid;

    @Override
    public String toString() {
        return "FilmCinema{" +
                "fid=" + fid +
                ", cid=" + cid +
                '}';
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public FilmCinema(Integer fid, Integer cid) {

        this.fid = fid;
        this.cid = cid;
    }

    public FilmCinema() {

    }
}
