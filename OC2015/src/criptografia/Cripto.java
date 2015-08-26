package criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cripto {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String s1 = "123";
        //String s1 = "1234";
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(s1.getBytes()));
        String s2 = hash.toString(16);
        System.out.println(s2);
        
        // 202cb962ac59075b964b07152d234b70
        // 81dc9bdb52d04dc20036dbd8313ed055
        // 202cb962ac59075b964b07152d234b70

    }
}
