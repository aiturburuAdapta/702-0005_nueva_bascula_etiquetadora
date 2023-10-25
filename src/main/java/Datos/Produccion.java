/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Ander Goirigolzarri Iturburu
 */
public class Produccion {

    // --- Atributos ---
    private Integer pCodigoEmpresa;
    private String pEstadoEnvio;
    //private LocalDate pFechaEnvio;
    private Timestamp pFechaEnvio;
    private Integer pHora;
    //la hora debe pasarse a un double para poder introducirla en la BD. Deberiamos hacer el metodo que convierte la hora en un dato leible para la BD estático
    private Integer pEjercicioFabricacion;
    private String pSerieFabricacion;
    private Integer pNumeroFabricacion;
    private String pCodigoArticulo;
    private Integer pCodigoAgrupacion;
    private String pEtiqueta;
    private Integer pNumEtiquetaEspera;
    private Integer pUnidades1;
    private Integer pUnidades2;
    private String pUnidadMedida1;
    private String pUnidadMedida2;
    private String pDescripcionArticulo;
    private String pDescripcionArticulo2;
    private String pDescripcionArticulo3;
    private String pDescripcionArticulo4;
    private String pDescripcionArticulo5;
    private String pPropiedad01;
    private String pPropiedad02;
    private String pPropiedad03;
    private String pPropiedad04;
    private String pPropiedad05;
    private String pPropiedad06;
    private String pPropiedad07;
    private String pPropiedad08;
    private String pPropiedad09;
    private String pPropiedad10;
    private String pIngrediente01;
    private String pIngrediente02;
    private String pIngrediente03;
    private String pIngrediente04;
    private String pIngrediente05;
    private String pIngrediente06;
    private String pIngrediente07;
    private String pIngrediente08;
    private String pIngrediente09;
    private String pIngrediente10;
    private String pIngrediente11;
    private String pIngrediente12;
    private String pInsert1;
    private String pInsert2;
    private String pInsert3;
    private String pInsert4;

    /**
     * @return the pCodigoEmpresa
     */
    public Integer getpCodigoEmpresa() {
        return pCodigoEmpresa;
    }

    /**
     * @param pCodigoEmpresa the pCodigoEmpresa to set
     */
    public void setpCodigoEmpresa(Integer pCodigoEmpresa) {
        this.pCodigoEmpresa = pCodigoEmpresa;
    }

    /**
     * @return the pEstadoEnvio
     */
    public String getpEstadoEnvio() {
        return pEstadoEnvio;
    }

    /**
     * @param pEstadoEnvio the pEstadoEnvio to set
     */
    public void setpEstadoEnvio(String pEstadoEnvio) {
        this.pEstadoEnvio = pEstadoEnvio;
    }

    /**
     * @return the pFechaEnvio
     */
    public Timestamp getpFechaEnvio() {
        return pFechaEnvio;
    }

    /**
     * @param pFechaEnvio the pFechaEnvio to set
     */
    public void setpFechaEnvio(Timestamp pFechaEnvio) {
        this.pFechaEnvio = pFechaEnvio;
    }

    /**
     * @return the pHora
     */
    public Integer getpHora() {
        return pHora;
    }

    /**
     * @param pHora the pHora to set
     */
    public void setpHora(Integer pHora) {
        this.pHora = pHora;
    }

    /**
     * @return the pEjercicioFabricacion
     */
    public Integer getpEjercicioFabricacion() {
        return pEjercicioFabricacion;
    }

    /**
     * @param pEjercicioFabricacion the pEjercicioFabricacion to set
     */
    public void setpEjercicioFabricacion(Integer pEjercicioFabricacion) {
        this.pEjercicioFabricacion = pEjercicioFabricacion;
    }

    /**
     * @return the pSerieFabricacion
     */
    public String getpSerieFabricacion() {
        return pSerieFabricacion;
    }

    /**
     * @param pSerieFabricacion the pSerieFabricacion to set
     */
    public void setpSerieFabricacion(String pSerieFabricacion) {
        this.pSerieFabricacion = pSerieFabricacion;
    }

    /**
     * @return the pNumeroFabricacion
     */
    public Integer getpNumeroFabricacion() {
        return pNumeroFabricacion;
    }

    /**
     * @param pNumeroFabricacion the pNumeroFabricacion to set
     */
    public void setpNumeroFabricacion(Integer pNumeroFabricacion) {
        this.pNumeroFabricacion = pNumeroFabricacion;
    }

