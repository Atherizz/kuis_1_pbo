import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Peserta peserta1 = new Peserta("budi", "budi@mail.com", "pass1", "S1 Informatika");
        Peserta peserta2 = new Peserta("sari", "sari@mail.com", "pass2", "SMA");
        Peserta peserta3 = new Peserta("doni", "doni@mail.com", "pass3", "S1 Sistem Informasi");
        Peserta peserta4 = new Peserta("lisa", "lisa@mail.com", "pass4", "S2 Teknik Informatika");
        Peserta peserta5 = new Peserta("agus", "agus@mail.com", "pass5", "Diploma TI");

        Instruktur instruktur1 = new Instruktur("andi123", "andi@mail.com", "passA", "Andi", "Pemrograman Java");
        Instruktur instruktur2 = new Instruktur("rani456", "rani@mail.com", "passB", "Rani", "Desain UI/UX");

        

        ArrayList<User> daftarUsers = new ArrayList<>();
        daftarUsers.add(peserta1);
        daftarUsers.add(peserta2);
        daftarUsers.add(peserta3);
        daftarUsers.add(peserta4);
        daftarUsers.add(peserta5);
        daftarUsers.add(instruktur1);
        daftarUsers.add(instruktur2);

        System.out.println("=======LOGIN=========");
        System.out.print("Masukkan email : ");
        String inputEmail = sc.next();

        System.out.print("Masukkan password : ");
        String inputPassword = sc.next();

        User userLogin = null;
        
        for (User user : daftarUsers) {
            if (user.getEmail().equalsIgnoreCase(inputEmail)) {
                if(user.authenticate(inputPassword)) {
                    userLogin = user; 

                }
            }
        }

        if (userLogin instanceof Peserta) {
            int pilih;

            System.out.println("Tampilkan menu PESERTA");

            do{
                System.out.println("1.Kursus");
                System.out.println("2.Melihat Instruktur");
                System.out.print("Pilih: ");
                pilih=sc.nextInt();

                switch (pilih) {
                case 1:
                    
                    break;
                
                case 2:

                    break;
            
                default:
                    break;
            }
            }while (pilih==0);
            

        } else if (userLogin instanceof Instruktur) {
            System.out.println("Tampilkan menu INSTRUKTUR");
        }


    }
}
