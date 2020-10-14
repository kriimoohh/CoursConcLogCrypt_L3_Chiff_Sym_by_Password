/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptosymetrique;

import interfaces.ICryptoConfig;
import static interfaces.ICryptoConfig.kdf;
import interfaces.IKeyGeneration;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author kriimoohh
 */
public class KeyGeneration implements IKeyGeneration {

    @Override
    public SecretKey genkey(char[] Password) {
        SecretKey clepbe=null;
        //on appelle Transforme le mot de passe en tableau de Char
        PBEKeySpec pbe = new PBEKeySpec(Password, ICryptoConfig.salt, ICryptoConfig.ieration, ICryptoConfig.keysize);
        //on vide le tableau de char password
	for (int j = 0; j < Password.length; j++) {
		Password[j] = 0;
	}
	try {  
         //on appelle le KDF: PBEKeySpec pour construire une clé
          SecretKeyFactory kdfFactory = SecretKeyFactory.getInstance(kdf);
          SecretKey keyPBE = kdfFactory.generateSecret(pbe);
          clepbe=new SecretKeySpec(keyPBE.getEncoded(), ICryptoConfig.algo);
			
       } catch (Exception e) {
	     // TODO Auto-generated catch block
	      e.printStackTrace();
       }
                
       return clepbe;
    }
}

