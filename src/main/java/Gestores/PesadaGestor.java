/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Datos.Incidencia;
import Datos.Pesada;
import ConexionBD.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Esta clase lleva la lógica de los métodos que gestionan los objetos Pesada.
 *
 * @author PedroAlonsoMontejo, Ander Goirigolzarri Iturburu
 */
public class PesadaGestor {

    private final String tramaAlive = "820[1]1|";
    // Ejemplo : 99[8]0|0\1[1]0|0\1[1]4|0\1[4]99|1-2023-SerieOf-999\1[5]0|0,850\1[6]0|1,00\99[0]0|\
    // Ejemplo con idProceso : 99[8]0|0\1[1]0|0\1[1]4|0\1[4]99|1-2023-SerieOf999\1[5]0|0,850\1[6]0|1,00\1[0]8|0\99[0]0|\
    private final String PID = "1[1]0|";
    private final String MainPID = "1[1]4|";
    private final String OrdenFabricacion = "1[4]99|";
    private final String Peso = "1[5]0";
    private final String Cantidad = "1[6]0";
    private final String idProceso = "1[0]8";
    private final String esArticulo = "99[8]0|0";
    private final String esCaja = "99[8]0|1";
    private final String Final = "99[0]0|";

    private String vTipoIncidencia;
    private String vDescripcionIncidencia;

    /**
     * Método para generar un objeto Pesada a partir de un telegrama que recibe.
     *
     * @param pTelegrama
     * @return Pesada
     * @throws Exception
     */
    public Pesada TelegramaToPesada(String pTelegrama) throws Exception {
        Pesada vPesada = new Pesada();

        //1.0 Separar trama por IDs
        String[] vPartes = pTelegrama.split("\\\\"); //Usar el método split para separar el String recibido en vCadenaRecibir

        //1.1 Ignorar telegrama ALIVE
        if (!vPartes[0].equalsIgnoreCase(tramaAlive)) {
            boolean esIncidencia = false;
            vPesada.setTelegrama(pTelegrama);
            for (String vParte : vPartes) {
                if (vParte.contains(PID) || vParte.contains(MainPID) || vParte.contains(OrdenFabricacion) || vParte.contains(Peso) || vParte.contains(Cantidad) || vParte.contains(idProceso) || vParte.contains(esArticulo) || vParte.contains(esCaja) || vParte.contains(Final)) {
                    //Esta serie de if-else comprueba que información contiene la parte y la añade a la propiedad correspondiente del objeto vPesada
                    if (vParte.contains(PID)) {
                        int pipeIndex = vParte.indexOf("|");
                        vPesada.setPID(vParte.substring(pipeIndex + 1));
                        System.out.println("PID: " + vParte.substring(pipeIndex + 1));
                    } else if (vParte.contains(MainPID)) {
                        int pipeIndex = vParte.indexOf("|");
                        vPesada.setMainPID(vParte.substring(pipeIndex + 1));
                        System.out.println("MainPID: " + vParte.substring(pipeIndex + 1));
                    } else if (vParte.contains(OrdenFabricacion)) {
                        int pipeIndex = vParte.indexOf("|");
                        String auxOrdenFab = vParte.substring(pipeIndex + 1);
                        vPesada.setOrdenFabricacion(auxOrdenFab);
                        String[] vPartes2 = auxOrdenFab.split("-");
                        vPesada.setCodigoEmpresa(vPartes2[0]);
                        System.out.println("OrdenFabricacion: " + vParte.substring(pipeIndex + 1));
                    } else if (vParte.contains(Peso)) { // Es necesario parsear esta vParte a double
                        int pipeIndex = vParte.indexOf("|");
                        String doublePart = vParte.substring(pipeIndex + 1);
                        doublePart = doublePart.replace(",", "."); // Java necesita un punto para reconocer un double
                        vPesada.setPeso(Double.parseDouble(doublePart));
                        System.out.println("Peso: " + doublePart);
                    } else if (vParte.contains(Cantidad)) { // Es necesario parsear esta vParte a double
                        int pipeIndex = vParte.indexOf("|");
                        String doublePart = vParte.substring(pipeIndex + 1);
                        doublePart = doublePart.replace(",", ".");
                        vPesada.setCantidad(Double.parseDouble(doublePart));
                        System.out.println("Cantidad: " + doublePart);
                    } else if (vParte.contains(esArticulo)) {
                        int pipeIndex = vParte.indexOf("|");
                        vPesada.setTipo(vParte.substring(pipeIndex + 1));
                    } else if (vParte.contains(esCaja)) {
                        int pipeIndex = vParte.indexOf("|");
                        vPesada.setTipo(vParte.substring(pipeIndex + 1));
                    } else if (vParte.contains(idProceso)) {
                        int pipeIndex = vParte.indexOf("|");
                        vPesada.setIdProceso(vParte.substring(pipeIndex + 1));
                        System.out.println("ID Proceso: " + vParte.substring(pipeIndex + 1));
                    } else if (vParte.contains(Final)) {
                        break;
                    } else {
                        vTipoIncidencia = "Trama incorrecta";
                        vDescripcionIncidencia = pTelegrama;
                        esIncidencia = true;
                    }
                } else {
                    vTipoIncidencia = "Trama incorrecta";
                    vDescripcionIncidencia = pTelegrama;
                    esIncidencia = true;
                }
            }
            if (esIncidencia) {
                Incidencia incidencia = new Incidencia();
                incidencia.setpFechaRegistro(LocalDate.now());
                LocalDateTime pAhora = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                String pHoraSinParsear = pAhora.format(formatter);
                int hora = Integer.parseInt(pHoraSinParsear.split(":")[0]);
                int min = Integer.parseInt(pHoraSinParsear.split(":")[1]);
                double sumMin = (hora * 60) + min;
                double pHora = sumMin / 1440;
                incidencia.setpHora(pHora);
                incidencia.setpCodigoEmpresa(0);
                incidencia.setpAd_TipoIncidencia(vTipoIncidencia);
                incidencia.setpAd_DescripcionIncidencia(vDescripcionIncidencia);
                incidencia.setpTipoDocumento("");
                incidencia.setpEjercicioDocumento(0);
                incidencia.setpSerieDocumento("");
                incidencia.setpNumeroDocumento(0);
                incidencia.setpAd_IDProceso("3A6BC8F2-4FDC-4379-AC11-6B888B2E84A5");
                incidencia.setpMovOrigen("E8E4D3A1-9B57-492A-BEC9-14687FC98204");
                // rellenar
                new IncidenciaGestor().AltaIncidenciaBD(incidencia);
                throw new Exception("Se ha producido una incidencia en el proceso.");
            }
        }
        return vPesada;
    }

