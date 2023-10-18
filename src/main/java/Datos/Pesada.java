/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.time.LocalDate;

/**
 *
 * @author PedroAlonsoMontejo
 */
public class Pesada {

    private String Telegrama;
    private String PID;
    private String MainPID;
    private String OrdenFabricacion;
    private double Peso;
    private double Cantidad;
    private String idProceso;
    private String tipo;
    private String codigoEmpresa;

    /**
     * @return the Telegrama
     */
    public String getTelegrama() {
        return Telegrama;
    }

    /**
     * @param Telegrama the Telegrama to set
     */
    public void setTelegrama(String Telegrama) {
        // Es necesario realizar este replace para que el itnerprete de JAVA entienda los backslashs como tal y no como carácteres escapados
        this.Telegrama = Telegrama.replaceAll("\\\\", "\\\\\\\\");
    }

    /**
     * @return the PID
     */
    public String getPID() {
        return PID;
    }

    /**
     * @param PID the PID to set
     */
    public void setPID(String PID) {
        this.PID = PID;
    }

    /**
     * @return the MainPID
     */
    public String getMainPID() {
        return MainPID;
    }

    /**
     * @param MainPID the MainPID to set
     */
    public void setMainPID(String MainPID) {
        this.MainPID = MainPID;
    }

    /**
     * @return the OrdenFabricacion
     */
    public String getOrdenFabricacion() {
        return OrdenFabricacion;
    }

    /**
     * @param OrdenFabricacion the OrdenFabricacion to set
     */
    public void setOrdenFabricacion(String OrdenFabricacion) {
        this.OrdenFabricacion = OrdenFabricacion;
    }

    /**
     * @return the Peso
     */
    public double getPeso() {
        return Peso;
    }

    /**
     * @param Peso the Peso to set
     */
    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    /**
     * @return the Cantidad
     */
    public double getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return the idProceso
     */
    public String getIdProceso() {
        return idProceso;
    }

    /**
     * @param idProceso the idProceso to set
     */
    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the codigoEmpresa
     */
    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    /**
     * @param codigoEmpresa the codigoEmpresa to set
     */
    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

}
