public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        int i = n;
        while (i > 1) {
            if (i % 2 != 0) return false;
            i = i >> 1;
        }
        return true;
    }

    public boolean isPowerOfTwoSimple(int n) {
        if ((n & (n - 1)) == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        PowerOfTwo t = new PowerOfTwo();
        System.out.println(t.isPowerOfTwoSimple(16));
    }
}
