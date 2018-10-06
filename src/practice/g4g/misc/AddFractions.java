package practice.g4g.misc;

import javafx.util.Pair;

public class AddFractions {

    private static int gcd(int n, int d) {
        if (d == 0) return n;
        return gcd(d, n%d);
    }

    private static Pair<Integer, Integer> add(int n1, int d1, int n2, int d2) throws DenominatorException{
        if (0 == d1 || 0 == d2) throw new DenominatorException("Denominator cannot be 0");
        int d = d1*d2;
        int n = n1*d2 + n2*d1;
        int gcd = gcd(n,d);
        return new Pair<>(n/gcd, d/gcd);
    }

    public static void main(String[] args) {
        int n1 = 5;
        int d1 = 17;
        int n2 = 13;
        int d2 = 21;
        Pair<Integer, Integer> fraction = null;
        try {
            fraction = add(n1,d1,n2,d2);
        } catch (DenominatorException de) {
            System.out.println(de.getMessage());
        }
        System.out.println(fraction);
    }

}

class DenominatorException extends Exception {
    public DenominatorException(String s) {
        super(s);
    }
}
