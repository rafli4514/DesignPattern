QuackBehavior: Interface untuk perilaku bersuara bebek, memiliki metode quack() untuk menghasilkan suara.
Quack: Implementasi QuackBehavior untuk suara bebek bersuara "Qwek-Qwek".
Squek: Implementasi QuackBehavior untuk suara bebek bersuara "Squek".
MuteQuack: Implementasi QuackBehavior untuk bebek bersuara "Tidak Bisa Bersuara".
FlyBehavior: Interface untuk perilaku terbang bebek, memiliki metode fly() untuk menunjukkan kemampuan terbang.
FlyWithWings: Implementasi FlyBehavior untuk bebek yang bisa terbang ("Terbang").
FlyNoWay: Implementasi FlyBehavior untuk bebek yang tidak bisa terbang ("Tidak Bisa Terbang").
FlyWithRocketPower: Implementasi FlyBehavior untuk bebek yang bisa terbang dengan roket ("Cool, Terbang Menggunakan Rocket").
Kelas Abstrak Duck:

Duck: Kelas abstrak untuk semua jenis bebek, memiliki:
Referensi ke objek QuackBehavior dan FlyBehavior.
Metode abstrak display() untuk menampilkan deskripsi bebek.
Metode default swim() untuk berenang ("Berenang").
Metode performQuack() dan performFly() untuk menjalankan perilaku Quack dan Fly.
Metode setQuackBehavior() dan setFlyBehavior() untuk mengubah perilaku Quack dan Fly.
Kelas Turunan Duck:

MallardDuck: Bebek Mallard dengan Quack bersuara dan FlyWithWings.
RedheadDuck: Bebek Redhead dengan Quack bersuara dan FlyWithWings.
RubberDuck: Bebek karet dengan Squek dan FlyNoWay.
WoodenDuck: Bebek kayu dengan Squek dan FlyNoWay.
ModelDuck: Bebek model dengan Squek dan FlyNoWay (dapat diubah).