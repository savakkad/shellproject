package com.shell.markethub.base.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

/**
 * @author Reejh.Ghosh@shell.com
 */
public class EncryptionUtils {
    public static final String DEFAULT_KEY = "W0r1dP67$s&d2BuA";

    /**
     * Encrypt without padding
     *
     * @param data       string data to be encrypted
     * @param CIPHER_KEY encryption key
     * @return base64 encoded encrypted string
     */
    public static String encryptAES(String data, String CIPHER_KEY) {
        try {
            Key aesKey = new SecretKeySpec(CIPHER_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Decrypt strings encrypted without padding
     *
     * @param encrypted  encrypted base64 encoded string to be decrypted
     * @param CIPHER_KEY encryption key
     * @return decrypted string data
     */
    public static String decryptAES(String encrypted, String CIPHER_KEY) {
        try {
            Key aesKey = new SecretKeySpec(CIPHER_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] data_buffer = Base64.getDecoder().decode(encrypted);
            byte[] decrypted = cipher.doFinal(data_buffer);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Encrypt string data with default encryption key
     * Encrypt using Cipher Block Chaining and PKCS5 padding
     *
     * @param data string data to encrypted
     * @return base64 encoded encrypted string
     */
    public static String encryptAESPKCS5(final String data) {
        String strData = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(DEFAULT_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[16]));
            byte[] encrypted = cipher.doFinal(data.getBytes());
            strData = org.apache.commons.codec.binary.Base64.encodeBase64String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strData;
    }

    /**
     * Decrypt string data with default encryption key
     *
     * @param encrypted base64 encoded encrypted string
     * @return decrypted string data
     */
    public static String decryptAESPKCS5(final String encrypted) {
        String strData = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(DEFAULT_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[16]));
            byte[] decrypted = cipher.doFinal((org.apache.commons.codec.binary.Base64.decodeBase64(encrypted)));
            strData = new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strData;
    }

    /**
     * Encrypt string data with provided encryption key
     * Encrypt using Cipher Block Chaining and PKCS5 padding
     *
     * @param data string data to encrypted
     * @return base64 encoded encrypted string
     */
    public static String encryptAESPKCS5(String data, String cipherKey) {
        String strData = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(cipherKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[16]));
            byte[] encrypted = cipher.doFinal(data.getBytes());
            strData = org.apache.commons.codec.binary.Base64.encodeBase64String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strData;
    }

    /**
     * Decrypt string data with default encryption key
     *
     * @param encrypted base64 encoded encrypted string
     * @return decrypted string data
     */
    public static String decryptAESPKCS5(String encrypted, String cipherKey) {
        String strData = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(DEFAULT_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[16]));
            byte[] decrypted = cipher.doFinal((org.apache.commons.codec.binary.Base64.decodeBase64(encrypted)));
            strData = new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strData;
    }

    /**
     * Encrypt string data with default encryption key
     * Encrypt using Cipher Block Chaining and PKCS5 padding
     *
     * @param data string data to encrypted
     * @return base64 encoded encrypted string
     */
    public String encryptAESPKCS5NonStatic(final String data) {
        String strData = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(DEFAULT_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[16]));
            byte[] encrypted = cipher.doFinal(data.getBytes());
            strData = org.apache.commons.codec.binary.Base64.encodeBase64String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strData;
    }

    /**
     * Decrypt string data with default encryption key
     *
     * @param encrypted base64 encoded encrypted string
     * @return decrypted string data
     */
    public static String decryptAESPKCS5NonStatic(final String encrypted, final String cipherKey) {
        String strData = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(DEFAULT_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[16]));
            byte[] decrypted = cipher.doFinal((org.apache.commons.codec.binary.Base64.decodeBase64(encrypted)));
            strData = new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strData;
    }
}
