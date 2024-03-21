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