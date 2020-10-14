/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.crypto.SecretKey;

/**
 *
 * @author kriimoohh
 */
public interface IKeyGeneration {
    public SecretKey genkey(char[] Password);
    
}
