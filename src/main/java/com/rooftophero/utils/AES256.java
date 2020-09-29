package com.rooftophero.utils;

// reference : https://smilek1225.tistory.com/1?category=738376

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES256 {

	// 32bit만 가능 
	//static String encryptKey = "KwwySUYRlz24PssqB6WmsqVzhUiLR68y";
	static String encryptKey = "hiPoQMXqIyQhXCjv9Gx9X1sGGcve4QyP"; 
	
	private static String combineKey(String userKey) {
		
		if (userKey.length()>32) {
			encryptKey = userKey.substring(0, 32);
		} else {
			encryptKey = userKey.concat(encryptKey.substring(userKey.length(), 32));
		}
		return encryptKey;
	}
	
	public static String encrypt(String inputStr, String userKey) {
		
		encryptKey = combineKey(userKey);
		
		String result = null;

		if ((inputStr == null) || (inputStr.length() < 1)) {
			return result;
		}

		SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(), "AES");

		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(1, keySpec);

			byte[] byteValue = cipher.doFinal(inputStr.getBytes("UTF-8"));

			Base64 base64EnDe = new Base64();

			result = base64EnDe.encodeToString(byteValue).replaceAll("\r\n", "");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String decrypt(String encStr, String userKey) {

		encryptKey = combineKey(userKey);

		String result = "";

		if ((encStr == null) || (encStr.length() < 1)) {
			return result;
		}

		SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(), "AES");

		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(2, keySpec);

			Base64 base64EnDe = new Base64();

			byte[] origianl = cipher.doFinal(base64EnDe.decode(encStr));

			result = new String(origianl, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
		//	e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		return result;
	}

	
//	public String encrypt(String inputStr) {
//		
//		System.out.println(userKey.length());
//		System.out.println(encryptKey.length());
//		System.out.println("----------------------");
//		String result = null;
//
//		if ((inputStr == null) || (inputStr.length() < 1)) {
//			return result;
//		}
//
//		SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(), "AES");
//
//		try {
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//			cipher.init(1, keySpec);
//
//			byte[] byteValue = cipher.doFinal(inputStr.getBytes("UTF-8"));
//
//			Base64 base64EnDe = new Base64();
//
//			result = base64EnDe.encodeToString(byteValue).replaceAll("\r\n", "");
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			e.printStackTrace();
//		} catch (InvalidKeyException e) {
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	public String decrypt(String encStr) {
//
//		String result = "";
//
//		if ((encStr == null) || (encStr.length() < 1)) {
//			return result;
//		}
//
//		SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(), "AES");
//
//		try {
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//			cipher.init(2, keySpec);
//
//			Base64 base64EnDe = new Base64();
//
//			byte[] origianl = cipher.doFinal(base64EnDe.decode(encStr));
//
//			result = new String(origianl, "UTF-8");
//
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			e.printStackTrace();
//		} catch (InvalidKeyException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
}
