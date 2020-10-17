package 数值的整数次方;

public class Solution {
    public double Power(double base, int exponent) {
        if (base == 0.0 && exponent == 0) {
            return 0;
        }
        if (exponent == 1) {
            return 1;
        }
        int e = 0;
        if (exponent > 0) {
            e = exponent;
        } else {
            e = -exponent;
        }
        double ret = 1.0;
        for (int i = 0;i < e;i++) {
            ret *= base;
        }
        if (exponent > 0) {
            return ret;
        } else {
            return 1/ret;
        }
    }
}
