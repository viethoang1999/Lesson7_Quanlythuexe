package Models;

public class MucPhi {
    private String maMucPhi;
    private String donGia;
    private String moTa;


    public MucPhi() {
    }

    public String getMaMucPhi() {
        return maMucPhi;
    }

    public void setMaMucPhi(String maMucPhi) {
        this.maMucPhi = maMucPhi;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return  "- Mã mức phí: " + maMucPhi +
                ", Đơn giá: " + donGia +
                ", Mô tả: " + moTa ;
    }
}
