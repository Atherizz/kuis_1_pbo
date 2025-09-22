public class Konten {
    private String judul;
    private Kursus kursus;
    private String deskripsi;

    public Konten(String judul, Kursus kursus, String deskripsi) {
        this.judul = judul;
        this.kursus = kursus;
        this.deskripsi = deskripsi;
    }

    public String getJudul(){
        return judul;
    }

    public String getKurus(){
        return kursus.getMataPelajaran();
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public void setJudul(String judul){
        this.judul = judul;
    }

    public void setKursus(Kursus kursus){
        this.kursus = kursus;
    }

    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }

    public void tampilkan(){

    }
}