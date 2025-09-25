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

                System.out.println("=======Welcome to KursusKu=========");
                int pilih;
                do{
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

                                            System.out.println("Tampilkan menu PESERTA");

                                            do {
                                                    System.out.println("1.Kursus");
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
                                                                    System.out.println("Daftar Kursus:");
                                                                    for (int i = 0; i < daftarKursus.size(); i++) {
                                                                        Kursus kursus = daftarKursus.get(i);
                                                                        System.out.println((i + 1) + ". " + kursus.toString());
                                                                    }
                                                                    break;

                                                            case 2:
                                                                    System.out.println("=======REGISTER=========");
                                                                    System.out.print("Masukkan nama: ");
                                                                    String nama = sc.next();
                                                                    System.out.print("Masukkan email: ");
                                                                    String email = sc.next();
                                                                    System.out.print("Masukkan password: ");
                                                                    String password = sc.next();
                                                                    System.out.print("Masukkan jenjang pendidikan: ");
                                                                    String jenjangPendidikan = sc.next();

                                                                    boolean emailSudahAda = false;
                                                                    for (User user : daftarUsers) {
                                                                        if (user.getEmail().equalsIgnoreCase(email)) {
                                                                            emailSudahAda = true;
                                                                            break;
                                                                        }
                                                                    }

                                                                    if (emailSudahAda) {
                                                                        System.out.println("Email sudah terdaftar. Silakan gunakan email lain.");
                                                                    } else {
                                                                        int nextId = daftarUsers.size() + 1;
                                                                        Peserta pesertaBaru = new Peserta(nextId, nama, email, password, jenjangPendidikan);
                                                                        daftarUsers.add(pesertaBaru);
                                                                        System.out.println("Registrasi berhasil sebagai Peserta!");
                                                                    }
                                                                    break;

                                                            default:
                                                                    break;
                                                    }
                                            } while (pilih2 == 0);

                                    } else if (userLogin instanceof Instruktur) {
                                            System.out.println("Tampilkan menu INSTRUKTUR");
                                        
                                    }

                                        break;
                                case 2:
                                    
                                        break;
                                case 0:
                                        System.out.println("Terima kasih telah menggunakan aplikasi KursusKu");
                                        break;
                                default:
                                        System.out.println("Pilihan tidak valid, silakan coba lagi.");
                                        break;
                        }
                } while(pilih == 0);


        }
}
