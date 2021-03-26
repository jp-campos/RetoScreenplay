package com.accenture.screenplay.model;

import java.time.LocalDateTime;

public class Vuelo {

    private String origen;
    private String destino;
    private boolean soloIda;
    private String fechaIda;
    private String fechaRegreso;
    private int pasajeros;

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public boolean isSoloIda() {
        return soloIda;
    }

    public void setSoloIda(boolean soloIda) {
        this.soloIda = soloIda;
    }

    public String getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(String fechaIda) {
        this.fechaIda = fechaIda;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }
}
