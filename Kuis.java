public class Kuis extends Konten{
    private int jumlahSoal;

    public Kuis(String judul, Kursus kursus, String deskripsi, int jumlahSoal) {
        super(judul, kursus, deskripsi);
        this.jumlahSoal = jumlahSoal;
    }

    public void setJumSoal(int jumlahSoal) {
        this.jumlahSoal = jumlahSoal;
    }

    public int getJumSoal() {
        return jumlahSoal;
    }

    public void tampilkan(){
        System.out.println("Kuis: " + getJudul() + " dengan jumlah soal (" + jumlahSoal + " Soal) " + getDeskripsi());
    }
}
