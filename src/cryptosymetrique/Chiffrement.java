/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptosymetrique;

import interfaces.IChiffrement;
import interfaces.ICryptoConfig;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author kriimoohh
 */
public class Chiffrement implements IChiffrement {

    @Override
    public Cipher getCipher(char[] Password) {
        
        KeyGeneration gen = new KeyGeneration();
        SecretKey cle = gen.genkey(Password);
        try {
            Cipher c = Cipher.getInstance(ICryptoConfig.trans);
            c.init(Cipher.ENCRYPT_MODE,cle, new IvParameterSpec(ICryptoConfig.iv.getBytes()));
            return c;
                    
        } catch (Exception ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public boolean Process(String fileToEncrypt, String fileDest, Cipher cipher) {
        try {
            FileInputStream fis = new FileInputStream(fileToEncrypt);
            byte[] tampon = new byte[1024];
            FileOutputStream fos = new FileOutputStream(fileDest);
            CipherOutputStream cos= new CipherOutputStream(fos, cipher);
            int tailleLue=0;
            tailleLue=fis.read(tampon);
            
            while(tailleLue!=-1){
                    
                cos.write(tampon, 0, tailleLue);
             tailleLue=fis.read(tampon);    
            }
            cos.close();
            fis.close();
            fos.close();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }



    @Override
    public boolean runCipher(char[] Password, String fileToEncrypt, String fileDest) {

        Cipher c = getCipher(Password);
        return Process(fileToEncrypt, fileDest, c);
    }
    
}
