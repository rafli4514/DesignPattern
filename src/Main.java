import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        System.out.println("=====================");
        mallard.performFly();
        mallard.performQuack();
        System.out.println("=====================");

        Duck modelDuck = new ModelDuck();
        modelDuck.display();
        System.out.println("=====================");
        modelDuck.performQuack();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyWithRocketPower());
        modelDuck.performFly();
        System.out.println("=====================");

        Duck woodenDuck = new WoodenDuck();
        woodenDuck.display();
        System.out.println("=====================");
        woodenDuck.performQuack();
        woodenDuck.setQuackBehavior(new MuteQuack());
        woodenDuck.performQuack();
        woodenDuck.performFly();

//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Menu");
//        System.out.println("1.Penambahan");
//        System.out.println("2.Pengurangan");
//        System.out.println("3.Perkalian");
//        System.out.println("4.Pembagian");
//
//        System.out.println("Masukkan Pilihan menu");
//        int menu = input.nextInt();
//
//        System.out.println("Masukkan angka pertama: ");
//        int x = input.nextInt();
//
//        System.out.println("Masukkan angka kedua: ");
//        int y = input.nextInt();

//        if (menu == 1){
//            Context Penambahan = new Context(new Tambah());
//            System.out.print(x + " + " + y + " = ");
//            System.out.println(Penambahan.ExecuteHitung(x, y));
//        } else if (menu == 2) {
//            Context Pengurangan = new Context(new Kurang());
//            System.out.print(x + " - " + y + " = ");
//            System.out.println(Pengurangan.ExecuteHitung(x, y));
//        } else if (menu == 3) {
//            Context Perkalian = new Context(new Kali());
//            System.out.print(x + " * " + y + " = ");
//            System.out.println(Perkalian.ExecuteHitung(x, y));
//        } else if (menu == 4) {
//            Context Pembagian = new Context(new Bagi());
//            System.out.print(x + " / " + y + " = ");
//
//            System.out.println(Pembagian.ExecuteHitung(x, y));
//        } else {
//            System.out.println("pilihan tidak valid");
//        }

//        Context Pengurangan = new Context(new Kurang());
//        System.out.println("213 - 312 = " + Pengurangan.ExecuteHitung(213, 312));

//        Context Perkalian = new Context(new Kali());
//        System.out.println("23 x 41 = " + Perkalian.ExecuteHitung(23, 41));
//
//        Context Pembagian = new Context(new Bagi());
//        System.out.println("164 : 6 = " + Pembagian.ExecuteHitung(164, 6));
    }
}