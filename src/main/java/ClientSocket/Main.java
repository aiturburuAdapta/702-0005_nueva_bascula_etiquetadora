/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSocket;

import java.io.*;
import java.net.*;

/**
 *
 * @author Pamonte
 */
public class Main {

    private static final char STX = '\u0002';
    private static final char ETX = '\u0003';
        
    public static void main(String[] args) throws InterruptedException {
        // Variables
        int vPuerto;
        String vDirIP;
        // Variables del socket
        Socket socks;
            // Lectura / Escritura
        DataInputStream dis;
        DataOutputStream dos;
        String vCadenaEnviar;
        String vCadenaRecibir;
        // Inicializamos los datos de la conexión
        vDirIP = "172.22.100.88";
        vDirIP = "127.0.0.1";
        vPuerto = 8102;
        System.out.println("D: " + vDirIP + " / P: " + vPuerto);
        // Intentamos abrir la conexión
        try {
            System.out.println("1. Comienza la ejecución.");
            socks = new Socket(vDirIP,vPuerto);
            
            System.out.println("2. Conexión a " + socks.getInetAddress());
            dos = new DataOutputStream(socks.getOutputStream());
            dis = new DataInputStream(socks.getInputStream());
                    
            System.out.println("3. Enviar telegrama de confirmación de conexión");
            vCadenaEnviar = "701[0]1|0\\";
            dos.write(StringToByteArrayUnicode(vCadenaEnviar));
            dos.flush(); 
            System.out.println("3. Información enviada.");

            System.out.println("4. Esperando respuesta...");
            vCadenaRecibir = RecibirRespuestaSocket(dis);
            System.out.println("4. Respuesta del servidor: " + vCadenaRecibir);
            
            System.out.println("5. Enviar telegrama de borrado de la tabla de artículos");
            vCadenaEnviar = "800[10]1|";
                vCadenaEnviar += "DELETE * from SD_Aufrufdaten";
                vCadenaEnviar += " where AR_AufrufNr=1 and AR_kundenNr=0";
            vCadenaEnviar += " \\800[0]0|\\";
            dos.write(StringToByteArrayUnicode(vCadenaEnviar));
            dos.flush();
            System.out.println("5. Información enviada.");
            
            System.out.println("6. Esperando respuesta...");
            vCadenaRecibir = RecibirRespuestaSocket(dis);
            System.out.println("6. Respuesta del servidor: " + vCadenaRecibir);
            
            System.out.println("7. Enviar telegrama de inserción en la tabla de artículos");
            vCadenaEnviar = "800[10]1|";
                vCadenaEnviar += "INSERT INTO SD_Aufrufdaten";
                vCadenaEnviar += " (AR_AufrufNr, AR_KundenNr, AR_EtikettenformatNr, AR_Artikeltext1Zeile, AR_LandesCode, AR_BarcodeArtikelnummer)";
                vCadenaEnviar += " Values(1,0,1,'TextoPrueba', 16, 'C1104')";
            vCadenaEnviar += "\\800[0]0|\\";
            dos.write(StringToByteArrayUnicode(vCadenaEnviar));
            dos.flush();
            System.out.println("7. Información enviada.");
            
            System.out.println("8. Esperando respuesta...");
            vCadenaRecibir = RecibirRespuestaSocket(dis);
            System.out.println("8. Respuesta del servidor: " + vCadenaRecibir);
            
            System.out.println("9. Enviar telegrama de comienzo de PID");
            vCadenaEnviar = "824[0]1|\\1[1]0|1\\1[1]1|0\\824[0]0|\\";
            dos.write(StringToByteArrayUnicode(vCadenaEnviar));
            dos.flush();
            System.out.println("9. Información enviada.");
            
            System.out.println("10. Esperando respuesta...");
            for(int i=0;i<75;i++){
                vCadenaRecibir = RecibirRespuestaSocket(dis);
                System.out.println("10. Respuesta del servidor: " + vCadenaRecibir);
            }

            dis.close();
            dos.close();
            socks.close();
        } catch (IOException ex) {
            System.out.println("Error inesperado durante la ejecución: " + ex.getMessage());
        }
        
        System.out.println("99. Final de la ejecución (Timeout 5 segundos)");
        Thread.sleep(5000);
    }
    
    private static byte [] StringToByteArrayUnicode(String pCadena)
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
    
    private static String RecibirRespuestaSocket(DataInputStream pDIS)
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
   

