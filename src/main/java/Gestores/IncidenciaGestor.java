/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Datos.Incidencia;
import ConexionBD.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroAlonsoMontejo, Ander Goirigolzarri Iturburu
 */
public class IncidenciaGestor {

    // Dar de alta incidencia en base de datos
    public void AltaIncidenciaBD(Incidencia pInc) {

        // Completar la infor de la incidencia
        String pIdContador = "";
        LocalDate pFechaRegistro = LocalDate.MIN;
        LocalDateTime pHora = LocalDateTime.MIN;
        short pCodigoEmpresa = 0;
        String pAd_TipoIncidencia = "";
        String pAd_DescripcionIncidencia = "";
        String pTipoDocumento = "";
        short pEjercicioDocumento = 0;
        String pSerieDocumento = "";
        int pNumeroDocumento = 0;
        String pAd_IDProceso = "";
        String pMovOrigen = "";

        // Darle la info al objeto incidencia
        pInc.setpIdContador(pIdContador);
        pInc.setpFechaRegistro(pFechaRegistro);
        pInc.setpHora(pHora);
        pInc.setpCodigoEmpresa(pCodigoEmpresa);
        pInc.setpAd_TipoIncidencia(pAd_TipoIncidencia);
        pInc.setpAd_DescripcionIncidencia(pAd_DescripcionIncidencia);
        pInc.setpTipoDocumento(pTipoDocumento);
        pInc.setpEjercicioDocumento(pEjercicioDocumento);
        pInc.setpSerieDocumento(pSerieDocumento);
        pInc.setpNumeroDocumento(pNumeroDocumento);
        pInc.setpAd_IDProceso(pAd_IDProceso);
        pInc.setpMovOrigen(pMovOrigen);
        System.out.println(
                "Hola, soy el alta de una incidencia, este mensaje lo lanza el método AltaIncidenciaBD desde IncidenciaGestor");

        try {
            DataSource ds = new DataSource();

            //Generar la cadena para inserrtar la info en la base de datos
            String sql = "INSERT INTO ad_Incidencias (\n"
                    + "    FechaRegistro, \n"
                    + "    Hora, \n"
                    + "    CodigoEmpresa, \n"
                    + "    ad_TipoIncidencia, \n"
                    + "    ad_DescripcionIncidencia, \n"
                    + "    TipoDocumento, \n"
                    + "    EjercicioDocumento, \n"
                    + "    SerieDocumento, \n"
                    + "    NumeroDocumento, \n"
                    + "    ad_idProceso, \n"
                    + "    MovOrigen\n"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement smnt = ds.getPreparedStatement(sql);

            // Establecer los valores de los parámetros
            smnt.setDate(1, Date.valueOf(pInc.getpFechaRegistro())); // Reemplaza con la fecha real
            smnt.setTime(2, Time.valueOf(pInc.getpHora().toLocalTime())); // Reemplaza con la hora real
            smnt.setShort(3, pInc.getpCodigoEmpresa()); // Reemplaza con el código de empresa real
            smnt.setString(4, pInc.getpAd_TipoIncidencia()); // Reemplaza con el tipo de incidencia real
            smnt.setString(5, pInc.getpAd_DescripcionIncidencia()); // Reemplaza con la descripción real
            smnt.setString(6, pInc.getpTipoDocumento()); // Reemplaza con el tipo de documento real
            smnt.setShort(7, pInc.getpEjercicioDocumento()); // Reemplaza con el ejercicio real
            smnt.setString(8, pInc.getpSerieDocumento()); // Reemplaza con la serie de documento real
            smnt.setInt(9, pInc.getpNumeroDocumento()); // Reemplaza con el número de documento real
            smnt.setString(10, pInc.getpAd_IDProceso()); // Reemplaza con el ID de proceso real
            smnt.setString(11, pInc.getpMovOrigen()); // Reemplaza con el movimiento de origen real

            int resultado = ds.ejecutarInsert(smnt);

            //Este bloque de código solo está aqui para el desarrollo, eliminar en la versión final
            if (resultado > 0) {
                System.out.println("Inserción correcta");
            } else {
                System.out.println("Inserción fallida");
            }

            ds.cerrarConexion();

        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(IncidenciaGestor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }
}
