package OOPS;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Polynomial {
    public int[] coef;
    public Polynomial(int coef, int degree) {
        this.coef=new int[degree+1];
        this.coef[degree]=coef;
    }
    public Polynomial(Polynomial p) {
        this.coef=Arrays.copyOf(p.coef, p.coef.length);
    }
    Polynomial plus(Polynomial p) {
        Polynomial res = new Polynomial(0, Math.max(this.degree(), p.degree()));
        for (int i = 0; i <= this.degree(); i++) {
            res.coef[i] += this.coef[i];
        }
        for (int i = 0; i <= p.degree(); i++) {
            res.coef[i] += p.coef[i];
        }
        return res;
    }
    public Polynomial minus(Polynomial p) {
        Polynomial res = new Polynomial(0, Math.max(this.degree(), p.degree()));
        for (int i = 0; i <= this.degree(); i++) {
            res.coef[i] += this.coef[i];
        }
        for (int i = 0; i <= p.degree(); i++) {
            res.coef[i] -= p.coef[i];
        }
        return res;
    }
    public Polynomial times(Polynomial p) {
        Polynomial res = new Polynomial(0, this.degree() + p.degree());
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= p.degree(); j++) {
                res.coef[i + j] += (this.coef[i] * p.coef[j]);
            }
        }
        return res;
    }
    public int degree() {
        int d = coef.length - 1;
        while (d > 0 && coef[d] == 0) {
            d--;
        }
        return d;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (coef[0] != 0) sb.append(coef[0]);
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] == 0) continue;
            if (coef[i] >0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
            } else if (coef[i]<0&&i!=1) {
                sb.append(" "+"-");
            } else {
                sb.append("-");
            }
            if (Math.abs(coef[i]) >=1||i>=0||i<0 ) {
                sb.append(Math.abs(coef[i]));
            }
            if (i >= 0) {
                sb.append("x");
            }
            if (i >= 1) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

}

public class Inheritance {
    public static void main( String[] args ) throws IOException {
        int count1;
        int count2;
        int choice;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count1 = Integer.parseInt(br.readLine().split(" ")[0]);
        int[] degree1 = new int[count1];
        int[] coeff1 = new int[count1];
        String[] nm = br.readLine().split(" ");
        for (int i = 0; i < count1; i++) {
            degree1[i] = Integer.parseInt(nm[i]);
        }
        nm = br.readLine().split(" ");
        for (int i = 0; i < count1; i++) {
            coeff1[i] = Integer.parseInt(nm[i]);
        }
        Polynomial first = new Polynomial(0,0);
        for (int i = 0; i < count1; i++) {
            first = first.plus(new Polynomial(coeff1[i],degree1[i]));
        }
        count2 = Integer.parseInt(br.readLine().split(" ")[0]);
        int[] degree2 = new int[count2];
        int[] coeff2 = new int[count2];
        nm = br.readLine().split(" ");
        for (int i = 0; i < count2; i++) {
            degree2[i] = Integer.parseInt(nm[i]);
        }
        nm = br.readLine().split(" ");
        for (int i = 0; i < count2; i++) {
            coeff2[i] = Integer.parseInt(nm[i]);
        }
        Polynomial second = new Polynomial(0,0);
        for (int i = 0; i < count2; i++) {
            second = second.plus(new Polynomial(coeff2[i],degree2[i]));
        }
        choice = Integer.parseInt(br.readLine().split(" ")[0]);
        Polynomial result = new Polynomial(0,0);
        switch (choice) {
            // Add
            case 1 : {
                result = first.plus(second);
                System.out.println(result);
                break;
            }
            // Subtract
            case 2 : {
                result = first.minus(second);
                System.out.println(result);
                break;
            }
            // Multiply
            case 3 : {
                result = first.times(second);
                System.out.println(result);
                break;
            }
            case 4 : // Copy constructor
            {
                Polynomial third = new Polynomial(first);
                if (third.coef == first.coef) {
                    System.out.println("false");
                } else {
                    System.out.println("true");
                }
                break;
            }
            // Copy assignment operator
            case 5 : {
                Polynomial fourth = new Polynomial(first);
                if (fourth.coef == first.coef) {
                    System.out.println("false");
                } else {
                    System.out.println("true");
                }
                break;
            }
        }
    }
}