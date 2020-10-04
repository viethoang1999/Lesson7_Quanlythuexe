package Sevices;

import Models.DangKyCungCap;
import Models.DongXe;
import Models.NhaCungCap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuanLythuexeSevice {
    private final Connection connection;

    public QuanLythuexeSevice(Connection connection) {
        this.connection = connection;
    }

    /* 1. Liệt kê những dòng xe có số chỗ ngồi lớn hơn x chỗ (VD: x là 5 chỗ ngồi)*/
    public List<DongXe> service1 (int soChoNgoi){
        try {
            List<DongXe> listDongXe = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM dongxe WHERE SoChoNgoi > " + soChoNgoi;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DongXe dongXe = new DongXe();
                dongXe.setDongXe(resultSet.getString(1));
                dongXe.setHangXe(resultSet.getString(2));
                dongXe.setSoChoNgoi(resultSet.getInt(3));
                listDongXe.add(dongXe);
            }
            return listDongXe;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*2. Liệt kê thông tin của các nhà cung cấp ĐÃ TỪNG đăng ký cung cấp những dòng xe
    thuộc hãng xe “Toyota” với mức phí có đơn giá là 15.000 VNĐ/km hoặc những dòng xe
    thuộc hãng xe “KIA” với mức phí có đơn giá là 20.000 VNĐ/km*/
    public List<DangKyCungCap> service2() {
        try {
            List<DangKyCungCap> listDangKyCungCap = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DangKyCungCap dangKyCungCap = new DangKyCungCap();
                dangKyCungCap.setMaNhaCungCap(resultSet.getString(1));
                dangKyCungCap.setTenNhaCungCap(resultSet.getString(2));
                dangKyCungCap.setDongXe(resultSet.getString(3));
                dangKyCungCap.setHangXe(resultSet.getString(4));
                dangKyCungCap.setDonGia(resultSet.getInt(5));
                listDangKyCungCap.add(dangKyCungCap);
            }
            return listDangKyCungCap;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*3. Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung
    cấp và giảm dần theo mã số thuế*/
    public List<NhaCungCap> service3() {
        try {
            List<NhaCungCap> listNhaCungCap = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM nhacungcap ORDER BY TenNCC ASC, MaSoThue DESC";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNhaCungCap(resultSet.getString(1));
                nhaCungCap.setTenNhaCungCap(resultSet.getString(2));
                nhaCungCap.setDiaChi(resultSet.getString(3));
                nhaCungCap.setSoDienThoai(resultSet.getString(4));
                nhaCungCap.setMaSoThue(resultSet.getString(5));
                listNhaCungCap.add(nhaCungCap);
            }
            return listNhaCungCap;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*4. Đếm số lần đăng ký cung cấp phương tiện tương ứng cho từng nhà cung cấp với
    yêu cầu chỉ đếm cho những nhà cung cấp thực hiện đăng ký cung cấp có ngày bắt đầu
    cung cấp là “20/11/2015”*/
    public List<DangKyCungCap> service4() {
        try {
            List<DangKyCungCap> listDangKyCungCap = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DangKyCungCap dangKyCungCap = new DangKyCungCap();
                dangKyCungCap.setMaNhaCungCap(resultSet.getString(1));
                dangKyCungCap.setTenNhaCungCap(resultSet.getString(2));
                dangKyCungCap.setSoLanDangKy(resultSet.getInt(3));
                listDangKyCungCap.add(dangKyCungCap);
            }
            return listDangKyCungCap;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*5. Liệt kê tên của toàn bộ các hãng xe có trong cơ sở dữ liệu với yêu cầu mỗi hãng xe chỉ được liệt kê một lần*/
    public List<String> service5() {
        try {
            List<String> listHangXe = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "SELECT DISTINCT HangXe FROM dongxe";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String hangXe = resultSet.getString(1);
                listHangXe.add(hangXe);
            }
            return listHangXe;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*6. Liệt kê MaDKCC, MaNhaCC, TenNhaCC, DiaChi, MaSoThue, TenLoaiDV, DonGia,
    HangXe, NgayBatDauCC, NgayKetThucCC của tất cả các lần đăng ký cung cấp phương
    tiện với yêu cầu những nhà cung cấp nào chưa từng thực hiện đăng ký cung cấp phương
    tiện thì cũng liệt kê thông tin những nhà cung cấp đó ra*/
    public List<DangKyCungCap> service6() {
        try {
            List<DangKyCungCap> listDangKyCungCap = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                DangKyCungCap dangKyCungCap = new DangKyCungCap();
                dangKyCungCap.setMaNhaCungCap(resultSet.getString(1));
                dangKyCungCap.setTenNhaCungCap(resultSet.getString(2));
                dangKyCungCap.setDiaChiNhaCungCap(resultSet.getString(3));
                dangKyCungCap.setMaSoThueNhaCungCap(resultSet.getString(4));
                dangKyCungCap.setMaDangKyCungCap(resultSet.getString(5));
                dangKyCungCap.setTenLoaiDichVu(resultSet.getString(6));
                dangKyCungCap.setDonGia(resultSet.getInt(7));
                dangKyCungCap.setHangXe(resultSet.getString(8));
                dangKyCungCap.setNgayBatDauCungCap(resultSet.getTimestamp(9));
                dangKyCungCap.setNgayKetThucCungCap(resultSet.getTimestamp(10));
                listDangKyCungCap.add(dangKyCungCap);
            }
            return listDangKyCungCap;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*7. Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp phương tiện
    thuộc dòng xe “Hiace” hoặc từng đăng ký cung cấp phương tiện thuộc dòng xe “Cerato”*/
    public List<NhaCungCap> service7() {
        try {
            List<NhaCungCap> listNhaCungCap = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "";
            ResultSet resultSetService7 = statement.executeQuery(sql);
            while (resultSetService7.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap(resultSetService7.getString(6));
                nhaCungCap.setMaNhaCungCap(resultSetService7.getString(1));
                nhaCungCap.setTenNhaCungCap(resultSetService7.getString(2));
                nhaCungCap.setDiaChi(resultSetService7.getString(3));
                nhaCungCap.setSoDienThoai(resultSetService7.getString(4));
                nhaCungCap.setMaSoThue(resultSetService7.getString(5));
                listNhaCungCap.add(nhaCungCap);
            }
            return listNhaCungCap;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /*8. Liệt kê thông tin của các nhà cung cấp chưa từng thực hiện đăng ký cung cấp
    phương tiện lần nào cả.*/
    public List<NhaCungCap> service8() {
        try {
            List<NhaCungCap> listNhaCungCap = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "";
            ResultSet resultSetService8 = statement.executeQuery(sql);
            while (resultSetService8.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNhaCungCap(resultSetService8.getString(1));
                nhaCungCap.setTenNhaCungCap(resultSetService8.getString(2));
                nhaCungCap.setDiaChi(resultSetService8.getString(3));
                nhaCungCap.setSoDienThoai(resultSetService8.getString(4));
                nhaCungCap.setMaSoThue(resultSetService8.getString(5));
                listNhaCungCap.add(nhaCungCap);
            }
            return listNhaCungCap;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
