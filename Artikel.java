public class Artikel extends Konten{
    private String penulis;

    public Artikel(String judul, Kursus kursus, String deskripsi, String penulis) {
        super(judul, kursus, deskripsi);
        this.penulis = penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
    public String getPenulis() {
        return penulis;
    }

    public void tampilkan(){
        System.out.println("Artikel: " + getJudul() + " di rilis oleh " + penulis + " " + getDeskripsi());
    }
}
