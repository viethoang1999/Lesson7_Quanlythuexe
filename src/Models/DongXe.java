package Models;

public class DongXe {
    private String dongXe;
    private String hangXe;
    private int soChoNgoi;

    public DongXe() {
    }

    public String getDongXe() {
        return dongXe;
    }

    public void setDongXe(String dongXe) {
        this.dongXe = dongXe;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    @Override
    public String toString() {
        return  "- Dòng xe: " + dongXe +
                ", Hãng xe: " + hangXe +
                ", Số chỗ ngồi: " + soChoNgoi;
    }
}
