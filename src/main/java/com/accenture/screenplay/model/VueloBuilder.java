package com.accenture.screenplay.model;

import com.accenture.screenplay.util.FechaHelper;

public class VueloBuilder {


    private Vuelo vuelo;


    public VueloBuilder(String desde){
        this.vuelo = new Vuelo();
        vuelo.setOrigen(desde);
        vuelo.setSoloIda(false);
    }

    public static VueloBuilder desde(String desde){
        return new VueloBuilder(desde);
    }

    public VueloBuilder hacia(String hacia){
        vuelo.setDestino(hacia);
        return this;
    }

    public VueloBuilder soloIda(){
        vuelo.setSoloIda(true);
        return this;
    }

    public VueloBuilder idaElDiaDeManiana(){
        vuelo.setFechaIda(FechaHelper.fechaManiana());
        return this;
    }

    public Vuelo conPasajeros(int pasajeros){
        vuelo.setPasajeros(pasajeros);
        return vuelo;
    }





}
