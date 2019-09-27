package leetcode;

public class DivideInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(divide(1,1));

	}
	
	
    public static int divide(int dividend, int divisor) {
        Boolean isOutputPositive;
        if(dividend == 0) return 0;
        if((dividend <0 && divisor<0) || (dividend >0 && divisor>0)) isOutputPositive = true;
        else isOutputPositive = false;
        
        int pDivident, pDivisor;
        if(dividend<0) pDivident = dividend - dividend - dividend;
        else pDivident = dividend;
        if(divisor<0) pDivisor = divisor - divisor - divisor;
        else pDivisor = divisor;
        
        if(pDivident < pDivisor) return 0;
        if(pDivident == pDivisor) return 0;
        
        int q =0;
        while(pDivident >= pDivisor){
            pDivident = pDivident - pDivisor;
            q++;
        }
        
        if(!isOutputPositive) q = q-q-q;
        return q;
    }

}
