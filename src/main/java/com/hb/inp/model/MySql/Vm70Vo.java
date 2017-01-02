package com.hb.inp.model.MySql;

// VM70 명세정보
public class Vm70Vo {
    String j_number;
    String j_code;
    String j_title;
    String j_schk;
    String j_date;
    String j_time;
    String j_memo1;
    int j_no;
    int j_gunsu;
    int j_money1;
    int j_money2;
    int j_money3;
    int j_money4;
    int j_money5;
    int j_money6;

    public Vm70Vo() {
    }

    public Vm70Vo(String j_number, String j_code, String j_title, String j_schk, String j_date, String j_time, String j_memo1, int j_no, int j_gunsu, int j_money1, int j_money2, int j_money3, int j_money4, int j_money5, int j_money6) {
        this.j_number = j_number;
        this.j_code = j_code;
        this.j_title = j_title;
        this.j_schk = j_schk;
        this.j_date = j_date;
        this.j_time = j_time;
        this.j_memo1 = j_memo1;
        this.j_no = j_no;
        this.j_gunsu = j_gunsu;
        this.j_money1 = j_money1;
        this.j_money2 = j_money2;
        this.j_money3 = j_money3;
        this.j_money4 = j_money4;
        this.j_money5 = j_money5;
        this.j_money6 = j_money6;
    }

    @Override
    public String toString() {
        return "Vm70Vo{" +
                "j_number='" + j_number + '\'' +
                ", j_code='" + j_code + '\'' +
                ", j_title='" + j_title + '\'' +
                ", j_schk='" + j_schk + '\'' +
                ", j_date='" + j_date + '\'' +
                ", j_time='" + j_time + '\'' +
                ", j_memo1='" + j_memo1 + '\'' +
                ", j_no=" + j_no +
                ", j_gunsu=" + j_gunsu +
                ", j_money1=" + j_money1 +
                ", j_money2=" + j_money2 +
                ", j_money3=" + j_money3 +
                ", j_money4=" + j_money4 +
                ", j_money5=" + j_money5 +
                ", j_money6=" + j_money6 +
                '}';
    }

    public String getJ_number() {
        return j_number;
    }

    public void setJ_number(String j_number) {
        this.j_number = j_number;
    }

    public String getJ_code() {
        return j_code;
    }

    public void setJ_code(String j_code) {
        this.j_code = j_code;
    }

    public String getJ_title() {
        return j_title;
    }

    public void setJ_title(String j_title) {
        this.j_title = j_title;
    }

    public String getJ_schk() {
        return j_schk;
    }

    public void setJ_schk(String j_schk) {
        this.j_schk = j_schk;
    }

    public String getJ_date() {
        return j_date;
    }

    public void setJ_date(String j_date) {
        this.j_date = j_date;
    }

    public String getJ_time() {
        return j_time;
    }

    public void setJ_time(String j_time) {
        this.j_time = j_time;
    }

    public String getJ_memo1() {
        return j_memo1;
    }

    public void setJ_memo1(String j_memo1) {
        this.j_memo1 = j_memo1;
    }

    public int getJ_no() {
        return j_no;
    }

    public void setJ_no(int j_no) {
        this.j_no = j_no;
    }

    public int getJ_gunsu() {
        return j_gunsu;
    }

    public void setJ_gunsu(int j_gunsu) {
        this.j_gunsu = j_gunsu;
    }

    public int getJ_money1() {
        return j_money1;
    }

    public void setJ_money1(int j_money1) {
        this.j_money1 = j_money1;
    }

    public int getJ_money2() {
        return j_money2;
    }

    public void setJ_money2(int j_money2) {
        this.j_money2 = j_money2;
    }

    public int getJ_money3() {
        return j_money3;
    }

    public void setJ_money3(int j_money3) {
        this.j_money3 = j_money3;
    }

    public int getJ_money4() {
        return j_money4;
    }

    public void setJ_money4(int j_money4) {
        this.j_money4 = j_money4;
    }

    public int getJ_money5() {
        return j_money5;
    }

    public void setJ_money5(int j_money5) {
        this.j_money5 = j_money5;
    }

    public int getJ_money6() {
        return j_money6;
    }

    public void setJ_money6(int j_money6) {
        this.j_money6 = j_money6;
    }
}
