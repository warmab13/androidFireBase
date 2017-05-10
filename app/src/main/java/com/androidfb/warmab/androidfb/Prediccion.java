package com.androidfb.warmab.androidfb;

/**
 * Created by warmab on 5/9/17.
 */

public class Prediccion {
    private String cielo;
    private long temperatura;
    private double humedad;

    public Prediccion(){
        //Constructor por defecto
    }

    public Prediccion(String cielo, long temperatura, double humedad){
        this.cielo = cielo;
        this.temperatura =  temperatura;
        this.humedad = humedad;
    }

    public String getCielo() {
        return cielo;
    }

    public void setCielo(String cielo) {
        this.cielo = cielo;
    }

    public long getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(long temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    @Override
    public String toString() {
        return "Prediccion{" +
                "cielo='" + cielo + '\'' +
                ", temperatura=" + temperatura +
                ", humedad=" + humedad +
                '}';
    }
}
