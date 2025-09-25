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
                                                    System.out.println("2.Melihat Instruktur");
                                                    System.out.print("Pilih: ");
                                                    pilih2 = sc.nextInt();

                                                    switch (pilih2) {
                                                            case 1:

                                                                    break;

                                                            case 2:

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
                } while(pilih >= 0);


        }
}
