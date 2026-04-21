package es.etg.dam.calculadora;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class UtilSimetrico {
    private static final String ALGORITMO = "AES";
    // La clave debe tener 16 bytes para AES-128
    private static final String PASS = "1234567890123456"; 

    public static String cifrar(String mensaje) throws Exception {
        Key key = new SecretKeySpec(PASS.getBytes("UTF-8"), 0, 16, ALGORITMO);
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        
        aes.init(Cipher.ENCRYPT_MODE, key);
        byte[] cifrado = aes.doFinal(mensaje.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(cifrado);
    }

    public static String descifrar(String mensajeCifrado) throws Exception {
        Key key = new SecretKeySpec(PASS.getBytes("UTF-8"), 0, 16, ALGORITMO);
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

        aes.init(Cipher.DECRYPT_MODE, key);
        byte[] cifrado = Base64.getDecoder().decode(mensajeCifrado);
        byte[] descifrado = aes.doFinal(cifrado);
        return new String(descifrado, "UTF-8");
    }
}