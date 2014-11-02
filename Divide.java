/*
Divide two integers without using multiplication, division and mod operator.
*/

public class Divide {
    public int divide(int dividend, int divisor) {
        long base = 1;
        long l_dividend=dividend,l_divisor=divisor,prefix=1;
        if(dividend<0){
            l_dividend = -l_dividend;
            prefix = -prefix;
        }
        if(divisor<0){
            l_divisor = -l_divisor;
            prefix = -prefix;
        }
        long org_divisor = l_divisor;
        long res = 0;
        while(l_dividend >= org_divisor && base>=1){
            if(l_dividend >= l_divisor){
                res += base;
                l_dividend -= l_divisor;
                base = base << 1;
                l_divisor = l_divisor << 1;
            }
            else{
                base = base >> 1;
                l_divisor = l_divisor >> 1;
            }
        }
        return (int)(prefix*res);
    }
}
