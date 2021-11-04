package com.example.testconectdata.model;

import java.io.Serializable;

public class Sanpham implements Serializable{
    public int Id;
    public String Tendouong;
    public int Giasanpham;
    public int Dungtich;


    public Sanpham(int id, String tendouong, int giasanpham, int dungtich) {
        Id = id;
        Tendouong = tendouong;
        Giasanpham = giasanpham;
        Dungtich = dungtich;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTendouong() {
        return Tendouong;
    }

    public void setTendouong(String tendouong) {
        Tendouong = tendouong;
    }

    public int getGiasanpham() {
        return Giasanpham;
    }

    public void setGiasanpham(int giasanpham) {
        Giasanpham = giasanpham;
    }

    public int getDungtich() {
        return Dungtich;
    }

    public void setDungtich(int dungtich) {
        Dungtich = dungtich;
    }
}
