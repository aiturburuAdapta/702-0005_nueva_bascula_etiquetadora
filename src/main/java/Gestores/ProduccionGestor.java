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
 *
 * @author Ander Goirigolzarri Iturburu
 */
public class ProduccionGestor {

    private Produccion objProduccion = null;

    public Produccion ProduccionFromBD() {
        try {
            DataSource ds = new DataSource();
            objProduccion = new Produccion();

            String sql = "SELECT * FROM ad_SynEsp_ProduccionEnCurso";

            PreparedStatement smnt = ds.recibirSelect(sql);

            if (smnt != null) {
                ResultSet rset = smnt.executeQuery();
                if (rset.next()) {
                    objProduccion.setpCodigoEmpresa(rset.getInt("codigo_empresa"));
                    objProduccion.setpEstadoEnvio(rset.getString("estado_envio"));
                    objProduccion.setpFechaEnvio(rset.getDate("fecha_envio").toLocalDate());
                    objProduccion.setpHora(rset.getInt("hora"));
                    objProduccion.setpEjercicioFabricacion(rset.getInt("ejercicio_fabricacion"));
                    objProduccion.setpSerieFabricacion(rset.getString("serie_fabricacion"));
                    objProduccion.setpNumeroFabricacion(rset.getInt("numero_fabricacion"));
                    objProduccion.setpCodigoArticulo(rset.getString("codigo_articulo"));
                    objProduccion.setpCodigoAgrupacion(rset.getInt("codigo_agrupacion"));
                    objProduccion.setpEtiqueta(rset.getString("etiqueta"));
                    objProduccion.setpNumEtiquetaEspera(rset.getInt("num_etiqueta_espera"));
                    objProduccion.setpUnidades1(rset.getInt("unidades1"));
                    objProduccion.setpUnidades2(rset.getInt("unidades2"));
                    objProduccion.setpUnidadMedida1(rset.getString("unidad_medida1"));
                    objProduccion.setpUnidadMedida2(rset.getString("unidad_medida2"));
                    objProduccion.setpDescripcionArticulo(rset.getString("descripcion_articulo"));
                    objProduccion.setpDescripcionArticulo2(rset.getString("descripcion_articulo2"));
                    objProduccion.setpDescripcionArticulo3(rset.getString("descripcion_articulo3"));
                    objProduccion.setpDescripcionArticulo4(rset.getString("descripcion_articulo4"));
                    objProduccion.setpDescripcionArticulo5(rset.getString("descripcion_articulo5"));
                    objProduccion.setpPropiedad01(rset.getString("propiedad01"));
                    objProduccion.setpPropiedad02(rset.getString("propiedad02"));
                    objProduccion.setpPropiedad03(rset.getString("propiedad03"));
                    objProduccion.setpPropiedad04(rset.getString("propiedad04"));
                    objProduccion.setpPropiedad05(rset.getString("propiedad05"));
                    objProduccion.setpPropiedad06(rset.getString("propiedad06"));
                    objProduccion.setpPropiedad07(rset.getString("propiedad07"));
                    objProduccion.setpPropiedad08(rset.getString("propiedad08"));
                    objProduccion.setpPropiedad09(rset.getString("propiedad09"));
                    objProduccion.setpPropiedad10(rset.getString("propiedad10"));
                    objProduccion.setpIngrediente01(rset.getString("ingrediente01"));
                    objProduccion.setpIngrediente02(rset.getString("ingrediente02"));
                    objProduccion.setpIngrediente03(rset.getString("ingrediente03"));
                    objProduccion.setpIngrediente04(rset.getString("ingrediente04"));
                    objProduccion.setpIngrediente05(rset.getString("ingrediente05"));
                    objProduccion.setpIngrediente06(rset.getString("ingrediente06"));
                    objProduccion.setpIngrediente07(rset.getString("ingrediente07"));
                    objProduccion.setpIngrediente08(rset.getString("ingrediente08"));
                    objProduccion.setpIngrediente09(rset.getString("ingrediente09"));
                    objProduccion.setpIngrediente10(rset.getString("ingrediente10"));
                    objProduccion.setpIngrediente11(rset.getString("ingrediente11"));
                    objProduccion.setpIngrediente12(rset.getString("ingrediente12"));
                    objProduccion.setpInsert1(rset.getString("insert1"));
                    objProduccion.setpInsert2(rset.getString("insert2"));
                    objProduccion.setpInsert3(rset.getString("insert3"));
                    objProduccion.setpInsert4(rset.getString("insert4"));
                }

                rset.close();
                smnt.close();
            }

            ds.cerrarConexion();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return objProduccion;
    }

}
