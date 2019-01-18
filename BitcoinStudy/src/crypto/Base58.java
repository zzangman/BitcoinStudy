package crypto;

import java.math.BigInteger;

public class Base58  
{ 
 private static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"; 
    private static final BigInteger BASE = BigInteger.valueOf(58); 
     
 private Base58() 
 { 
  // The constructor of this class is private in order to prevent the class being instantiated 
 }  
     
    public static String encode(byte[] input)  
    { 
        // This could be a lot more efficient. 
        BigInteger bi = new BigInteger(1, input); 
        StringBuffer s = new StringBuffer(); 
        while (bi.compareTo(BASE) >= 0)  
        { 
            BigInteger mod = bi.mod(BASE); 
            s.insert(0, ALPHABET.charAt(mod.intValue())); 
            bi = bi.subtract(mod).divide(BASE); 
        } 
        s.insert(0, ALPHABET.charAt(bi.intValue())); 
        // Convert leading zeros too. 
        for (byte anInput : input)  
        { 
            if (anInput == 0) 
                s.insert(0, ALPHABET.charAt(0)); 
            else 
                break; 
        } 
        return s.toString(); 
    } 
}
