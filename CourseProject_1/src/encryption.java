import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;


public class encryption {
	public static final String FILE_EXTENSION = ".DES"; 

	public static byte[] Str2SHA256(String inputString){
		byte[] data;
		byte[] digest = new byte [256];
		data = inputString.getBytes();
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			sha256.update(data);
			digest = sha256.digest();
			return digest;
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}
	public static byte[] byte2MD5(byte[] data){
		byte[] digest = new byte [256];
		try {
			MessageDigest sha256 = MessageDigest.getInstance("MD5");
			sha256.update(data);
			digest = sha256.digest();
			return digest;
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}
	public static byte[] SHA2562MD5(byte[] data){
		byte digest[];
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			sha256.update(data);
			digest = sha256.digest();
			return digest;
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return null;
	}
	public static String fromByte2Str( byte[] data){
		return (new String(data));
	}
	public static void DecryptFile(String infile, String outfile, String password) 
	throws GeneralSecurityException
	{
		try {
			FileInputStream fin = new FileInputStream(infile);
			FileOutputStream fout = new FileOutputStream(outfile);

			// Create a key.
			byte[] desKeyData = password.getBytes();
			DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey desKey = keyFactory.generateSecret(desKeySpec);

			// Read the initialization vector.
			DataInputStream din = new DataInputStream(fin);
			int ivSize = din.readInt();
			byte[] iv = new byte[ivSize];
			din.readFully(iv);
			IvParameterSpec ivps = new IvParameterSpec(iv);

			// Use Data Encryption Standard.
			Cipher des = Cipher.getInstance("DES/CBC/PKCS5Padding");
			des.init(Cipher.DECRYPT_MODE, desKey, ivps);

			byte[] input = new byte[64];
			while (true) {
				int bytesRead = fin.read(input);
				if (bytesRead == -1)
					break;
				byte[] output = des.update(input, 0, bytesRead);
				if (output != null)
					fout.write(output);
			}

			byte[] output = des.doFinal();
			if (output != null)
				fout.write(output);
			fin.close();
			fout.flush();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void encryptFile(String filename, String password) {
		try {
			FileInputStream fin = new FileInputStream(filename);
			FileOutputStream fout = new FileOutputStream(filename+FILE_EXTENSION);

			// Create a key.
			byte[] desKeyData = password.getBytes();
			DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey desKey = keyFactory.generateSecret(desKeySpec);

			// Use Data Encryption Standard.
			Cipher des = Cipher.getInstance("DES/CBC/PKCS5Padding");
			des.init(Cipher.ENCRYPT_MODE, desKey);

			// Write the initialization vector onto the output.
			byte[] iv = des.getIV();
			DataOutputStream dout = new DataOutputStream(fout);
			dout.writeInt(iv.length);
			dout.write(iv);

			byte[] input = new byte[64];
			while (true) {
				int bytesRead = fin.read(input);
				if (bytesRead == -1)
					break;
				byte[] output = des.update(input, 0, bytesRead);
				if (output != null)
					dout.write(output);
			}

			byte[] output = des.doFinal();
			if (output != null)
				dout.write(output);
			fin.close();
			dout.flush();
			dout.close();

		} catch (InvalidKeySpecException e) {
			System.err.println(e);
		} catch (InvalidKeyException e) {
			System.err.println(e);
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		} catch (NoSuchPaddingException e) {
			System.err.println(e);
		} catch (BadPaddingException e) {
			System.err.println(e);
		} catch (IllegalBlockSizeException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
