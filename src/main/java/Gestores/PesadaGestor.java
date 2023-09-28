/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Datos.Pesada;


/**
 *
 * @author PedroAlonsoMontejo
 */
public class PesadaGestor {
    private final String tramaAlive = "820[1]1|\\\\";
    // Ejemplo : 99[8]0|0\1[1]0|0\1[1]4|0\1[4]99|2023-SerieOf999\1[5]0|0,850\1[6]0|1,00\99[0]0|\
    private final String ID ="1[1]0|";
        
    //2.0 Imprimir por consola la info de cada ID
    //3.0 Comprobar todos los IDS han tenido info (throws exception)
    public Pesada TelegramaToPesada(String pTelegrama) {
        Pesada vPesada = new Pesada();
        //1.0 Separar trama por IDs
        String[] parts = pTelegrama.split("\\\\"); //Usar el método split para separar el String recibido en vCadenaRecibir

        //1.1 Ignorar telegrama ALIVE
        if (!pTelegrama.equalsIgnoreCase(tramaAlive)) {

            // Access the split parts from the list   
            for (String part : parts) {
                // Process each part as needed
                System.out.println("Split part: " + part);
            }
        }
        return vPesada;
    }
}
