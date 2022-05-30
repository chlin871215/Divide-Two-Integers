public class App {
    public static void main(String[] args) throws Exception {
        int signa = (int) (Math.random() * 10) + 1;
        int signb = (int) (Math.random() * 10) + 1;
        if (signa % 2 == 1) {
            signa = -1;
        }
        if (signb % 2 == 1) {
            signb = -1;
        }
        int rdividend = (int) (Math.random() * 1000) + 1;
        int rdivisor = (int) (Math.random() * 1000) + 1;
        int divans = divide(rdividend * signa, rdivisor * signb);
        System.out.println(String.valueOf(rdividend * signa));
        System.out.println(String.valueOf(rdivisor * signb));
        System.out.println(String.valueOf(divans));
    }

    public static int divide(int dividend, int divisor) {
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        if (ldivisor == 0)
            return Integer.MAX_VALUE;
        if (ldividend == 0 || ldividend < ldivisor)
            return 0;
        long lans = ldivide(ldividend, ldivisor);
        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private static long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor)
            return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}