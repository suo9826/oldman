package com.springboot.bootcache.bean;
/*
hujuku
 */
import java.sql.Date;

public class Nursing {
    private Integer id;
    private String  nurse_name;
    private String  nurse_sex;
    private Date    nurse_birthday;
    private String  nurse_politic;
    private Date    nurse_joindate;
    private Integer  nurse_working;
    private Integer nurse_grada;
    private Integer nurse_age;
    private String  nurse_phone;

    public String getNurse_phone() {
        return nurse_phone;
    }

    public void setNurse_phone(String nurse_phone) {
        this.nurse_phone = nurse_phone;
    }

    public Integer getNurse_age() {
        return nurse_age;
    }

    public void setNurse_age(Integer nurse_age) {
        this.nurse_age = nurse_age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNurse_name() {
        return nurse_name;
    }

    public void setNurse_name(String nurse_name) {
        this.nurse_name = nurse_name;
    }

    public String getNurse_sex() {
        return nurse_sex;
    }

    public void setNurse_sex(String nurse_sex) {
        this.nurse_sex = nurse_sex;
    }

    public Date getNurse_birthday() {
        return nurse_birthday;
    }

    public void setNurse_birthday(Date nurse_birthday) {
        this.nurse_birthday = nurse_birthday;
    }

    public String getNurse_politic() {
        return nurse_politic;
    }

    public void setNurse_politic(String nurse_politic) {
        this.nurse_politic = nurse_politic;
    }

    public Date getNurse_joindate() {
        return nurse_joindate;
    }

    public void setNurse_joindate(Date nurse_joindate) {
        this.nurse_joindate = nurse_joindate;
    }

    public Integer getNurse_working() {
        return nurse_working;
    }

    public void setNurse_working(Integer nurse_working) {
        this.nurse_working = nurse_working;
    }

    public Integer getNurse_grada() {
        return nurse_grada;
    }

    public void setNurse_grada(Integer nurse_grada) {
        this.nurse_grada = nurse_grada;
    }

    @Override
    public String toString() {
        return "Nursing{" +
                "id=" + id +
                ", nurse_name='" + nurse_name + '\'' +
                ", nurse_sex='" + nurse_sex + '\'' +
                ", nurse_birthday=" + nurse_birthday +
                ", nurse_politic='" + nurse_politic + '\'' +
                ", nurse_joindate=" + nurse_joindate +
                ", nurse_working='" + nurse_working + '\'' +
                ", nurse_grada=" + nurse_grada +
                ", nurse_age=" + nurse_age +
                ", nurse_phone='" + nurse_phone + '\'' +
                '}';
    }
}
