/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Datos.Incidencia;
import Datos.Pesada;

/**
 *
 * @author PedroAlonsoMontejo
 */
public class PesadaGestor {

    private final String tramaAlive = "820[1]1|";
    // Ejemplo : 99[8]0|0\1[1]0|0\1[1]4|0\1[4]99|2023-SerieOf999\1[5]0|0,850\1[6]0|1,00\99[0]0|\
    private final String PID = "1[1]0|";
    private final String MainPID = "1[4]0|"; 
        //AGI: este es el indicador de MainPID?
    private final String OrdenFabricacion = "1[4]99|";
    private final String Peso = "1[5]0";
    private final String Cantidad = "1[6]0";

    public Pesada TelegramaToPesada(String pTelegrama) throws Exception {
        Pesada vPesada = new Pesada();
        //1.0 Separar trama por IDs
        String[] vPartes = pTelegrama.split("\\\\"); //Usar el m�todo split para separar el String recibido en vCadenaRecibir

        //1.1 Ignorar telegrama ALIVE
        if (!vPartes[0].equalsIgnoreCase(tramaAlive)) {
            for (String vParte : vPartes) {
                //2.0 Imprimir por consola la info de cada ID
                System.out.println("Split part: " + vParte);
            }
            //3.0 Comprobar todos los IDS han tenido info (throws exception)
            // AGI: Tanto para el PID como para el MainPID, su parte tiene que ser exacta, pero el resto de la trama aparte de los identidficadores viene con informaci�n adicional. �Ser�a correcto por lo tanto usar contains en vez de equalsIgnoreCase?
            boolean esIncidencia = false;

            if (!vPartes[1].contains(PID)) {
                esIncidencia = true;
            }

            if (!vPartes[2].contains(MainPID)) {
                esIncidencia = true;
            }

            if (!vPartes[3].contains(OrdenFabricacion)) {
                esIncidencia = true;
            }

            if (!vPartes[4].contains(Peso)) {
                esIncidencia = true;
            }

            if (!vPartes[5].contains(Cantidad)) {
                esIncidencia = true;
            }

            //3.0 Comprobar todos los IDS han tenido info (throws exception)
            if (esIncidencia) {
                Incidencia incidencia = new Incidencia();
                new IncidenciaGestor().AltaIncidenciaBD(incidencia);
                throw new Exception("Se ha producido una incidencia en el proceso.");
            }
        }
        return vPesada;
    }
}
