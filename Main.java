import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Kursus> daftarKursus = new ArrayList<>();
    static ArrayList<Konten> daftarKonten = new ArrayList<>();
    static ArrayList<MataPelajaran> daftarMataPelajaran = new ArrayList<>();
    static ArrayList<User> daftarUsers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        InisiasiObjek.initiateObject(daftarKursus, daftarKonten, daftarMataPelajaran, daftarUsers);

        int pilih;
        do {
            System.out.println("=======Welcome to KursusKu=========");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("=======LOGIN=========");
                    System.out.print("Masukkan email : ");
                    String inputEmail = sc.next();

                    System.out.print("Masukkan password : ");
                    String inputPassword = sc.next();

                    User userLogin = null;

                    for (User user : daftarUsers) {
                        if (user.getEmail().equalsIgnoreCase(inputEmail)) {
                            if (user.authenticate(inputPassword)) {
                                userLogin = user;

                            }
                        }
                    }

                    if (userLogin instanceof Peserta) {

                        int pilih2;
                        do {
                            System.out.println("===== Tampilkan menu PESERTA =====");
                            System.out.println("1. Kursus");
                            System.out.println("2. Pendaftaran Kursus");
                            System.out.println("3. Kursus Saya");
                            System.out.println("4. Cek Saldo");
                            System.out.println("5. Isi Saldo");
                            System.out.println("6. Informasi Peserta");
                            System.out.println("0. Logout");
                            System.out.print("Pilih: ");
                            pilih2 = sc.nextInt();

                            switch (pilih2) {
                                case 1:
                                    System.out.printf("%-3s | %-3s | %-30s | %-18s | %-10s | %-10s%n",
                                            "No", "ID", "Nama Kursus", "Kategori", "Instruktur", "Harga");
                                    System.out.println(
                                            "------------------------------------------------------------------------------------------------");

                                    for (int i = 0; i < daftarKursus.size(); i++) {
                                        System.out.printf("%-3d | ", (i + 1));
                                        daftarKursus.get(i).toString();
                                        System.out.println();
                                    }

                                    break;

                                case 2:
                                    System.out.println("===== Pendaftaran Kursus =====");
                                    System.out.println();
                                    System.out.print("Masukkan nomor kursus yang ingin didaftarkan: ");
                                    System.out.println();
                                    int nomorKursus = sc.nextInt();
                                    if (nomorKursus > 0 && nomorKursus <= daftarKursus.size()) {
                                        Kursus kursusDipilih = daftarKursus.get(nomorKursus - 1);
                                        ((Peserta) userLogin).pendaftaranKursus(kursusDipilih);
                                        System.out.println();
                                    } else {
                                        System.out.println("Nomor kursus tidak valid.");
                                        System.out.println();
                                    }
                                    break;
                                case 3:
                                    System.out.println("Kursus Saya:");
                                    ArrayList<Kursus> kursusSaya = ((Peserta) userLogin).getDaftarKursus();
                                    if (kursusSaya.isEmpty()) {
                                        System.out.println("Anda belum mendaftar di kursus apapun.");
                                    } else {
                                        for (Kursus kursus : kursusSaya) {
                                            System.out.println("- " + kursus.toString());
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Saldo Anda: Rp" + ((Peserta) userLogin).getSaldo());
                                    break;
                                case 5:
                                    System.out.print("Masukkan jumlah saldo yang ingin diisi: \n");
                                    int nominal;
                                    for (;;) {
                                        System.out.print("Masukkan Nominal Saldo : Rp ");
                                        nominal = sc.nextInt();
                                        System.out.println();
                                        if (nominal < 0) {
                                            System.out.println("Saldo tidak boleh negatif!");
                                            System.out.println();
                                        } else {
                                            userLogin.setSaldo(nominal);
                                            break;
                                        }
                                    }
                                    break;
                                case 6:
                                    System.out.println("Informasi Peserta:");
                                    ((Peserta) userLogin).tampilkanInfo();
                                    break;
                                case 0:
                                    System.out.println("Logout berhasil.");
                                    break;
                                default:
                                    break;
                            }
                        } while (pilih2 != 0);

                    } else if (userLogin instanceof Instruktur) {
                        int pilih3;

                        do {
                            System.out.println("Tampilkan menu INSTRUKTUR");
                            System.out.println("=== MENU INSTRUKTUR ===");
                            System.out.println("1. Kursus Saya");
                            System.out.println("2. Cek Saldo");
                            System.out.println("3. Informasi User");
                            System.out.println("4. Tambah Kursus");
                            System.out.println("0. Logout");
                            System.out.print("Pilih: ");
                            pilih3 = sc.nextInt();
                            switch (pilih3) {
                                case 1:
                                    Instruktur instruktur = (Instruktur) userLogin;
                                    ArrayList<Kursus> kursusInstruktur = instruktur.getDaftarKursus();
                                    if (kursusInstruktur.isEmpty()) {
                                        System.out.println("Anda belum memiliki kursus.");
                                    } else {
                                        System.out.println("Kursus Anda:");
                                        for (Kursus kursus : kursusInstruktur) {
                                            System.out.println("- " + kursus.toString());
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("cek saldo instruktur :" + userLogin.getName());
                                    System.out.println("saldo anda adalah : " + userLogin.getSaldo());

                                    break;
                                case 3:
                                    instruktur = (Instruktur) userLogin;
                                    instruktur.tampilkanInfo();
                                    break;
                                case 4:
                                    System.out.println("== TAMBAH KURSUS ==");
                                    sc.nextLine();
                                    System.out.print("judul : ");
                                    String judulKurs = sc.nextLine();

                                    System.out.print("Pilih Mata Pelajaran");
                                    for (int i = 0; i < daftarMataPelajaran.size(); i++) {
                                        MataPelajaran m = daftarMataPelajaran.get(i);
                                        System.out.print(m.getId() + " - " + m.getNama());
                                    }

                                    MataPelajaran mapel = null;
                                    do {
                                        System.out.print("ID Mapel: ");
                                        int idMapel = sc.nextInt();
                                        mapel = null;

                                        for (int i = 0; i < daftarMataPelajaran.size(); i++) {
                                            MataPelajaran m = daftarMataPelajaran.get(i);
                                            if (m.getId() == idMapel) {
                                                mapel = m;
                                                break;
                                            }
                                        }

                                        if (mapel == null) {
                                            System.out.println("ID Mapel tidak ditemukan. Coba lagi.");
                                        }
                                    } while (mapel == null);

                                    boolean isBerbayar = false;
                                    while (true) {
                                        System.out.print("Apakah kursus berbayar? (y/n): ");
                                        String yn = sc.next();
                                        if (yn.equals("y")) {
                                            isBerbayar = true;
                                            break;
                                        }
                                        if (yn.equals("n")) {
                                            isBerbayar = false;
                                            break;
                                        }
                                        System.out.println("input harus y/n");

                                int harga = 0;
                                if (isBerbayar) {
                                while (true){
                                    System.out.println("masukkan harga: ");
                                    harga = sc.nextInt();
                                    if (harga >= 0) {
                                        break;
                                    } else {
                                        System.out.println("Harga tidak boleh negatif!");
                                    }
                                }
                            }

                                int newww = daftarKursus.size() + 1;
                                Kursus baru = new Kursus(newww, judulKurs, mapel, ((Instruktur) userLogin), isBerbayar);
                                baru.setHarga(isBerbayar ? harga : 0);
                                daftarKursus.add(baru);

                                System.out.println("\nKursus berhasil dibuat!");
                                System.out.println("- ID        : " + newww);
                                System.out.println("- Judul     : " + judulKurs);
                                System.out.println("- Mapel     : " + mapel.getNama());
                                System.out.println("- Instruktur: " + userLogin.getName());
                                System.out.println("- Berbayar  : " + (isBerbayar ? "Ya" : "Tidak"));
                                if (isBerbayar)
                                    System.out.println("- Harga     : " + harga);
                                System.out.println();

                            }
                                    break;
                                default:
                                    break;
                            }

                        } while (pilih3 != 0);
                        System.out.println("Tampilkan menu INSTRUKTUR");

                    }

                    break;
                case 2:
                    System.out.println("======= REGISTER =======");
                    System.out.print("Masukkan nama: ");
                    String nama = sc.next();
                    System.out.print("Masukkan email: ");
                    String email = sc.next();
                    System.out.print("Masukkan password: ");
                    String password = sc.next();
                    System.out.print("Masukkan jenjang pendidikan: ");
                    String jenjangPendidikan = sc.next();
                    sc.nextLine();

                    boolean emailSudahAda = false;
                    for (User user : daftarUsers) {
                        if (user.getEmail().equalsIgnoreCase(email)) {
                            emailSudahAda = true;
                            break;
                        }
                    }

                    if (emailSudahAda) {
                        System.out.println("Email sudah terdaftar. Silakan gunakan email lain.");
                        System.out.println();
                    } else {
                        int nextId = daftarUsers.size() + 1;
                        Peserta pesertaBaru = new Peserta(nextId, nama, email, password, jenjangPendidikan);
                        daftarUsers.add(pesertaBaru);
                        System.out.println("Registrasi berhasil sebagai Peserta!");
                        System.out.println();
                    }

                    break;

                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi KursusKu");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
                    break;
            }
        } while (pilih != 3);

        sc.close();
    }
}
