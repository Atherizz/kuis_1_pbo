import java.util.ArrayList;

public class Kursus {
    private String mataPelajaran;
    private ArrayList<Konten> daftarKonten;
    private Instruktur instruktur;
    private ArrayList<Peserta> daftarPeserta;
    private boolean isBerbayar;

    public Kursus(String mataPelajaran, Instruktur instruktur, boolean isBerbayar) {
        this.mataPelajaran = mataPelajaran;
        this.instruktur = instruktur;
        this.isBerbayar = isBerbayar;
        this.daftarKonten = new ArrayList<>();
        this.daftarPeserta = new ArrayList<>();
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public Instruktur getInstruktur() {
        return instruktur;
    }

    public boolean isBerbayar() {
        return isBerbayar;
    }

    public void tambahKonten(Konten konten) {
        daftarKonten.add(konten);
    }

    

}