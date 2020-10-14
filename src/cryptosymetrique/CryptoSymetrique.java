/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptosymetrique;


/**
 *
 * @author kriimoohh
 */
public class CryptoSymetrique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

        
        //Chiffrement chiffrement = new Chiffrement();
        //chiffrement.runCipher("Mot de passe".toCharArray(),"./test.txt","./chiffre.txt");
        
        Dechiffrement dechiffrement = new  Dechiffrement();
        dechiffrement.runCipher("Mot de passe".toCharArray(),"./chiffre.txt","./dechiffre.txt");
        
        //new Menu().setVisible(true);
                
    }
    
}