    /**
     * @return the pCodigoArticulo
     */
    public String getpCodigoArticulo() {
        return pCodigoArticulo;
    }

    /**
     * @param pCodigoArticulo the pCodigoArticulo to set
     */
    public void setpCodigoArticulo(String pCodigoArticulo) {
        this.pCodigoArticulo = pCodigoArticulo;
    }

    /**
     * @return the pCodigoAgrupacion
     */
    public Integer getpCodigoAgrupacion() {
        return pCodigoAgrupacion;
    }

    /**
     * @param pCodigoAgrupacion the pCodigoAgrupacion to set
     */
    public void setpCodigoAgrupacion(Integer pCodigoAgrupacion) {
        this.pCodigoAgrupacion = pCodigoAgrupacion;
    }

    /**
     * @return the pEtiqueta
     */
    public String getpEtiqueta() {
        return pEtiqueta;
    }

    /**
     * @param pEtiqueta the pEtiqueta to set
     */
    public void setpEtiqueta(String pEtiqueta) {
        this.pEtiqueta = pEtiqueta;
    }

    /**
     * @return the pNumEtiquetaEspera
     */
    public Integer getpNumEtiquetaEspera() {
        return pNumEtiquetaEspera;
    }

    /**
     * @param pNumEtiquetaEspera the pNumEtiquetaEspera to set
     */
    public void setpNumEtiquetaEspera(Integer pNumEtiquetaEspera) {
        this.pNumEtiquetaEspera = pNumEtiquetaEspera;
    }

    /**
     * @return the pUnidades1
     */
    public Integer getpUnidades1() {
        return pUnidades1;
    }

    /**
     * @param pUnidades1 the pUnidades1 to set
     */
    public void setpUnidades1(Integer pUnidades1) {
        this.pUnidades1 = pUnidades1;
    }

    /**
     * @return the pUnidades2
     */
    public Integer getpUnidades2() {
        return pUnidades2;
    }

    /**
     * @param pUnidades2 the pUnidades2 to set
     */
    public void setpUnidades2(Integer pUnidades2) {
        this.pUnidades2 = pUnidades2;
    }

    /**
     * @return the pUnidadMedida1
     */
    public String getpUnidadMedida1() {
        return pUnidadMedida1;
    }

    /**
     * @param pUnidadMedida1 the pUnidadMedida1 to set
     */
    public void setpUnidadMedida1(String pUnidadMedida1) {
        this.pUnidadMedida1 = pUnidadMedida1;
    }

    /**
     * @return the pUnidadMedida2
     */
    public String getpUnidadMedida2() {
        return pUnidadMedida2;
    }

    /**
     * @param pUnidadMedida2 the pUnidadMedida2 to set
     */
    public void setpUnidadMedida2(String pUnidadMedida2) {
        this.pUnidadMedida2 = pUnidadMedida2;
    }

    /**
     * @return the pDescripcionArticulo
     */
    public String getpDescripcionArticulo() {
        return pDescripcionArticulo;
    }

    /**
     * @param pDescripcionArticulo the pDescripcionArticulo to set
     */
    public void setpDescripcionArticulo(String pDescripcionArticulo) {
        this.pDescripcionArticulo = pDescripcionArticulo;
    }

    /**
     * @return the pDescripcionArticulo2
     */
    public String getpDescripcionArticulo2() {
        return pDescripcionArticulo2;
    }

    /**
     * @param pDescripcionArticulo2 the pDescripcionArticulo2 to set
     */
    public void setpDescripcionArticulo2(String pDescripcionArticulo2) {
        this.pDescripcionArticulo2 = pDescripcionArticulo2;
    }

    /**
     * @return the pDescripcionArticulo3
     */
    public String getpDescripcionArticulo3() {
        return pDescripcionArticulo3;
    }

    /**
     * @param pDescripcionArticulo3 the pDescripcionArticulo3 to set
     */
    public void setpDescripcionArticulo3(String pDescripcionArticulo3) {
        this.pDescripcionArticulo3 = pDescripcionArticulo3;
    }

    /**
     * @return the pDescripcionArticulo4
     */
    public String getpDescripcionArticulo4() {
        return pDescripcionArticulo4;
    }

