package com.czxy.domain;

public class CinemaPi {
    private Integer pageNum;
    private Integer pageSize;
    private String cname;
    private String area_id;

    @Override
    public String toString() {
        return "CinemaPi{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", cname='" + cname + '\'' +
                ", area_id='" + area_id + '\'' +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public CinemaPi(Integer pageNum, Integer pageSize, String cname, String area_id) {

        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.cname = cname;
        this.area_id = area_id;
    }

    public CinemaPi() {
    }
}
