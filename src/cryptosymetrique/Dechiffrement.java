/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptosymetrique;

import interfaces.ICryptoConfig;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author kriimoohh
 */
public class Dechiffrement extends Chiffrement{

    @Override
    public Cipher getCipher(char[] Password) {
        
        KeyGeneration gen = new KeyGeneration();
        SecretKey cle = gen.genkey(Password);
        try {
            Cipher c = Cipher.getInstance(ICryptoConfig.trans);
            c.init(Cipher.DECRYPT_MODE,cle, new IvParameterSpec(ICryptoConfig.iv.getBytes()));
            return c;
                    
        } catch (Exception ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
