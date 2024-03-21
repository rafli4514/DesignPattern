import java.util.Scanner;

public class Main {
    public static int tambah(int x, int y){
        return x + y;
    }

    public static int kurang(int x, int y){
        return x - y;
    }

    public static int kali(int x, int y){
        return x * y;
    }

    public static double bagi(int x, int y){
        if (y != 0){
            return x / y;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1.Penambahan");
        System.out.println("2.Pengurangan");
        System.out.println("3.Perkalian");
        System.out.println("4.Pembagian");

        System.out.println("Masukkan Pilihan menu");
        int menu = input.nextInt();

        System.out.println("Masukkan angka pertama: ");
        int x = input.nextInt();

        System.out.println("Masukkan angka kedua: ");
        int y = input.nextInt();

//        if (menu == 1){
//            System.out.println(x + " + " + y + " = " + tambah(x, y));
//        } else if (menu == 2) {
//            System.out.println(x + " - " + y + " = " + kurang(x, y));
//        } else if (menu == 3) {
//            System.out.println(x + " * " + y + " = " + kali(x, y));
//        } else if (menu == 4) {
//            System.out.println(x + " / " + y + " = " + bagi(x, y));
//        } else {
//            System.out.println("pilihan tidak valid");
//        }

        if (menu == 1){
            Context Penambahan = new Context(new Tambah());
            System.out.print(x + " + " + y + " = ");
            System.out.println(Penambahan.ExecuteHitung(x, y));
        } else if (menu == 2) {
            Context Pengurangan = new Context(new Kurang());
            System.out.print(x + " - " + y + " = ");
            System.out.println(Pengurangan.ExecuteHitung(x, y));
        } else if (menu == 3) {
            Context Perkalian = new Context(new Kali());
            System.out.print(x + " * " + y + " = ");
            System.out.println(Perkalian.ExecuteHitung(x, y));
        } else if (menu == 4) {
            Context Pembagian = new Context(new Bagi());
            System.out.print(x + " / " + y + " = ");

            System.out.println(Pembagian.ExecuteHitung(x, y));
        } else {
            System.out.println("pilihan tidak valid");
        }



//        Context Pengurangan = new Context(new Kurang());
//        System.out.println("213 - 312 = " + Pengurangan.ExecuteHitung(213, 312));

//        Context Perkalian = new Context(new Kali());
//        System.out.println("23 x 41 = " + Perkalian.ExecuteHitung(23, 41));
//
//        Context Pembagian = new Context(new Bagi());
//        System.out.println("164 : 6 = " + Pembagian.ExecuteHitung(164, 6));

    }
}