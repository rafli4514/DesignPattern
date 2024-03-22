# ANALISA FILE DUCK.JAVA

## ANALISA TAHAP 1:
Pada tahap 1, kita memiliki desain dasar berbasis OOP untuk kelas bebek dan beberapa turunannya:

```java
// kelas duck sebagai kelas dasar untuk semua jenis bebek
abstract class Duck{
    void quack(){
        System.out.println("Qwek Qwek");
    }

    void swim(){
        System.out.println("Berenang");
    }

    abstract void display();

    void fly(){
        System.out.println("Terbang");
    }
}

// kelas turunan Duck
class MallardDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedHeadDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

class RubberDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan RubberDuck");
    }

    @Override
    void quack() {
        System.out.println("Bunyinya squeek, bukan qwak");
    }

    @Override
    void fly() {
        // Tidak ada implementasi, karena bebek mainan tidak dapat terbang
    }
}

class WoodenDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan WoodenDuck");
    }

    @Override
    void quack() {
        // tidak ada implementasi, karena bebek kayu tidak dapat bersuara
    }

    @Override
    void swim() {
        System.out.println("Mengambang");
    }

    @Override
    void fly() {
        // Tidak ada implementasi, karena bebek kayu tidak dapat terbang
    }
}
```

1. Kelas Dasar Duck:

- Kelas Duck dianggap sebagai kelas dasar untuk semua jenis bebek.
- Memiliki metode quack(), swim(), display(), dan fly().
- Metode quack(), swim(), dan fly() memberikan implementasi default untuk perilaku bebek secara umum.
- Metode display() dideklarasikan sebagai metode abstrak, yang berarti kelas turunan harus mengimplementasikannya sesuai dengan jenis bebeknya.
  
2. Kelas Turunan MallardDuck, RedHeadDuck, RubberDuck, dan WoodenDuck:
- Setiap kelas turunan mengganti metode display() untuk menampilkan tampilan yang sesuai dengan jenis bebeknya.
- Beberapa kelas turunan, seperti RubberDuck dan WoodenDuck, mengganti perilaku dasar seperti - - quack() dan fly() sesuai dengan karakteristik unik mereka.

## ANALISA TAHAP 2:
Pada tahap kedua, kita melihat perbaikan desain dengan memisahkan perilaku bebek ke dalam antarmuka (interface) Quackable dan Flyable. Ini dikarenakan class memiliki cara bersuara dan terbang berbeda-beda dan juga terdapat class tidak bisa bersuara dan terbang. 

```java
interface Quackable{
    void quack();
}

interface Flyable{
    void fly();
}

abstract class Duck{
    void swim(){
        System.out.println("Berenang");
    }

    abstract void display();
}

// kelas turunan Duck
class MallardDuck extends Duck implements Quackable, Flyable{
    @Override
    public void quack() {
        System.out.println("Qwek Qwek");
    }

    @Override
    public void fly() {
        System.out.println("Terbang");
    }

    @Override
    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedHeadDuck extends Duck implements Quackable, Flyable{
    @Override
    public void quack() {
        System.out.println("Qwek Qwek");
    }

    @Override
    public void fly() {
        System.out.println("Terbang");
    }

    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }


}

class RubberDuck extends Duck implements Quackable{
    @Override
    void display() {
        System.out.println("Tampilan RubberDuck");
    }

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

class WoodenDuck extends Duck{
    @Override
    void display() {
        System.out.println("Tampilan WoodenDuck");
    }

    @Override
    void swim() {
        System.out.println("Mengambang");
    }

}

class ToyDUck extends Duck implements Flyable{

    @Override
    public void fly() {
        System.out.println("Terbang seperti mainan");
    }

    @Override
    void display() {
        System.out.println("Tampilan ToyDuck");
    }
}
```

1. Antarmuka Quackable dan Flyable:
- Menggambarkan perilaku yang dapat diimplementasikan oleh kelas bebek.
- Setiap antarmuka memiliki satu metode yaitu quack() dan fly().

2. Kelas Dasar Duck:
- Sekarang tidak ada implementasi default untuk quack() dan fly() di kelas dasar Duck.
- Metode swim() masih didefinisikan di kelas dasar karena perilaku ini umum untuk semua jenis bebek.
- Metode display() tetap menjadi metode abstrak, memaksa kelas turunan untuk mengimplementasikannya.

3. Kelas Turunan:
- Kelas turunan seperti MallardDuck dan RedHeadDuck mewarisi perilaku quack() dan fly() melalui implementasi antarmuka Quackable dan Flyable.
- Kelas RubberDuck hanya mengimplementasikan Quackable, karena bebek karet hanya dapat bersuara.
- Kelas WoodenDuck tidak mengimplementasikan antarmuka apa pun, karena bebek kayu tidak bisa terbang atau bersuara.
- Kelas ToyDuck hanya mengimplementasikan Flyable, menunjukkan variasi perilaku yang dapat diimplementasikan oleh bebek mainan.

