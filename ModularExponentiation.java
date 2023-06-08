// https://www.codingninjas.com/codestudio/problems/modular-exponentiation_8230803?challengeSlug=striver-sde-challenge&leftPanelTab=0

public class ModularExponentiation {
    public static int modularExponentiation(int x, int n, int m) {
        return (int)(pow(x, n, m));       
    }
    
    public static long pow(int x, int n, int m) 
    {
        if(n == 0)
        return 1;

        long out = pow(x, n/2, m);

        if(n % 2 == 0)
        return (out * out) % m;

        else
        return (x * ((out * out) % m)) % m;
    }
}
