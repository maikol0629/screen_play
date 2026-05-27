package com.calidad.blazedemo.models;

public class DatosPago {
    private final String tipoTarjeta;
    private final String numeroTarjeta;
    private final String mesVencimiento;
    private final String anioVencimiento;
    private final String nombreTitular;

    public DatosPago(String tipoTarjeta, String numeroTarjeta, String mesVencimiento,
                     String anioVencimiento, String nombreTitular) {
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.mesVencimiento = mesVencimiento;
        this.anioVencimiento = anioVencimiento;
        this.nombreTitular = nombreTitular;
    }

    public String getTipoTarjeta() { return tipoTarjeta; }
    public String getNumeroTarjeta() { return numeroTarjeta; }
    public String getMesVencimiento() { return mesVencimiento; }
    public String getAnioVencimiento() { return anioVencimiento; }
    public String getNombreTitular() { return nombreTitular; }
}
