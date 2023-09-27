/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author PedroAlonsoMontejo
 */
public class ControladorTelegrama {
    private static final char STX = '\u0002';
    private static final char ETX = '\u0003';
    
    public byte [] StringToByteArrayUnicode(String pCadena)
    {
        byte[] ccebauByteArray;
        
        pCadena = STX + pCadena + ETX;
        System.out.println("Preparando bytes unicode de la cadena: " + pCadena + ".");
        try {
            ccebauByteArray = pCadena.getBytes("UTF-16LE");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error al preparar la cadena: " + ex.getMessage());
            return null;
        }
        
        return ccebauByteArray;
    }
    
    public String RecibirRespuestaSocket(DataInputStream pDIS)
    {
        byte[] rrsReadArray = new byte[10240];
        String rrsCadena;
        
        try {
            pDIS.read(rrsReadArray);
            rrsCadena = new String(rrsReadArray);
        } catch (IOException ex) {
            System.out.println("Error al recoger la respuesta: " + ex.getMessage());
            rrsCadena = "";
        }
        return rrsCadena;
    }
}
