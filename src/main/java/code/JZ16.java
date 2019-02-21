package code;

public class JZ16 {

    public double Power(double base, int exponent) {
        double result = 1;
        if (Double.compare(base, 0) == 0) {
            return 0;
        }
        if (Double.compare(exponent, 0) == 0) {
            return 1;
        }
        // base 和 exponent 都大于 0
        if (Double.compare(base, 0) == 1 && Double.compare(exponent, 0) == 1) {
            for (int i=0; i<exponent; i++) {
                result *= base;
            }
        }
        // base > 0 , exponent < 0
        if (Double.compare(base, 0) == 1 && Double.compare(exponent, 0) == -1) {
            for (int i=0; i<(-exponent); i++) {
                result /= base;
            }
        }
        // base < 0 , exponent > 0
        if (Double.compare(base, 0) == -1 && Double.compare(exponent, 0) == 1) {
            for (int i=0; i<exponent; i++) {
                result *= base;
            }
        }
        // base < 0, exponent < 0
        if (Double.compare(base, 0) == -1 && Double.compare(exponent, 0) == -1) {
            for (int i=0; i<(-exponent); i++) {
                result /= base;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new JZ16().Power(-2,-2));
    }
}
