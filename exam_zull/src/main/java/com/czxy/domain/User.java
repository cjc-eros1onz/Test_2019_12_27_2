package com.czxy.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer cid;
    private String cname;
    private String password;
    private String telephone;
    private Double money;

    @Override
    public String toString() {
        return "User{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", money=" + money +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User(Integer cid, String cname, String password, String telephone, Double money) {

        this.cid = cid;
        this.cname = cname;
        this.password = password;
        this.telephone = telephone;
        this.money = money;
    }

    public User() {

    }
}
