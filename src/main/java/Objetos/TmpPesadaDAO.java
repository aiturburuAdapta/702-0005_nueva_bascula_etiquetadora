/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;


/**
 *
 * @author PedroAlonsoMontejo
 */
public class TmpPesadaDAO {

    private final static String tramaAlive = "820[1]1|\\\\";

    //2.0 Imprimir por consola la info de cada ID
    //3.0 Comprobar todos los IDS han tenido info
    public TmpPesadaDTO ConvertirRespuestaSocket(String vCadenaRecibir) {
        TmpPesadaDTO vRespuestaDTO = new TmpPesadaDTO();
        //1.0 Separar trama por IDs
        String[] parts = vCadenaRecibir.split("\\\\"); //Usar el método split para separar el String recibido en vCadenaRecibir

        //1.1 Ignorar telegrama ALIVE
        if (!vCadenaRecibir.equalsIgnoreCase(tramaAlive)) {

            // Access the split parts from the list   
            for (String part : parts) {
                // Process each part as needed
                System.out.println("Split part: " + part);
            }
        }
        return vRespuestaDTO;
    }
}