    /**
     * @param pDescripcionArticulo4 the pDescripcionArticulo4 to set
     */
    public void setpDescripcionArticulo4(String pDescripcionArticulo4) {
        this.pDescripcionArticulo4 = pDescripcionArticulo4;
    }

    /**
     * @return the pDescripcionArticulo5
     */
    public String getpDescripcionArticulo5() {
        return pDescripcionArticulo5;
    }

    /**
     * @param pDescripcionArticulo5 the pDescripcionArticulo5 to set
     */
    public void setpDescripcionArticulo5(String pDescripcionArticulo5) {
        this.pDescripcionArticulo5 = pDescripcionArticulo5;
    }

    /**
     * @return the pPropiedad01
     */
    public String getpPropiedad01() {
        return pPropiedad01;
    }

    /**
     * @param pPropiedad01 the pPropiedad01 to set
     */
    public void setpPropiedad01(String pPropiedad01) {
        this.pPropiedad01 = pPropiedad01;
    }

    /**
     * @return the pPropiedad02
     */
    public String getpPropiedad02() {
        return pPropiedad02;
    }

    /**
     * @param pPropiedad02 the pPropiedad02 to set
     */
    public void setpPropiedad02(String pPropiedad02) {
        this.pPropiedad02 = pPropiedad02;
    }

    /**
     * @return the pPropiedad03
     */
    public String getpPropiedad03() {
        return pPropiedad03;
    }

    /**
     * @param pPropiedad03 the pPropiedad03 to set
     */
    public void setpPropiedad03(String pPropiedad03) {
        this.pPropiedad03 = pPropiedad03;
    }

    /**
     * @return the pPropiedad04
     */
    public String getpPropiedad04() {
        return pPropiedad04;
    }

    /**
     * @param pPropiedad04 the pPropiedad04 to set
     */
    public void setpPropiedad04(String pPropiedad04) {
        this.pPropiedad04 = pPropiedad04;
    }

    /**
     * @return the pPropiedad05
     */
    public String getpPropiedad05() {
        return pPropiedad05;
    }

    /**
     * @param pPropiedad05 the pPropiedad05 to set
     */
    public void setpPropiedad05(String pPropiedad05) {
        this.pPropiedad05 = pPropiedad05;
    }

    /**
     * @return the pPropiedad06
     */
    public String getpPropiedad06() {
        return pPropiedad06;
    }

    /**
     * @param pPropiedad06 the pPropiedad06 to set
     */
    public void setpPropiedad06(String pPropiedad06) {
        this.pPropiedad06 = pPropiedad06;
    }

    /**
     * @return the pPropiedad07
     */
    public String getpPropiedad07() {
        return pPropiedad07;
    }

    /**
     * @param pPropiedad07 the pPropiedad07 to set
     */
    public void setpPropiedad07(String pPropiedad07) {
        this.pPropiedad07 = pPropiedad07;
    }

    /**
     * @return the pPropiedad08
     */
    public String getpPropiedad08() {
        return pPropiedad08;
    }

    /**
     * @param pPropiedad08 the pPropiedad08 to set
     */
    public void setpPropiedad08(String pPropiedad08) {
        this.pPropiedad08 = pPropiedad08;
    }

    /**
     * @return the pPropiedad09
     */
    public String getpPropiedad09() {
        return pPropiedad09;
    }

    /**
     * @param pPropiedad09 the pPropiedad09 to set
     */
    public void setpPropiedad09(String pPropiedad09) {
        this.pPropiedad09 = pPropiedad09;
    }

    /**
     * @return the pPropiedad10
     */
    public String getpPropiedad10() {
        return pPropiedad10;
    }

    /**
     * @param pPropiedad10 the pPropiedad10 to set
     */
    public void setpPropiedad10(String pPropiedad10) {
        this.pPropiedad10 = pPropiedad10;
    }

    /**
     * @return the pIngrediente01
     */
    public String getpIngrediente01() {
        return pIngrediente01;
    }

    /**
     * @param pIngrediente01 the pIngrediente01 to set
     */
    public void setpIngrediente01(String pIngrediente01) {
        this.pIngrediente01 = pIngrediente01;
    }

    /**
     * @return the pIngrediente02
     */
    public String getpIngrediente02() {
        return pIngrediente02;
    }

    /**
     * @param pIngrediente02 the pIngrediente02 to set
     */
    public void setpIngrediente02(String pIngrediente02) {
        this.pIngrediente02 = pIngrediente02;
    }

