/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientSocket;

import Gestores.PesadaGestor;
import Gestores.ProduccionGestor;
import Datos.Pesada;
import Datos.Produccion;
import Utilidades.TelegramaControlador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Pedro Alonso Montejo
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
        String vTelegramaEnvio;
        String vTelegramaRespuesta;
        // Utilidades
        TelegramaControlador TelCon = new TelegramaControlador();
        // Datos
        Pesada tmpPesDTO = new Pesada();
        // Gestores
        PesadaGestor tmpPesDAO = new PesadaGestor();
        // Inicializamos los datos de la conexión
        vDirIP = "192.168.0.19";
        vPuerto = 8102;
        System.out.println("D: " + vDirIP + " / P: " + vPuerto);
        // Intentamos abrir la conexión
        try {
            System.out.println("1. Comienza la ejecución.");
            socks = new Socket(vDirIP, vPuerto); // Declarar el socket

            System.out.println("2. Conexión a " + socks.getInetAddress());
            dos = new DataOutputStream(socks.getOutputStream());
            dis = new DataInputStream(socks.getInputStream());

            System.out.println("3. Enviar telegrama de confirmación de conexión");
            vTelegramaEnvio = "701[0]1|0\\";
            dos.write(TelCon.StringToByteArrayUnicode(vTelegramaEnvio));
            dos.flush();
            System.out.println("3. Información enviada.");

            System.out.println("4. Esperando respuesta...");
            vTelegramaRespuesta = TelCon.RecibirRespuestaSocket(dis);
            System.out.println("4. Respuesta del servidor: " + vTelegramaRespuesta);

            System.out.println("5. Enviar telegrama de borrado de la tabla de artículos"); // Borrar tabla artículos
            vTelegramaEnvio = "800[10]1|";
            vTelegramaEnvio += "DELETE * from SD_Aufrufdaten";
            vTelegramaEnvio += " where AR_AufrufNr=1 and AR_kundenNr=0";
            vTelegramaEnvio += " \\800[0]0|\\";
            dos.write(TelCon.StringToByteArrayUnicode(vTelegramaEnvio));
            dos.flush();
            System.out.println("5. Información enviada.");

            System.out.println("6. Esperando respuesta...");
            vTelegramaRespuesta = TelCon.RecibirRespuestaSocket(dis);
            System.out.println("6. Respuesta del servidor: " + vTelegramaRespuesta);

            System.out.println("7. Enviar telegrama de inserción en la tabla de artículos");
            ProduccionGestor pg = new ProduccionGestor();
            Produccion objProduccion = pg.ProduccionFromBD();
            vTelegramaEnvio = pg.ProduccionToTelegrama(objProduccion);

            dos.write(TelCon.StringToByteArrayUnicode(vTelegramaEnvio)); // Envio trama con los datos de fabricación
            dos.flush();
            System.out.println("7. Información enviada.");

            System.out.println("8. Esperando respuesta...");
            vTelegramaRespuesta = TelCon.RecibirRespuestaSocket(dis);
            System.out.println("8. Respuesta del servidor: " + vTelegramaRespuesta);

            System.out.println("9. Enviar telegrama de comienzo de PID");
            vTelegramaEnvio = "824[0]1|\\1[1]0|1\\1[1]1|0\\824[0]0|\\";
            dos.write(TelCon.StringToByteArrayUnicode(vTelegramaEnvio));
            dos.flush();
            System.out.println("9. Información enviada.");

            System.out.println("10. Esperando respuesta...");
            for (int i = 0; i < 75; i++) {
                vTelegramaRespuesta = TelCon.RecibirRespuestaSocket(dis);
                System.out.println("10. Respuesta del servidor: " + vTelegramaRespuesta);
                try {
                    tmpPesDTO = tmpPesDAO.TelegramaToPesada(vTelegramaRespuesta); // Recoger las tramas que envia la báscula
                    new PesadaGestor().PesadaToBD(tmpPesDTO); // Crear registros en tabla de BD de SAGE
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
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