    public void PesadaToBD(Pesada vPesada) throws Exception {
        System.out.println("He recibido el objeto Pesada");
        try{
            DataSource ds = new DataSource();
            
            String sql = "INSERT INTO ad_BasculaEtiqueta_Pesajes(\n"
                    + "FechaRegistro, \n"
                    + "CodigoEmpresa, \n"
                    + "ad_Telegrama, \n"
                    + "ad_PID, \n"
                    + "ad_MainPID, \n"
                    + "ad_IdOrdenFabricacion, \n"
                    + "PesoBruto_, \n"
                    + "Unidades, \n"
                    + "ad_PackageID, \n"
                    + "ad_TipoPesada \n"
                    + ") VALUES (?,?,?,?,?,?,?,?,?,?);";
            
            PreparedStatement smnt = ds.getPreparedStatement(sql);
            
            smnt.setDate(1,Date.valueOf(LocalDate.now()));
            smnt.setString(2,vPesada.getCodigoEmpresa()); // Esta informacion se saca de la parte de la trama con la Orden de Fabricacion
            smnt.setString(3,vPesada.getTelegrama()); 
            smnt.setString(4,vPesada.getPID()); 
            smnt.setString(5,vPesada.getMainPID()); 
            smnt.setString(6,vPesada.getOrdenFabricacion()); 
            smnt.setDouble(7,vPesada.getPeso()); 
            smnt.setDouble(8,vPesada.getCantidad()); 
            smnt.setString(9,vPesada.getIdProceso()); 
            smnt.setString(10,vPesada.getTipo()); 
            
            ds.ejecutarInsert(smnt);
            ds.cerrarConexion();
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