    /**
     * @return the pIngrediente03
     */
    public String getpIngrediente03() {
        return pIngrediente03;
    }

    /**
     * @param pIngrediente03 the pIngrediente03 to set
     */
    public void setpIngrediente03(String pIngrediente03) {
        this.pIngrediente03 = pIngrediente03;
    }

    /**
     * @return the pIngrediente04
     */
    public String getpIngrediente04() {
        return pIngrediente04;
    }

    /**
     * @param pIngrediente04 the pIngrediente04 to set
     */
    public void setpIngrediente04(String pIngrediente04) {
        this.pIngrediente04 = pIngrediente04;
    }

    /**
     * @return the pIngrediente05
     */
    public String getpIngrediente05() {
        return pIngrediente05;
    }

    /**
     * @param pIngrediente05 the pIngrediente05 to set
     */
    public void setpIngrediente05(String pIngrediente05) {
        this.pIngrediente05 = pIngrediente05;
    }

    /**
     * @return the pIngrediente06
     */
    public String getpIngrediente06() {
        return pIngrediente06;
    }

    /**
     * @param pIngrediente06 the pIngrediente06 to set
     */
    public void setpIngrediente06(String pIngrediente06) {
        this.pIngrediente06 = pIngrediente06;
    }

    /**
     * @return the pIngrediente07
     */
    public String getpIngrediente07() {
        return pIngrediente07;
    }

    /**
     * @param pIngrediente07 the pIngrediente07 to set
     */
    public void setpIngrediente07(String pIngrediente07) {
        this.pIngrediente07 = pIngrediente07;
    }

    /**
     * @return the pIngrediente08
     */
    public String getpIngrediente08() {
        return pIngrediente08;
    }

    /**
     * @param pIngrediente08 the pIngrediente08 to set
     */
    public void setpIngrediente08(String pIngrediente08) {
        this.pIngrediente08 = pIngrediente08;
    }

    /**
     * @return the pIngrediente09
     */
    public String getpIngrediente09() {
        return pIngrediente09;
    }

    /**
     * @param pIngrediente09 the pIngrediente09 to set
     */
    public void setpIngrediente09(String pIngrediente09) {
        this.pIngrediente09 = pIngrediente09;
    }

    /**
     * @return the pIngrediente10
     */
    public String getpIngrediente10() {
        return pIngrediente10;
    }

    /**
     * @param pIngrediente10 the pIngrediente10 to set
     */
    public void setpIngrediente10(String pIngrediente10) {
        this.pIngrediente10 = pIngrediente10;
    }

    /**
     * @return the pIngrediente11
     */
    public String getpIngrediente11() {
        return pIngrediente11;
    }

    /**
     * @param pIngrediente11 the pIngrediente11 to set
     */
    public void setpIngrediente11(String pIngrediente11) {
        this.pIngrediente11 = pIngrediente11;
    }

    /**
     * @return the pIngrediente12
     */
    public String getpIngrediente12() {
        return pIngrediente12;
    }

    /**
     * @param pIngrediente12 the pIngrediente12 to set
     */
    public void setpIngrediente12(String pIngrediente12) {
        this.pIngrediente12 = pIngrediente12;
    }

    /**
     * @return the pInsert1
     */
    public String getpInsert1() {
        return pInsert1;
    }

    /**
     * @param pInsert1 the pInsert1 to set
     */
    public void setpInsert1(String pInsert1) {
        this.pInsert1 = pInsert1;
    }

    /**
     * @return the pInsert2
     */
    public String getpInsert2() {
        return pInsert2;
    }

    /**
     * @param pInsert2 the pInsert2 to set
     */
    public void setpInsert2(String pInsert2) {
        this.pInsert2 = pInsert2;
    }

    /**
     * @return the pInsert3
     */
    public String getpInsert3() {
        return pInsert3;
    }

    /**
     * @param pInsert3 the pInsert3 to set
     */
    public void setpInsert3(String pInsert3) {
        this.pInsert3 = pInsert3;
    }

    /**
     * @return the pInsert4
     */
    public String getpInsert4() {
        return pInsert4;
    } 

    /**
     * @param pInsert4 the pInsert4 to set
     */
    public void setpInsert4(String pInsert4) {
        this.pInsert4 = pInsert4;
    }
}
