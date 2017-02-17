package org.tarena.cloudnote.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	/**
	 * 生成MD5加密码
	 * @param str
	 * @return
	 */
	public static String md5(String str){
		//将str利用MD5处理
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			//处理结果是byte[]数组，学将byte[]处理成字符串返回
			byte[] output = md.digest(str.getBytes());
//			System.out.println(output.length);
			//利用base64算法，将byte[]处理成字符串返回
			return Base64.encodeBase64String(output);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	 * 生成ID为UUID号
	 * @return
	 */
	public static String createId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
