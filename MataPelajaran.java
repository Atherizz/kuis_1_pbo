import java.util.ArrayList;

public class MataPelajaran {
    private String nama;
    private String deskripsi;
    private ArrayList<Kursus> listKursus; 

    public MataPelajaran(String nama, String deskripsi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void tambahKursus(Kursus kursus) {
        listKursus.add(kursus);
    }

    public ArrayList<Kursus> getListKursus() {
        return listKursus;
    }

    public String toString() {
        String info = "Mata Pelajaran: " + nama + "\nDeskripsi: " + deskripsi + "\nDaftar Kursus:\n";
        for (Kursus kursus : listKursus) {
            info += "- " + kursus.getMataPelajaran().getNama() + " oleh " + kursus.getInstruktur().getNama() + "\n";
        }
        return info;
    }

}
