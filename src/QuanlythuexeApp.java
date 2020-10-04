import Models.DangKyCungCap;
import Models.DongXe;
import Models.NhaCungCap;
import Sevices.QuanLythuexeSevice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class QuanlythuexeApp {
    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quanlythuexe", "root", "0945533162");
            System.out.println("SQL Connection to database established!");
            QuanLythuexeSevice quanLyThueXeService = new QuanLythuexeSevice(connection);
            List<DangKyCungCap> listDangKyCungCap;
            List<DongXe> listDongXe;
            List<NhaCungCap> listNhaCungCap;
            System.out.println(" QUẢN LÝ THUÊ XE");
            System.out.println("1. Liệt kê những dòng xe có số chỗ ngồi trên 5 chỗ");
            System.out.println("2. Liệt kê thông tin của các nhà cung cấp ĐÃ TỪNG đăng ký cung cấp những dòng xe thuộc hãng xe “Toyota” với mức phí có đơn giá là 15.000 VNĐ/km hoặc những dòng xe thuộc hãng xe “KIA” với mức phí có đơn giá là 20.000 VNĐ/km");
            System.out.println("3. Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung cấp và giảm dần theo mã số thuế");
            System.out.println("4. Đếm số lần đăng ký cung cấp phương tiện tương ứng cho từng nhà cung cấp với yêu cầu chỉ đếm cho những nhà cung cấp thực hiện đăng ký cung cấp có ngày bắt đầu cung cấp là “20/11/2015”");
            System.out.println("5. Liệt kê tên của toàn bộ các hãng xe có trong cơ sở dữ liệu với yêu cầu mỗi hãng xe chỉ được liệt kê một lần");
            System.out.println("6. Liệt kê MaDKCC, MaNhaCC, TenNhaCC, DiaChi, MaSoThue, TenLoaiDV, DonGia, HangXe, NgayBatDauCC, NgayKetThucCC của tất cả các lần đăng ký cung cấp phương tiện với yêu cầu những nhà cung cấp nào chưa từng thực hiện đăng ký cung cấp phương tiện thì cũng liệt kê thông tin những nhà cung cấp đó ra");
            System.out.println("7. Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp phương tiện thuộc dòng xe “Hiace” hoặc từng đăng ký cung cấp phương tiện thuộc dòng xe “Cerato”");
            System.out.println("8. Liệt kê thông tin của các nhà cung cấp chưa từng thực hiện đăng ký cung cấp phương tiện lần nào cả.");

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nNhập lựa chọn:");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println("1. Liệt kê những dòng xe có số chỗ ngồi trên 5 chỗ");
                    listDongXe = quanLyThueXeService.service1(5);
                    if (listDongXe == null || listDongXe.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin.");
                    } else {
                        for (DongXe dongXe : listDongXe) {
                            System.out.println(dongXe.toString());
                        }
                    }
                }
                case 2 -> {
                    System.out.println("2. Liệt kê thông tin của các nhà cung cấp ĐÃ TỪNG đăng ký cung cấp những dòng xe thuộc hãng xe “Toyota” với mức phí có đơn giá là 15.000 VNĐ/km hoặc những dòng xe thuộc hãng xe “KIA” với mức phí có đơn giá là 20.000 VNĐ/km");
                    listDangKyCungCap = quanLyThueXeService.service2();
                    if (listDangKyCungCap == null || listDangKyCungCap.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin.");
                    } else {
                        for (DangKyCungCap dangKyCungCap : listDangKyCungCap) {
                            System.out.println(
                                    "- Mã nhà cung cấp: " + dangKyCungCap.getMaNhaCungCap()
                                            + ", Tên nhà cung cấp: " + dangKyCungCap.getTenNhaCungCap()
                                            + ", Dòng xe: " + dangKyCungCap.getDongXe()
                                            + ", Hãng xe: " + dangKyCungCap.getHangXe()
                                            + ", Đơn giá: " + dangKyCungCap.getDonGia());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("3. Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung cấp và giảm dần theo mã số thuế");
                    listNhaCungCap = quanLyThueXeService.service3();
                    if (listNhaCungCap == null || listNhaCungCap.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin.");
                    } else {
                        for (NhaCungCap nhaCungCap : listNhaCungCap) {
                            System.out.println(nhaCungCap.toString());
                        }
                    }
                }
                case 4 -> {
                    System.out.println("4. Đếm số lần đăng ký cung cấp phương tiện tương ứng cho từng nhà cung cấp với yêu cầu chỉ đếm cho những nhà cung cấp thực hiện đăng ký cung cấp có ngày bắt đầu cung cấp là “20/11/2015”");
                    listDangKyCungCap = quanLyThueXeService.service4();
                    if (listDangKyCungCap == null || listDangKyCungCap.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin.");
                    } else {
                        for (DangKyCungCap dangKyCungCap : listDangKyCungCap) {
                            System.out.println("- Mã nhà cung cấp: " + dangKyCungCap.getMaNhaCungCap()
                                    + ", Tên nhà cung cấp: " + dangKyCungCap.getTenNhaCungCap()
                                    + ", Số lần đăng ký: " + dangKyCungCap.getSoLanDangKy());
                        }
                    }
                }
                case 5 -> {
                    System.out.println("5. Liệt kê tên của toàn bộ các hãng xe có trong cơ sở dữ liệu với yêu cầu mỗi hãng xe chỉ được liệt kê một lần");
                    List<String> listHangXe = quanLyThueXeService.service5();
                    if (listHangXe == null || listHangXe.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin.");
                    } else {
                        for (String hangXe : listHangXe) {
                            System.out.println("- Tên hãng xe: " + hangXe);
                        }
                    }
                }
                case 6 -> {
                    System.out.println("6. Liệt kê MaNhaCC, TenNhaCC, DiaChi, MaSoThue, MaDKCC, TenLoaiDV, DonGia, HangXe, NgayBatDauCC, NgayKetThucCC của tất cả các lần đăng ký cung cấp phương tiện với yêu cầu những nhà cung cấp nào chưa từng thực hiện đăng ký cung cấp phương tiện thì cũng liệt kê thông tin những nhà cung cấp đó ra");
                    listDangKyCungCap = quanLyThueXeService.service6();
                    if (listDangKyCungCap == null || listDangKyCungCap.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin.");
                    } else {
                        for (DangKyCungCap dangKyCungCap : listDangKyCungCap) {
                            System.out.println("- Mã nhà cung cấp: " + dangKyCungCap.getMaNhaCungCap()
                                    + ", Tên nhà cung cấp: " + dangKyCungCap.getTenNhaCungCap()
                                    + ", Địa chỉ: " + dangKyCungCap.getDiaChiNhaCungCap()
                                    + ", Mã số thuế: " + dangKyCungCap.getMaSoThueNhaCungCap()
                                    + ", Mã đăng ký cung cấp: " + dangKyCungCap.getMaDangKyCungCap()
                                    + ", Tên loại dịch vụ: " + dangKyCungCap.getTenLoaiDichVu()
                                    + ", Đơn giá: " + dangKyCungCap.getDonGia()
                                    + ", Hãng xe: " + dangKyCungCap.getHangXe()
                                    + ", Ngày bắt đầu cung cấp: " + dangKyCungCap.getNgayBatDauCungCap()
                                    + ", Ngày kết thúc cung cấp: " + dangKyCungCap.getNgayKetThucCungCap());
                        }
                    }
                }
                case 7 -> {
                    System.out.println("7. Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp phương tiện thuộc dòng xe “Hiace” hoặc từng đăng ký cung cấp phương tiện thuộc dòng xe “Cerato”");
                    listNhaCungCap = quanLyThueXeService.service7();
                    if (listNhaCungCap == null || listNhaCungCap.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin.");
                    } else {
                        for (NhaCungCap nhaCungCap : listNhaCungCap) {
                            System.out.println(nhaCungCap.toString() + ", Dòng xe: " + nhaCungCap.getDongXe());
                        }
                    }
                }
                case 8 -> {
                    System.out.println("8. Liệt kê thông tin của các nhà cung cấp chưa từng thực hiện đăng ký cung cấp phương tiện lần nào cả.");
                    listNhaCungCap = quanLyThueXeService.service8();
                    if (listNhaCungCap == null || listNhaCungCap.isEmpty()) {
                        System.out.println("Không tìm thấy thông tin.");
                    } else {
                        for (NhaCungCap nhaCungCap : listNhaCungCap) {
                            System.out.println(nhaCungCap.toString());
                        }
                    }
                }
            }
        }catch(SQLException e){
                System.out.println("Connection Failed! Check output console" + e);
                return;
            }
        }

    }

