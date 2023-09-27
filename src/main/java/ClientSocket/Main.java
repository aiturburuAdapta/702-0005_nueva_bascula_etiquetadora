/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientSocket;

import Objetos.TmpPesadaDAO;
import Objetos.TmpPesadaDTO;
import Utilidades.ControladorTelegrama;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 *
 * @author PedroAlonsoMontejo
 */
public class Main {
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
        // Utilidades
        ControladorTelegrama TelCon = new ControladorTelegrama();
        TmpPesadaDTO tmpPesDTO = new TmpPesadaDTO();
        TmpPesadaDAO tmpPesDAO = new TmpPesadaDAO();
        // Inicializamos los datos de la conexión
        vDirIP = "192.168.0.19";
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
            dos.write(TelCon.StringToByteArrayUnicode(vCadenaEnviar));
            dos.flush(); 
            System.out.println("3. Información enviada.");

            System.out.println("4. Esperando respuesta...");
            vCadenaRecibir = TelCon.RecibirRespuestaSocket(dis);
            System.out.println("4. Respuesta del servidor: " + vCadenaRecibir);
            
            System.out.println("5. Enviar telegrama de borrado de la tabla de artículos");
            vCadenaEnviar = "800[10]1|";
                vCadenaEnviar += "DELETE * from SD_Aufrufdaten";
                vCadenaEnviar += " where AR_AufrufNr=1 and AR_kundenNr=0";
            vCadenaEnviar += " \\800[0]0|\\";
            dos.write(TelCon.StringToByteArrayUnicode(vCadenaEnviar));
            dos.flush();
            System.out.println("5. Información enviada.");
            
            System.out.println("6. Esperando respuesta...");
            vCadenaRecibir = TelCon.RecibirRespuestaSocket(dis);
            System.out.println("6. Respuesta del servidor: " + vCadenaRecibir);
            
            System.out.println("7. Enviar telegrama de inserción en la tabla de artículos");
            vCadenaEnviar = "800[10]1|";
                vCadenaEnviar += "INSERT INTO SD_Aufrufdaten";
                vCadenaEnviar += " (AR_AufrufNr, AR_KundenNr, AR_EtikettenformatNr, AR_Artikeltext1Zeile, AR_LandesCode, AR_BarcodeArtikelnummer)";
                vCadenaEnviar += " Values(1,0,1,'TextoPrueba', 16, 'C1104')";
            vCadenaEnviar += "\\800[0]0|\\";
            dos.write(TelCon.StringToByteArrayUnicode(vCadenaEnviar));
            dos.flush();
            System.out.println("7. Información enviada.");
            
            System.out.println("8. Esperando respuesta...");
            vCadenaRecibir = TelCon.RecibirRespuestaSocket(dis);
            System.out.println("8. Respuesta del servidor: " + vCadenaRecibir);
            
            System.out.println("9. Enviar telegrama de comienzo de PID");
            vCadenaEnviar = "824[0]1|\\1[1]0|1\\1[1]1|0\\824[0]0|\\";
            dos.write(TelCon.StringToByteArrayUnicode(vCadenaEnviar));
            dos.flush();
            System.out.println("9. Información enviada.");
            
            System.out.println("10. Esperando respuesta...");
            for(int i=0;i<75;i++){
                vCadenaRecibir = TelCon.RecibirRespuestaSocket(dis);
                System.out.println("10. Respuesta del servidor: " + vCadenaRecibir);
                
                tmpPesDTO = tmpPesDAO.ConvertirRespuestaSocket(vCadenaRecibir);
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
}