## ANALISA TAHAP 3:
Pada tahap ketiga, desain menggunakan strategy pattern dengan memisahkan perilaku bebek ke dalam kelas-kelas strategi yang terpisah, yang membuat kode menjadi lebih modular dan memungkinkan untuk mengganti perilaku dengan lebih mudah. Ini dikarenakan implementasi pada tahap kedua terlihat lebih sulit dibaca dan membingungkan, terutama ketika mendefinisikan beberapa kelas bebek yang mengimplementasikan antarmuka Quackable dan Flyable.

```java
// Interface untuk perilaku bersuara (Quacking)
interface QuackBehavior {
    void quack(); // Metode untuk menghasilkan suara bebek
}

// Interface untuk perilaku terbang (Flying)
interface FlyBehavior {
    void fly(); // Metode untuk menampilkan kemampuan terbang bebek
}

// Implementasi Quack (suara bebek)
class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Qwek - Qwek"); // Mencetak suara bebek
    }
}

// Implementasi Quack untuk bebek karet
class Squek implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squek"); // Mencetak suara squek untuk bebek karet
    }
}

// Implementasi Quack untuk bebek bisu (tidak bersuara)
class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Tidak Bisa Bersuara"); // Mencetak pesan bebek tidak bisa bersuara
    }
}

// Implementasi Fly untuk yang bisa terbang
class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Terbang"); // Mencetak pesan bebek bisa terbang
    }
}

// Implementasi Fly untuk bebek yang tidak bisa terbang
class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Tidak Bisa Terbang"); // Mencetak pesan bebek tidak bisa terbang
    }
}

// Implementasi Fly untuk bebek dengan kekuatan roket
class FlyWithRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Cool, Terbang Menggunakan Rocket"); // Mencetak pesan bebek terbang dengan roket
    }
}

// Kelas abstrak untuk Duck
abstract class Duck {
    // Referensi ke objek untuk perilaku bersuara dan terbang
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    // Metode abstrak untuk menampilkan deskripsi bebek
    abstract void display();

    // Metode default untuk berenang
    void swim() {
        System.out.println("Berenang");
    }

    // Metode untuk melakukan Quack
    void performQuack() {
        quackBehavior.quack();
    }

    // Metode untuk melakukan Fly
    void performFly() {
        flyBehavior.fly();
    }

    // Metode untuk mengubah perilaku bersuara bebek
    void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    // Metode untuk mengubah perilaku terbang bebek
    void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }
}

// Kelas turunan Duck untuk bebek Mallard
class MallardDuck extends Duck {
    // Konstruktor untuk bebek Mallard
    public MallardDuck() {
        // Menyetel perilaku Quack ke Quack
        quackBehavior = new Quack();

        // Menyetel perilaku Fly ke FlyWithWings
        flyBehavior = new FlyWithWings();
    }

    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

// Kelas turunan Duck untuk bebek Redhead
class RedheadDuck extends Duck {
    // Konstruktor untuk bebek Redhead
    public RedheadDuck() {
        // Menyetel perilaku Quack ke Quack
        quackBehavior = new Quack();

        // Menyetel perilaku Fly ke FlyWithWings
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

// Kelas turunan Duck untuk bebek karet
class RubberDuck extends Duck {
    // Konstruktor untuk bebek karet
    public RubberDuck() {
        // Menyetel perilaku Quack ke Squek
        quackBehavior = new Squek();

        // Menyetel perilaku Fly ke FlyNoWay
        flyBehavior = new FlyNoWay();
    }

    void display() {
        System.out.println("Tampilan RubberDuck");
    }
}

// Kelas turunan Duck untuk bebek kayu
class WoodenDuck extends Duck {
    // Konstruktor untuk bebek kayu
    public WoodenDuck() {
        // Menyetel perilaku Quack ke Squek
        quackBehavior = new Squek();

        // Menyetel perilaku Fly ke FlyNoWay
        flyBehavior = new FlyNoWay();
    }

    void display() {
        System.out.println("Tampilan WoodenDuck");
    }
}

// Kelas turunan Duck untuk bebek model
class ModelDuck extends Duck{
    ModelDuck(){
        // Menyetel perilaku Quack ke Squek
        quackBehavior = new Squek();
        // Menyetel perilaku Fly ke FlyNoWay
        flyBehavior = new FlyNoWay();
    }

    void display() {
        System.out.println("Tampilan ToyDuck");
    }
}
```

1. Antarmuka QuackBehavior dan FlyBehavior:
- Menyediakan kontrak untuk perilaku quack dan fly yang berbeda.
- Setiap antarmuka memiliki satu metode, yaitu quack() dan fly(), yang harus diimplementasikan oleh kelas-kelas strategi.

