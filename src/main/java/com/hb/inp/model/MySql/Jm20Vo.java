package com.hb.inp.model.MySql;

//JM20 상품정보
public class Jm20Vo {
    String jycode;
    String jname;
    String jwxt;
    String jchk;
    String jgubun;
    int jea;
    int jwdan1;
    int jwdan2;
    int jsdan2;
    String jbcode1;
    String jbcode2;

    public Jm20Vo() {
    }

    public Jm20Vo(String jycode, String jname, String jwxt, String jchk, String jgubun, int jea, int jwdan1, int jwdan2, int jsdan2, String jbcode1, String jbcode2) {
        this.jycode = jycode;
        this.jname = jname;
        this.jwxt = jwxt;
        this.jchk = jchk;
        this.jgubun = jgubun;
        this.jea = jea;
        this.jwdan1 = jwdan1;
        this.jwdan2 = jwdan2;
        this.jsdan2 = jsdan2;
        this.jbcode1 = jbcode1;
        this.jbcode2 = jbcode2;
    }

    @Override
    public String toString() {
        return "Jm20Vo{" +
                "jycode='" + jycode + '\'' +
                ", jname='" + jname + '\'' +
                ", jwxt='" + jwxt + '\'' +
                ", jchk='" + jchk + '\'' +
                ", jgubun='" + jgubun + '\'' +
                ", jea=" + jea +
                ", jwdan1=" + jwdan1 +
                ", jwdan2=" + jwdan2 +
                ", jsdan2=" + jsdan2 +
                ", jbcode1='" + jbcode1 + '\'' +
                ", jbcode2='" + jbcode2 + '\'' +
                '}';
    }

    public String getJycode() {
        return jycode;
    }

    public void setJycode(String jycode) {
        this.jycode = jycode;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getJwxt() {
        return jwxt;
    }

    public void setJwxt(String jwxt) {
        this.jwxt = jwxt;
    }

    public String getJchk() {
        return jchk;
    }

    public void setJchk(String jchk) {
        this.jchk = jchk;
    }

    public String getJgubun() {
        return jgubun;
    }

    public void setJgubun(String jgubun) {
        this.jgubun = jgubun;
    }

    public int getJea() {
        return jea;
    }

    public void setJea(int jea) {
        this.jea = jea;
    }

    public int getJwdan1() {
        return jwdan1;
    }

    public void setJwdan1(int jwdan1) {
        this.jwdan1 = jwdan1;
    }

    public int getJwdan2() {
        return jwdan2;
    }

    public void setJwdan2(int jwdan2) {
        this.jwdan2 = jwdan2;
    }

    public int getJsdan2() {
        return jsdan2;
    }

    public void setJsdan2(int jsdan2) {
        this.jsdan2 = jsdan2;
    }

    public String getJbcode1() {
        return jbcode1;
    }

    public void setJbcode1(String jbcode1) {
        this.jbcode1 = jbcode1;
    }

    public String getJbcode2() {
        return jbcode2;
    }

    public void setJbcode2(String jbcode2) {
        this.jbcode2 = jbcode2;
    }
}
