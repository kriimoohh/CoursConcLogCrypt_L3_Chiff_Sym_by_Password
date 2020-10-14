/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author kriimoohh
 */
public interface ICryptoConfig {
    public static String algo="AES";
    public static int keysize = 128;
    public static String trans = "AES/CBC/PKCS5Padding";
    public static String iv = "bunftredfnjiklom";
    public final String skftransform="PBEWithHmacSHA256AndAES_128";
    public final String kdf="PBKDF2WithHmacSHA1";
    public final int ieration=1000;
    public final byte [] salt="MO5-°HG3YEH255367gdsjhgd".getBytes();
}
