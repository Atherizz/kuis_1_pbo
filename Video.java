public class Video extends Konten {
    private int durasi;

public Video(String judul, Kursus kursus, String deskripsi, int durasi) {
    super(judul, kursus, deskripsi);
    this.durasi = durasi;
}

public void setDurasi(int durasi) {
    this.durasi = durasi;
}
public int getDurasi() {
    return durasi;
}

public void tampilkan(){
    System.out.println("Video: " + getJudul() + " dengan durasi (" + durasi + " Menit) " + getDeskripsi());
}

}
