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


/**
 *
 * @author PedroAlonsoMontejo, Ander Goirigolzarri Iturburu
 */
public class IncidenciaGestor { //static

    // Dar de alta incidencia en base de datos
    public void AltaIncidenciaBD(Incidencia pInc) {
        try {
            DataSource ds = new DataSource();

            //Generar la cadena para insertar la info en la base de datos
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
            smnt.setDouble(2, pInc.getpHora()); // Reemplaza con la hora real
            smnt.setInt(3, pInc.getpCodigoEmpresa()); // Reemplaza con el código de empresa real
            smnt.setString(4, pInc.getpAd_TipoIncidencia()); // Reemplaza con el tipo de incidencia real
            smnt.setString(5, pInc.getpAd_DescripcionIncidencia()); // Reemplaza con la descripción real
            smnt.setString(6, pInc.getpTipoDocumento()); // Reemplaza con el tipo de documento real
            smnt.setInt(7, pInc.getpEjercicioDocumento()); // Reemplaza con el ejercicio real
            smnt.setString(8, pInc.getpSerieDocumento()); // Reemplaza con la serie de documento real
            smnt.setInt(9, pInc.getpNumeroDocumento()); // Reemplaza con el número de documento real
            smnt.setString(10, pInc.getpAd_IDProceso()); // Reemplaza con el ID de proceso real
            smnt.setString(11, pInc.getpMovOrigen()); // Reemplaza con el movimiento de origen real

            ds.ejecutarInsert(smnt);
            ds.cerrarConexion();

        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(IncidenciaGestor.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }
}
