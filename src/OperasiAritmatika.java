interface OperasiAritmatika {
    int execute(int a, int b);
}

class Tambah implements OperasiAritmatika{

    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class Kurang implements OperasiAritmatika{

    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

class Kali implements OperasiAritmatika{

    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

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

class Context{
    private OperasiAritmatika Strategy;
    public Context(OperasiAritmatika Strategy){
        this.Strategy = Strategy;
    }

    public void setStrategy(OperasiAritmatika Strategy) {
        this.Strategy = Strategy;
    }

    public int ExecuteHitung(int a, int b){
        return Strategy.execute(a, b);
    }
}