package com.javaapi.test.util.application.rsa;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 支持加解密 大字符串
 */
public class RSACryptBigString {
    private static final String CHARSET = "UTF-8";
    private static final String RSA_ALGORITHM = "RSA";
    /**
     * 针对 keysize = 1024 RSA最大加密明文大小 117
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;
    /**
     * 针对 keysize = 1024  RSA最大解密密文大小  128
     */
    private static final int MAX_DECRYPT_BLOCK = 128;


    /**
     * keysize 1024  获得秘钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair createKey() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        return keyPair;
    }

    /**
     * 得到公钥
     *
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public static RSAPublicKey getPublicKey(String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }

    /**
     * 得到私钥
     *
     * @param privateKey 密钥字符串（经过base64编码）
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws Exception
     */
    public static RSAPrivateKey getPrivateKey(String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }

    /**
     * 公钥加密，支持超117字节的进行分块加密
     *
     * @param data      数据
     * @param publicKey base64编码的
     *                  公钥
     * @return
     */
    public static String publicEncrypt(String data, String publicKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidKeySpecException {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        PublicKey pk = getPublicKey(publicKey);
        cipher.init(Cipher.ENCRYPT_MODE, pk);
        byte[] dataByte = data.getBytes(CHARSET), cache;
        int dataLength = dataByte.length, offSet = 0, i = 0;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            // 数据分段加密
            while (dataLength - offSet > 0) {
                if (dataLength - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(dataByte, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(dataByte, offSet, dataLength - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptData = out.toByteArray();
            return Base64.getEncoder().encodeToString(encryptData);
        }
    }

    /**
     * 私钥解密，支持超长的分块解密
     * <p>
     * 解码关键(因为原始数据先geyBytes后再做Base64编码，此处getBytes后再还原回方可解密)
     *
     * @param data       字符串
     * @param privateKey 私钥
     * @return
     */
    public static String privateDecrypt(String data, String privateKey)
            throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, IOException {
        PrivateKey pbk = getPrivateKey(privateKey);
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, pbk);
        //Base64做对称解码(一定要先把数据还原，否则解密失败---因为原始数据先geyBytes后再做Base64编码，此处getBytes后再还原回去)
        byte[] dataByte = Base64.getDecoder().decode(data.getBytes()), cache;
        int dataLength = dataByte.length, offSet = 0, i = 0;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            // 数据分段解密
            while (dataLength - offSet > 0) {
                if (dataLength - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(dataByte, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(dataByte, offSet, dataLength - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            return new String(decryptedData, CHARSET);
        }
    }

}
