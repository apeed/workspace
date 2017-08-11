package com.rcb.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	public static String md5(String src){
		try {
			//鑾峰彇MD5瀵硅薄
			MessageDigest md= MessageDigest.getInstance("MD5");
			//鍔犲瘑澶勭悊
			byte[] output
				=md.digest(src.getBytes());
			//return new String(output);
			//鍒╃敤Base64杞崲鎴愬瓧绗︿覆缁撴灉
			String ret
				=Base64.encodeBase64String(output);
			return ret;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}
	//鍒╃敤UUID鐢熸垚涓婚敭锟�?
	public static String createId(){
		String id=UUID.randomUUID().toString();
		return id;	
	}
	public static void main(String[] args){
		System.out.println(createId());
	}
}







