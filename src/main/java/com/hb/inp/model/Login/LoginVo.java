package com.hb.inp.model.Login;

public class LoginVo {
    private String id;
    private String pw;

    public LoginVo() {
    }

    public LoginVo(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginVo)) return false;

        LoginVo loginVo = (LoginVo) o;

        if (getId() != null ? !getId().equals(loginVo.getId()) : loginVo.getId() != null) return false;
        return getPw() != null ? getPw().equals(loginVo.getPw()) : loginVo.getPw() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPw() != null ? getPw().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
