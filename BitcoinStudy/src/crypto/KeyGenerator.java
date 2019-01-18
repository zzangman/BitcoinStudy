package crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.List;

public class KeyGenerator {
	
	static KeyPair priv;

	public static String getPrivateKey() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		priv = null;
		
		
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
		ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
		keyGen.initialize(ecSpec);
		
		priv = keyGen.generateKeyPair();
		
		PrivateKey pvt = priv.getPrivate();
		
		ECPrivateKey epvt = (ECPrivateKey)pvt;
		String privateKey = adjustTo64(epvt.getS().toString(16)).toUpperCase();
		
		return privateKey;
	}
	
	public static String getPublicKey() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		//타원곡선함수 클래스 호출해서 공개키 만들어줌
		
		PublicKey pub = priv.getPublic();
		
		ECPublicKey epub = (ECPublicKey)pub;
		ECPoint pt = epub.getW();
		String sx = adjustTo64(pt.getAffineX().toString(16)).toUpperCase();
		String sy = adjustTo64(pt.getAffineY().toString(16)).toUpperCase();
		
		String publicKey = "04" + sx + sy;
		
		return publicKey;
	}
	public static String getAddress(String publickey) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchProviderException {
		
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		byte[] s1 = sha.digest(publickey.getBytes("UTF-8"));
		
		MessageDigest rmd = MessageDigest.getInstance("RipeMD160","BC");
		byte[] r1 = rmd.digest(s1);
		
		//앞에 접두부(0)붙혀줌
		byte[] r2 = new byte[r1.length + 1];
		r2[0] = 0;
		for (int i = 0 ; i < r1.length ; i++) r2[i+1] = r1[i];
		
		//접두부 붙히고 SHA256 2번 돌려줌
		byte[] s2 = sha.digest(r2);
		byte[] s3 = sha.digest(s2);
		
		byte[] a1 = new byte[25];
		for (int i = 0 ; i < r2.length ; i++) a1[i] = r2[i];
		for (int i = 0 ; i < 5 ; i++) a1[20 + i] = s3[i];
		
		String address = Base58.encode(a1);
		
		return address;
	}
	static private String adjustTo64(String s) {
        switch(s.length()) {
        case 62: return "00" + s;
        case 63: return "0" + s;
        case 64: return s;
        default:
            throw new IllegalArgumentException("not a valid key: " + s);
        }
    }
	
	
}
