package com.springboot.bootcache.bean;

import java.sql.Date;

public class Statement {
    private Integer id;
    private String date;
    private Integer out_oldpeople;
    private Integer in_oldpeople;
    private Integer old;
    private Integer nurse;
    private Integer make_money;
    private Integer expend_money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getOut_oldpeople() {
        return out_oldpeople;
    }

    public void setOut_oldpeople(Integer out_oldpeople) {
        this.out_oldpeople = out_oldpeople;
    }

    public Integer getIn_oldpeople() {
        return in_oldpeople;
    }

    public void setIn_oldpeople(Integer in_oldpeople) {
        this.in_oldpeople = in_oldpeople;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    public Integer getNurse() {
        return nurse;
    }

    public void setNurse(Integer nurse) {
        this.nurse = nurse;
    }

    public Integer getMake_money() {
        return make_money;
    }

    public void setMake_money(Integer make_money) {
        this.make_money = make_money;
    }

    public Integer getExpend_money() {
        return expend_money;
    }

    public void setExpend_money(Integer expend_money) {
        this.expend_money = expend_money;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", out_oldpeople=" + out_oldpeople +
                ", in_oldpeople=" + in_oldpeople +
                ", old=" + old +
                ", nurse=" + nurse +
                ", make_money=" + make_money +
                ", expend_money=" + expend_money +
                '}';
    }
}