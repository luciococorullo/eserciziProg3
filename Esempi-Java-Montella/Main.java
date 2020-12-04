

class MyException extends Exception {
    private float _a;
    private float _b;

    public MyException(String message, float a, float b) {
        super(message+" (a="+a+", b="+b+")");
        this._a=a;
        this._b=b;
    }

    public float getA() {
        return _a;
    }

    public float getB() {
        return _b;
    }
}

public class Main  {

    public static void main(String[] args) throws MyException {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        A a = new A();
        B b = new B();
        Aable aa = new Aable() {
            @Override
            public float sum(float a, float b) {
                return 0;
            }
        };

        int z = a.sum(x,y);
        int k = b.sum(x,y);

        System.out.println(z+" "+k);



    }
}
