package com.czxy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tmp_film")
public class Film {
    @Id
    private Integer fid;
    private String fname;
    private String img;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date release_time;
    private String director;

    @Override
    public String toString() {
        return "Film{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", img='" + img + '\'' +
                ", release_time=" + release_time +
                ", director='" + director + '\'' +
                '}';
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Film(Integer fid, String fname, String img, Date release_time, String director) {

        this.fid = fid;
        this.fname = fname;
        this.img = img;
        this.release_time = release_time;
        this.director = director;
    }

    public Film() {

    }
}
