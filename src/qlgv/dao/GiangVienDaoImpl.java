package qlgv.dao;

import qlgv.model.GiangVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GiangVienDaoImpl implements GiangVienDAO {

    @Override
    public List<GiangVien> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM giang_vien";
        List<GiangVien> list = new ArrayList<>();
        try {
            PreparedStatement ps =  cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               GiangVien giangvien = new GiangVien();
               giangvien.setMa_giang_vien(rs.getInt("ma_giang_vien"));
               giangvien.setTen_giang_vien(rs.getString("ten_giang_vien"));
               giangvien.setDia_chi(rs.getString("dia_chi"));
               giangvien.setTrinh_do(rs.getString("trinh_do"));
                      
               list.add(giangvien);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        GiangVienDAO giangVienDAO = new GiangVienDaoImpl();
        System.out.println(giangVienDAO.getList());
    }
    

}