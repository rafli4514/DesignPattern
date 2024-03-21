interface QuackBehavior{
    void quack();
}

interface FlyBehavior{
    void fly();
}

class Quack implements QuackBehavior{
    @Override
    public void quack(){
        System.out.println("Qwek - Qwek");
    }
}

class Squek implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squek");
    }
}

class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Tidak Bisa Bersuara");
    }
}

class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Terbang");
    }
}

class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Tidak Bisa Terbang");
    }
}

class FkyWithRocketPower implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Cool, Terbang Menggunakan Rocket");
    }
}

abstract class Duck{
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    abstract void display();

    void swim(){
        System.out.println("Berenang");
    }

    void performQuack(){
        quackBehavior.quack();
    }

    void performFly(){
        flyBehavior.fly();
    }

    void setQuackBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    void setFlyBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }
}

// kelas turunan Duck
class MallardDuck extends Duck{
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    void display() {
        System.out.println("Tampilan MallardDuck");
    }
}

class RedheadDuck extends Duck{
    public RedheadDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("Tampilan RedHeadDuck");
    }
}

class RubberDuck extends Duck{
    public RubberDuck(){
        quackBehavior = new Squek();
        flyBehavior = new FlyNoWay();
    }

    void display() {
        System.out.println("Tampilan RubberDuck");
    }
}

class WoodenDuck extends Duck{
    public WoodenDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    void display() {
        System.out.println("Tampilan WoodenDuck");
    }
}

class ModelDuck extends Duck{
    ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    void display() {
        System.out.println("Tampilan ToyDuck");
    }
}