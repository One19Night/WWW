package com.example.testconectdata.model;

public class Giohang {
    public int idsp;
    public String tensp;
    public long giasp;
    public int dungtichsp;
    public int soluongsp;

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public long getGiasp() {
        return giasp;
    }

    public void setGiasp(long giasp) {
        this.giasp = giasp;
    }

    public int getDungtichsp() {
        return dungtichsp;
    }

    public void setDungtichsp(int dungtichsp) {
        this.dungtichsp = dungtichsp;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }

    public Giohang(int idsp, String tensp, long giasp, int dungtichsp, int soluongsp) {
        this.idsp = idsp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.dungtichsp = dungtichsp;
        this.soluongsp = soluongsp;
    }
}
