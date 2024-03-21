/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlgv.model;

/**
 *
 * @author minhq
 */
public class MonHoc {
    private int ma_mon;
    private String ten_mon;
    private int tong_so_tiet;
    private int so_tiet_lt;
    private int so_tiet_tt;
    private double kinh_phi;

    public MonHoc(int ma_mon, String ten_mon, int tong_so_tiet, int so_tiet_lt, int so_tiet_tt, double kinh_phi) {
        this.ma_mon = ma_mon;
        this.ten_mon = ten_mon;
        this.tong_so_tiet = tong_so_tiet;
        this.so_tiet_lt = so_tiet_lt;
        this.so_tiet_tt = so_tiet_tt;
        this.kinh_phi = kinh_phi;
    }

    public int getMa_mon() {
        return ma_mon;
    }

    public void setMa_mon(int ma_mon) {
        this.ma_mon = ma_mon;
    }

    public String getTen_mon() {
        return ten_mon;
    }

    public void setTen_mon(String ten_mon) {
        this.ten_mon = ten_mon;
    }

    public int getTong_so_tiet() {
        return tong_so_tiet;
    }

    public void setTong_so_tiet(int tong_so_tiet) {
        this.tong_so_tiet = tong_so_tiet;
    }

    public int getSo_tiet_lt() {
        return so_tiet_lt;
    }

    public void setSo_tiet_lt(int so_tiet_lt) {
        this.so_tiet_lt = so_tiet_lt;
    }

    public int getSo_tiet_tt() {
        return so_tiet_tt;
    }

    public void setSo_tiet_tt(int so_tiet_tt) {
        this.so_tiet_tt = so_tiet_tt;
    }

    public double getKinh_phi() {
        return kinh_phi;
    }

    public void setKinh_phi(double kinh_phi) {
        this.kinh_phi = kinh_phi;
    }
    
          
    
}  