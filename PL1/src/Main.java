import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(sameString("123"));
        System.out.println(reverseString("123"));
        System.out.println(productAlgorithm(8, 3));
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(5);
        l.add(21);
        l.add(12);
        l.add(3);
        l.add(7);
        l.add(10);
        System.out.println(maximumElement(l));
        System.out.println(mdc(48, 30));
        System.out.println(convertString("12345"));
    }

    //1a)
    public static String sameString(String s) {
        if (s.length() == 0) return "";
        return s.charAt(0) + sameString(s.substring(1));
    }

    //1b)
    public static String reverseString(String s) {
        if (s.length() == 0) return "";
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }

    //2a)
    public static int productAlgorithm(int m, int n) {
        if (n == 0 || m == 0) return 0;
        if (n == 1) return m;
        if (m == 1) return n;
        return m + productAlgorithm(m, n - 1);
    }

    //2b)
    public static int maximumElement(ArrayList<Integer> l) {
        if (l.size() == 0) return 0;
        if (l.size() == 1) return l.get(0);
        if (l.get(0) >= l.get(1)) {
            l.remove(1);
        } else {
            l.remove(0);
        }
        return maximumElement(l);
    }

    //2c)
    public static int mdc(int a, int b) {
        if (b == 0) return a;
        return mdc(b, a % b);
    }

    //2d)
    public static int convertString(String s) {
        if (s.length() == 0) return 0;
        return (int) (Integer.parseInt("" + s.charAt(0)) * Math.pow(10, s.length() - 1)) + convertString(s.substring(1));
    }
}
