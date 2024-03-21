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