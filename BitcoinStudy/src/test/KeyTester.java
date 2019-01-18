package test;

import java.io.ObjectInputStream.GetField;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.List;

import crypto.KeyGenerator;
import wallet.Wallet;

public class KeyTester {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchProviderException {
		// TODO Auto-generated method stub
		List<String> privateKeyList = new ArrayList<String>();
		List<String> publicKeyList = new ArrayList<String>();
		
		for(int i=0;i<100;i++)
		{
			privateKeyList.add(KeyGenerator.getPrivateKey());
			publicKeyList.add(KeyGenerator.getPublicKey());
		}
		
		Wallet wallet = new Wallet(privateKeyList);
		
		wallet.Create("test");
		
		Wallet loadedwallet = new Wallet();
		
		loadedwallet.Load("test");
		
		System.out.print("PrivateKeyList: ");
		System.out.println(loadedwallet.getPrivateKeyList());
		
		for(int i=0;i<publicKeyList.size();i++) {
			System.out.print("PublicKey: " + publicKeyList.get(i));
			String address = KeyGenerator.getAddress(publicKeyList.get(i));
			System.out.println(", Address: " + address);
		}
	}

}
