package com.example.pruebatecnicaandroid.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryptor {
    public static String encrypt(String input) {
        try {
            // Obtener una instancia del algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Calcular el resumen (hash) de la cadena de entrada
            byte[] messageDigest = md.digest(input.getBytes());

            // Convertir el resumen (hash) en una representación hexadecimal
            StringBuilder hashText = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hashText.append('0');
                }
                hashText.append(hex);
            }

            return hashText.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}