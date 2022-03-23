/**
 * @description:
 * @author: rzcai
 * @time: 2022/3/22 17:16
 */

public class Proxy {
    public static void main(String[] args) {
        A a=new IA();
        a.printA();
        A pa=new PIA(a);
        pa.printA();

    }
}
interface A{
    public void printA();
}
class IA implements A{
    @Override
    public void printA() {
        System.out.println("A");
    }
}
class PIA implements A{
    private A a;
    public PIA(A a){
        this.a=a;
    }

    @Override
    public void printA() {
        System.out.println("我要输出A啦");
        a.printA();
        System.out.println("我已经输出A啦");
    }
}
