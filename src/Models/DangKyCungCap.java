package Models;

import java.sql.Timestamp;

public class DangKyCungCap {
    private String maDangKyCungCap;
    private Timestamp ngayBatDauCungCap;
    private Timestamp ngayKetThucCungCap;
    private Integer soLuongXeDangKy;
    private String maLoaiDichVu;
    private String dongXe;
    private String hangXe;
    private String maMucPhi;
    private Integer donGia;
    private Integer soLanDangKy;
    private String maNhaCungCap;
    private String tenNhaCungCap;
    private String diaChiNhaCungCap;
    private String maSoThueNhaCungCap;
    private String tenLoaiDichVu;

    public DangKyCungCap() {
    }

    public String getMaDangKyCungCap() {
        return maDangKyCungCap;
    }

    public void setMaDangKyCungCap(String maDangKyCungCap) {
        this.maDangKyCungCap = maDangKyCungCap;
    }

    public Timestamp getNgayBatDauCungCap() {
        return ngayBatDauCungCap;
    }

    public void setNgayBatDauCungCap(Timestamp ngayBatDauCungCap) {
        this.ngayBatDauCungCap = ngayBatDauCungCap;
    }

    public Timestamp getNgayKetThucCungCap() {
        return ngayKetThucCungCap;
    }

    public void setNgayKetThucCungCap(Timestamp ngayKetThucCungCap) {
        this.ngayKetThucCungCap = ngayKetThucCungCap;
    }

    public Integer getSoLuongXeDangKy() {
        return soLuongXeDangKy;
    }

    public void setSoLuongXeDangKy(Integer soLuongXeDangKy) {
        this.soLuongXeDangKy = soLuongXeDangKy;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(String maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getDongXe() {
        return dongXe;
    }

    public void setDongXe(String dongXe) {
        this.dongXe = dongXe;
    }

    public String getMaMucPhi() {
        return maMucPhi;
    }

    public void setMaMucPhi(String maMucPhi) {
        this.maMucPhi = maMucPhi;
    }

    public Integer getSoLanDangKy() {
        return soLanDangKy;
    }

    public void setSoLanDangKy(Integer soLanDangKy) {
        this.soLanDangKy = soLanDangKy;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    public String getDiaChiNhaCungCap() {
        return diaChiNhaCungCap;
    }

    public void setDiaChiNhaCungCap(String diaChiNhaCungCap) {
        this.diaChiNhaCungCap = diaChiNhaCungCap;
    }

    public String getMaSoThueNhaCungCap() {
        return maSoThueNhaCungCap;
    }

    public void setMaSoThueNhaCungCap(String maSoThueNhaCungCap) {
        this.maSoThueNhaCungCap = maSoThueNhaCungCap;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    @Override
    public String toString() {
        return  "- Mã đăng ký cung cấp: " + maDangKyCungCap +
                ", Ngày bắt đầu cung cấp: " + ngayBatDauCungCap +
                ", Ngày kết thúc cung cấp: " + ngayKetThucCungCap +
                ", Số lượng xe đăng ký: " + soLuongXeDangKy +
                ", Mã nhà cung cấp: " + maNhaCungCap +
                ", Mã loại dịch vụ: " + maLoaiDichVu +
                ", Dòng xe: " + dongXe +
                ", Mã mức phí: " + maMucPhi;
    }
}
