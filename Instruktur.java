public class Instruktur extends User {
    private String nama;
    private String keahlian;

    Instruktur(String username, String email, String password, String nama, String keahlian) {
        super(username, email, password);
        this.nama = nama;
        this.keahlian = keahlian;
    }
    
    public String getNama() {
        return nama;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Instruktur: " + nama);
        System.out.println("Keahlian: " + keahlian);
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
    }

    


}
