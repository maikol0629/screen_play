package com.calidad.blazedemo.models;

public class DatosPasajero {
    private final String nombre;
    private final String direccion;
    private final String ciudad;
    private final String estado;
    private final String codigoPostal;

    public DatosPasajero(String nombre, String direccion, String ciudad,
                         String estado, String codigoPostal) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getCiudad() { return ciudad; }
    public String getEstado() { return estado; }
    public String getCodigoPostal() { return codigoPostal; }
}
