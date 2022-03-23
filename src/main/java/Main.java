public class Main {
    public static <T> void out(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Integer a=128;
        Integer b=128;
        System.out.println(a==b);
        String S1="123";
        String S2=new String("123");
        out(S2=S1);
        parent p=new son();
        p.fun1();
        p.fun2();
    }
}


class parent{
    void fun1(){
        System.out.println("parent fun1");
    }
    void fun2(){
        System.out.println("parent fun2");
    }
}

class son extends parent{
    void fun1(String a){
        System.out.println("son fun1");

    }
    void fun2(){
        System.out.println("son fun2");
    }
}