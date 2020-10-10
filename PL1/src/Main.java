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

        System.out.println(isPalindrome(1235321));

        int[][] a = {{1, 2}, {3, 4}};
        int x = 0;
        int y = 0;
        int z = 0;
        System.out.println(sumAllElements(a, x, y, z));

        int[][] abc = {
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int[][] solved = labyrinth(abc, 0, 0);
        assert solved != null;
        for (int[] ints : solved) {
            for (int anInt : ints) {
                System.out.print(" " + anInt + " ");
            }
            System.out.println();
        }
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

    //2e)
    public static boolean isPalindrome(int i) {
        if (i < 10) return true;
        String aux = String.valueOf(i);
        int last = (Integer.parseInt(aux.charAt(aux.length() - 1) + ""));
        if (((int) (i / (Math.pow(10, (aux.length() - 1))))) != last) {
            return false;
        }
        return isPalindrome(i - ((int) (Math.pow(10, (aux.length()))) * (Integer.parseInt(aux.charAt(0) + ""))) - last);
    }

    //2f)
    public static int sumAllElements(int[][] a, int x, int y, int z) {
        if (x == a.length || y == a.length || z == a.length) return 0;
        int soma = a[x][z] + a[y][z];
        x++;
        y++;
        z++;
        return soma + sumAllElements(a, x, y, z);
    }

    //3)
    public static int[][] labyrinth(int[][] a, int x, int y) {

        a[x][y] = 9;

        if ((x == a.length - 1) && (y == a[0].length - 1)) {
            return a;
        }

        int[][] result;

        if ((x > 0) && (a[x - 1][y] == 1)) {
            result = labyrinth(a, x - 1, y);
            if (result != null) return result;
        }
        if ((x < a.length - 1) && (a[x + 1][y] == 1)) {
            result = labyrinth(a, x + 1, y);
            if (result != null) return result;
        }
        if ((y < a[0].length - 1) && (a[x][y + 1] == 1)) {
            result = labyrinth(a, x, y + 1);
            if (result != null) return result;
        }
        if ((y > 0) && (a[x][y - 1] == 1)) {
            result = labyrinth(a, x, y - 1);
            if (result != null) return result;
        }
        a[x][y] = 2;
        return null;
    }
}
