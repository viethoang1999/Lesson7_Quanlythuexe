package Models;

public class LoaiDichVu {
    private String maLoaiDichVu;
    private String tenLoaiDichVu;


    public LoaiDichVu() {
    }

    public String getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(String maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    @Override
    public String toString() {
        return  "- Mã loại dịch vụ: " + maLoaiDichVu +
                ", Tên loại dịch vụ: " + tenLoaiDichVu ;
    }
}