2. Kelas Strategi Quack, Squeak, MuteQuack, FlyWithWings, FlyNoWay, dan FlyWithRocketPower:
- Mewakili variasi perilaku quack dan fly yang berbeda.
- Setiap kelas strategi mengimplementasikan metode sesuai dengan perilakunya.

3. Kelas Dasar Duck:
- Memiliki dua atribut quackBehavior dan flyBehavior yang bertindak sebagai objek-objek dari kelas strategi.
- Metode performQuack() dan performFly() memanggil metode yang sesuai dari objek strategi saat diperlukan.
- Metode setQuackBehavior() dan setFlyBehavior() memungkinkan pengaturan perilaku quack dan fly pada saat runtime.

4. Kelas Turunan:
- Setiap kelas turunan bebek seperti MallardDuck, RedheadDuck, RubberDuck, WoodenDuck, dan ModelDuck menetapkan perilaku quack dan fly melalui konstruktor mereka.
- Metode display() masih merupakan metode abstrak yang harus diimplementasikan oleh kelas turunan untuk menentukan tampilan spesifik bebek.

<h3>Pada file main.java, berisikan kode berikut</h3>

```java
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
System.out.println("// Merubah cara terbang");
modelDuck.setFlyBehavior(new FlyWithRocketPower());
modelDuck.performFly();
System.out.println("=====================");

Duck woodenDuck = new WoodenDuck();
woodenDuck.display();
System.out.println("=====================");
woodenDuck.performQuack();
System.out.println("// Merubah cara bersuara");
woodenDuck.setQuackBehavior(new MuteQuack());
woodenDuck.performQuack();
woodenDuck.performFly();
```

![App Screenshot](https://github.com/rafli4514/DesignPattern/blob/main/duck.png?raw=true)

# ANALISA FILE TUGAS.JAVA
Program ini mengimplementasikan strategy pattern dalam konteks operasi aritmatika.

```java
// Antarmuka untuk operasi aritmatika
interface OperasiAritmatika {
    int execute(int a, int b); // Metode untuk mengeksekusi operasi aritmatika
}

// Kelas implementasi untuk operasi penambahan
class Tambah implements OperasiAritmatika{
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

// Kelas implementasi untuk operasi pengurangan
class Kurang implements OperasiAritmatika{
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

// Kelas implementasi untuk operasi perkalian
class Kali implements OperasiAritmatika{
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

// Kelas implementasi untuk operasi pembagian
class Bagi implements OperasiAritmatika{
    @Override
    public int execute(int a, int b) {
        if (b != 0){
            return a / b;
        }
        else{
            throw new IllegalArgumentException("Tidak boleh dibagi dengan 0");
        }
    }
}

// Kelas Context, bertanggung jawab untuk menyimpan strategi dan mengeksekusi operasi aritmatika
class Context{
    private OperasiAritmatika Strategy; // Objek yang menyimpan strategi yang digunakan saat ini

    // Konstruktor untuk menginisialisasi objek Context dengan sebuah strategi
    public Context(OperasiAritmatika Strategy){
        this.Strategy = Strategy;
    }

    // Metode untuk mengubah strategi saat runtime
    public void setStrategy(OperasiAritmatika Strategy) {
        this.Strategy = Strategy;
    }

    // Metode untuk mengeksekusi operasi aritmatika dengan menggunakan strategi yang sedang aktif
    public int ExecuteHitung(int a, int b){
        return Strategy.execute(a, b);
    }
}
```

1. Antarmuka OperasiAritmatika:
- Ini adalah antarmuka yang mendefinisikan operasi aritmatika dasar, yaitu execute(int a, int b).
- Implementasi dari antarmuka ini akan memberikan perilaku spesifik untuk setiap operasi aritmatika.

2. Kelas Strategi:
- Masing-masing kelas ini mengimplementasikan antarmuka OperasiAritmatika.
- Setiap kelas ini memberikan perilaku khusus untuk operasi penambahan, pengurangan, perkalian, dan pembagian, sesuai dengan nama kelasnya.

3. Kelas Context:
- Kelas ini bertanggung jawab untuk menyimpan strategi yang sedang digunakan saat ini.
- Melalui metode setStrategy(), kelas ini memungkinkan untuk mengubah strategi pada saat runtime.
- Metode ExecuteHitung(int a, int b) digunakan untuk mengeksekusi operasi aritmatika dengan menggunakan strategi yang sedang aktif.

<h3>Pada file main.java, berisikan kode berikut</h3>

```java
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

        Context Pengurangan = new Context(new Kurang());
        System.out.println("213 - 312 = " + Pengurangan.ExecuteHitung(213, 312));

        Context Perkalian = new Context(new Kali());
        System.out.println("23 x 41 = " + Perkalian.ExecuteHitung(23, 41));

        Context Pembagian = new Context(new Bagi());
        System.out.println("164 : 6 = " + Pembagian.ExecuteHitung(164, 6));
```

![App Screenshot](https://github.com/rafli4514/DesignPattern/blob/main/tugas.png?raw=true)
