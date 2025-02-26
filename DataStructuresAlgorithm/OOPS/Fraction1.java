package OOPS;
import java.util.*;
class Fraction {
    int n;
    int d;
    Fraction(int n1, int d1) {
        n=n1;
        d=d1;
    }
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
    public void add(Fraction f2) {
        n=n*f2.d+d*f2.n;
        d=d*f2.d;
        simplify();
    }
    public void multiply(Fraction f2){
        n=n*f2.n;
        d=d*f2.d;
        simplify();
    }
    public void simplify(){
        int gcd=gcd(n,d);
        n/=gcd;
        d/=gcd;
    }
    public void print(){
        System.out.println(n+"/"+d);
    }
}

public class Fraction1 {
    public static void main(String[] args) {
        Scanner o=new Scanner(System.in);
        int n1=o.nextInt();
        int d1=o.nextInt();
        Fraction f1=new Fraction(n1, d1);
        int t=o.nextInt();
        int n2,d2,ty;
        for(int i=0;i<t;i++){
            ty=o.nextInt();
            n2=o.nextInt();
            d2=o.nextInt();
            Fraction f2=new Fraction(n2, d2);
            if(ty==1){
                f1.add(f2);
                f1.print();
            } else {
                f1.multiply(f2);
                f1.print();
            }
        }
    }
}