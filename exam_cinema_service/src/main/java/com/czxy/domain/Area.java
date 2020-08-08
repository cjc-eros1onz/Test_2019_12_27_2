package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tmp_area")
public class Area  {
    @Id
    private Integer aid;
    private String aname;

    @Override
    public String toString() {
        return "Area{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Area(Integer aid, String aname) {

        this.aid = aid;
        this.aname = aname;
    }

    public Area() {

    }
}
