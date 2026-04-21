package es.etg.dam.calculadora;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilHash {
   public static String FORMATO_HASH = "SHA-256";

    public static byte[] generarHash(byte[] contenido) throws NoSuchAlgorithmException {
        MessageDigest mg = MessageDigest.getInstance(FORMATO_HASH);
        return mg.digest(contenido);
    }
}