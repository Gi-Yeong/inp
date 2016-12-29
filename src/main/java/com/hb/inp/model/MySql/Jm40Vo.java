package com.hb.inp.model.MySql;

// JM40 거래처정보
public class Jm40Vo {
    String code;
    String title1;
    String bbigo;
    String tel1;
    String address;
    String number;
    String name;
    String gubun;
    String lastdan;
    int moneay;

    public Jm40Vo() {
    }

    public Jm40Vo(String code, String title1, String bbigo, String tel1, String address, String number, String name, String gubun, String lastdan, int moneay) {
        this.code = code;
        this.title1 = title1;
        this.bbigo = bbigo;
        this.tel1 = tel1;
        this.address = address;
        this.number = number;
        this.name = name;
        this.gubun = gubun;
        this.lastdan = lastdan;
        this.moneay = moneay;
    }

    @Override
    public String toString() {
        return "Jm40Vo{" +
                "code='" + code + '\'' +
                ", title1='" + title1 + '\'' +
                ", bbigo='" + bbigo + '\'' +
                ", tel1='" + tel1 + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", gubun='" + gubun + '\'' +
                ", lastdan='" + lastdan + '\'' +
                ", moneay=" + moneay +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getBbigo() {
        return bbigo;
    }

    public void setBbigo(String bbigo) {
        this.bbigo = bbigo;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getLastdan() {
        return lastdan;
    }

    public void setLastdan(String lastdan) {
        this.lastdan = lastdan;
    }

    public int getMoneay() {
        return moneay;
    }

    public void setMoneay(int moneay) {
        this.moneay = moneay;
    }
}
