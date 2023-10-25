/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import ConexionBD.DataSource;
import Datos.Produccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Esta clase gestiona los métodos de lógica relacionados con los objetos
 * 'Producción'.
 *
 * @author Ander Goirigolzarri Iturburu
 */
public class ProduccionGestor {

    /**
     * Recupera un objeto de tipo Produccion desde la base de datos.
     *
     * @return Un objeto de tipo Produccion con los datos recuperados desde la
     * base de datos.
     */
    public Produccion ProduccionFromBD() {
        Produccion objProduccion = null;
        try {
            DataSource ds = new DataSource();
            objProduccion = new Produccion();

            String sql = "SELECT * FROM ad_SynEsp_ProduccionEnCurso WHERE ad_EstadoEnvio = 'P'";

            PreparedStatement smnt = ds.recibirSelect(sql);

            if (smnt != null) {
                ResultSet rset = smnt.executeQuery();

                if (rset.next()) { // se podría añadir un else para hacer un control por si la tabla está vacia
                    objProduccion.setpCodigoEmpresa(rset.getInt("CodigoEmpresa"));
                    objProduccion.setpEstadoEnvio(rset.getString("ad_EstadoEnvio"));
                    objProduccion.setpFechaEnvio(rset.getTimestamp("FechaEnvio"));
                    //24-10: AGI: comprobar que el formato de fecha recibido de la BD sirve
                    objProduccion.setpHora(rset.getInt("hora"));
                    objProduccion.setpEjercicioFabricacion(rset.getInt("EjercicioFabricacion"));
                    objProduccion.setpSerieFabricacion(rset.getString("SerieFabricacion"));
                    objProduccion.setpNumeroFabricacion(rset.getInt("NumeroFabricacion"));
                    objProduccion.setpCodigoArticulo(rset.getString("CodigoArticulo"));
                    objProduccion.setpCodigoAgrupacion(rset.getInt("CodigoAgrupacion"));
                    objProduccion.setpEtiqueta(rset.getString("ad_Etiqueta"));
                    objProduccion.setpNumEtiquetaEspera(rset.getInt("ad_NumEtiquetaEspera"));
                    objProduccion.setpUnidades1(rset.getInt("unidades1"));
                    objProduccion.setpUnidades2(rset.getInt("unidades2"));
                    objProduccion.setpUnidadMedida1(rset.getString("UnidadMedida1_"));
                    objProduccion.setpUnidadMedida2(rset.getString("UnidadMedida2_"));
                    objProduccion.setpDescripcionArticulo(rset.getString("DescripcionArticulo"));
                    objProduccion.setpDescripcionArticulo2(rset.getString("ad_Descripcion2Articulo"));
                    objProduccion.setpDescripcionArticulo3(rset.getString("ad_Descripcion3Articulo"));
                    objProduccion.setpDescripcionArticulo4(rset.getString("ad_Descripcion4Articulo"));
                    objProduccion.setpDescripcionArticulo5(rset.getString("ad_Descripcion5Articulo"));
                    objProduccion.setpPropiedad01(rset.getString("ad_Propiedad01"));
                    objProduccion.setpPropiedad02(rset.getString("ad_Propiedad02"));
                    objProduccion.setpPropiedad03(rset.getString("ad_Propiedad03"));
                    objProduccion.setpPropiedad04(rset.getString("ad_Propiedad04"));
                    objProduccion.setpPropiedad05(rset.getString("ad_Propiedad05"));
                    objProduccion.setpPropiedad06(rset.getString("ad_Propiedad06"));
                    objProduccion.setpPropiedad07(rset.getString("ad_Propiedad07"));
                    objProduccion.setpPropiedad08(rset.getString("ad_Propiedad08"));
                    objProduccion.setpPropiedad09(rset.getString("ad_Propiedad09"));
                    objProduccion.setpPropiedad10(rset.getString("ad_Propiedad10"));
                    objProduccion.setpIngrediente01(rset.getString("ad_Ingredientes1"));
                    objProduccion.setpIngrediente02(rset.getString("ad_Ingredientes2"));
                    objProduccion.setpIngrediente03(rset.getString("ad_Ingredientes3"));
                    objProduccion.setpIngrediente04(rset.getString("ad_Ingredientes4"));
                    objProduccion.setpIngrediente05(rset.getString("ad_Ingredientes5"));
                    objProduccion.setpIngrediente06(rset.getString("ad_Ingredientes6"));
                    objProduccion.setpIngrediente07(rset.getString("ad_Ingredientes7"));
                    objProduccion.setpIngrediente08(rset.getString("ad_Ingredientes8"));
                    objProduccion.setpIngrediente09(rset.getString("ad_Ingredientes9"));
                    objProduccion.setpIngrediente10(rset.getString("ad_Ingredientes10"));
                    objProduccion.setpIngrediente11(rset.getString("ad_Ingredientes11"));
                    objProduccion.setpIngrediente12(rset.getString("ad_Ingredientes12"));
                    objProduccion.setpInsert1(rset.getString("ad_Insert1"));
                    objProduccion.setpInsert2(rset.getString("ad_Insert2"));
                    objProduccion.setpInsert3(rset.getString("ad_Insert3"));
                    objProduccion.setpInsert4(rset.getString("ad_Insert4"));

                    // Cambiar el valor de ad_EstadoEnvio a 'R' en la base de datos
                    String updateSql = "UPDATE ad_SynEsp_ProduccionEnCurso SET ad_EstadoEnvio = 'R'";
                    PreparedStatement updateStatement = ds.getPreparedStatement(updateSql);
                    updateStatement.executeUpdate();
                    updateStatement.close();
                }
                rset.close();
                smnt.close();
            }
            ds.cerrarConexion();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //LOGGER 
        }
        return objProduccion;
    }

    public String ProduccionToTelegrama(Produccion objProduccion) {
        String vTelegramaEnvio;
        if (!objProduccion.getpInsert1().isEmpty()) {
            vTelegramaEnvio = objProduccion.getpInsert1();
            if (!objProduccion.getpInsert2().isEmpty()) {
                vTelegramaEnvio = vTelegramaEnvio.concat(objProduccion.getpInsert2());
                if (!objProduccion.getpInsert3().isEmpty()) {
                    vTelegramaEnvio = vTelegramaEnvio.concat(objProduccion.getpInsert3());
                    if (!objProduccion.getpInsert4().isEmpty()) {
                        vTelegramaEnvio = vTelegramaEnvio.concat(objProduccion.getpInsert4());
                    }
                }
            }
        } else {
            vTelegramaEnvio = "800[10]1|";
            vTelegramaEnvio += "INSERT INTO SD_Aufrufdaten";
            vTelegramaEnvio += " (AR_AufrufNr, AR_KundenNr, AR_EtikettenformatNr, AR_Artikeltext1Zeile, AR_LandesCode, AR_BarcodeArtikelnummer)";
            vTelegramaEnvio += " Values(1,0,1,'TextoPrueba', 16, 'C1104')";
            vTelegramaEnvio += "\\800[0]0|\\";
        }
        return vTelegramaEnvio;
    }
}
