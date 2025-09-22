import java.util.ArrayList;

public class Kursus {
    private MataPelajaran mataPelajaran;
    private ArrayList<Konten> daftarKonten;
    private Instruktur instruktur;
    private ArrayList<Peserta> daftarPeserta;
    private boolean isBerbayar;
    private int harga = 0;


    public Kursus(MataPelajaran mataPelajaran, Instruktur instruktur, boolean isBerbayar) {
        this.mataPelajaran = mataPelajaran;
        this.instruktur = instruktur;
        this.isBerbayar = isBerbayar;
        this.daftarKonten = new ArrayList<>();
        this.daftarPeserta = new ArrayList<>();
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public MataPelajaran getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(MataPelajaran mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public Instruktur getInstruktur() {
        return instruktur;
    }

    public void setInstruktur(Instruktur instruktur) {
        this.instruktur = instruktur;
    }

    public boolean getIsBerbayar() {
        return isBerbayar;
    }

    public ArrayList<Peserta> getDaftarPeserta() {
        return daftarPeserta;
    }

    public void setBerbayar(boolean berbayar) {
        isBerbayar = berbayar;
    }

    public void tambahKonten(Konten konten) {
        daftarKonten.add(konten);
    }

    public String toString() {
        String info = "";
        info += "Mata Pelajaran: " + mataPelajaran.getNama() + "\n";
        info += "Instruktur: " + instruktur.getNama() + "\n";   
        info += "Daftar Konten:\n";
        for (Konten konten : daftarKonten) {
            info += "- " + konten.getJudul() + "\n";
        }
        return info;
    }

    

}