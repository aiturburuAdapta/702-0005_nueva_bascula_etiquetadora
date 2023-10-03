/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Modelo para el objeto Incidencia
 *
 * @author PedroAlonsoMontejo, Ander Goirigolzarri Iturburu
 */
public class Incidencia {

    // --- Atributos ---
    private String pIdContador;
    private LocalDate pFechaRegistro;
    private LocalDateTime pHora;
    private short pCodigoEmpresa;
    private String pAd_TipoIncidencia;
    private String pAd_DescripcionIncidencia;
    private String pTipoDocumento;
    private short pEjercicioDocumento;
    private String pSerieDocumento;
    private int pNumeroDocumento;
    private String pAd_IDProceso;
    private String pMovOrigen;


    // --- Getters $ Setters ---
    /**
     * @return the pIdContador
     */
    public String getpIdContador() {
        return pIdContador;
    }

    /**
     * @param pIdContador the pIdContador to set
     */
    public void setpIdContador(String pIdContador) {
        this.pIdContador = pIdContador;
    }

    /**
     * @return the pFechaRegistro
     */
    public LocalDate getpFechaRegistro() {
        return pFechaRegistro;
    }

    /**
     * @param pFechaRegistro the pFechaRegistro to set
     */
    public void setpFechaRegistro(LocalDate pFechaRegistro) {
        this.pFechaRegistro = pFechaRegistro;
    }

    /**
     * @return the pHora
     */
    public LocalDateTime getpHora() {
        return pHora;
    }

    /**
     * @param pHora the pHora to set
     */
    public void setpHora(LocalDateTime pHora) {
        this.pHora = pHora;
    }

    /**
     * @return the pCodigoEmpresa
     */
    public short getpCodigoEmpresa() {
        return pCodigoEmpresa;
    }

    /**
     * @param pCodigoEmpresa the pCodigoEmpresa to set
     */
    public void setpCodigoEmpresa(short pCodigoEmpresa) {
        this.pCodigoEmpresa = pCodigoEmpresa;
    }

    /**
     * @return the pAd_TipoIncidencia
     */
    public String getpAd_TipoIncidencia() {
        return pAd_TipoIncidencia;
    }

    /**
     * @param pAd_TipoIncidencia the pAd_TipoIncidencia to set
     */
    public void setpAd_TipoIncidencia(String pAd_TipoIncidencia) {
        this.pAd_TipoIncidencia = pAd_TipoIncidencia;
    }

    /**
     * @return the pAd_DescripcionIncidencia
     */
    public String getpAd_DescripcionIncidencia() {
        return pAd_DescripcionIncidencia;
    }

    /**
     * @param pAd_DescripcionIncidencia the pAd_DescripcionIncidencia to set
     */
    public void setpAd_DescripcionIncidencia(String pAd_DescripcionIncidencia) {
        this.pAd_DescripcionIncidencia = pAd_DescripcionIncidencia;
    }

    /**
     * @return the pTipoDocumento
     */
    public String getpTipoDocumento() {
        return pTipoDocumento;
    }

    /**
     * @param pTipoDocumento the pTipoDocumento to set
     */
    public void setpTipoDocumento(String pTipoDocumento) {
        this.pTipoDocumento = pTipoDocumento;
    }

    /**
     * @return the pEjercicioDocumento
     */
    public short getpEjercicioDocumento() {
        return pEjercicioDocumento;
    }

    /**
     * @param pEjercicioDocumento the pEjercicioDocumento to set
     */
    public void setpEjercicioDocumento(short pEjercicioDocumento) {
        this.pEjercicioDocumento = pEjercicioDocumento;
    }

    /**
     * @return the pSerieDocumento
     */
    public String getpSerieDocumento() {
        return pSerieDocumento;
    }

    /**
     * @param pSerieDocumento the pSerieDocumento to set
     */
    public void setpSerieDocumento(String pSerieDocumento) {
        this.pSerieDocumento = pSerieDocumento;
    }

    /**
     * @return the pNumeroDocumento
     */
    public int getpNumeroDocumento() {
        return pNumeroDocumento;
    }

    /**
     * @param pNumeroDocumento the pNumeroDocumento to set
     */
    public void setpNumeroDocumento(int pNumeroDocumento) {
        this.pNumeroDocumento = pNumeroDocumento;
    }

    /**
     * @return the pAd_IDProceso
     */
    public String getpAd_IDProceso() {
        return pAd_IDProceso;
    }

    /**
     * @param pAd_IDProceso the pAd_IDProceso to set
     */
    public void setpAd_IDProceso(String pAd_IDProceso) {
        this.pAd_IDProceso = pAd_IDProceso;
    }

    /**
     * @return the pMovOrigen
     */
    public String getpMovOrigen() {
        return pMovOrigen;
    }

    /**
     * @param pMovOrigen the pMovOrigen to set
     */
    public void setpMovOrigen(String pMovOrigen) {
        this.pMovOrigen = pMovOrigen;
    }
}
