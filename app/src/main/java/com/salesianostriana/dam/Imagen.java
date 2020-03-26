package com.salesianostriana.dam;

public class Imagen {

    private String nombreFichero;
    private String uriDescargaFichero;
    private String tipoFichero;
    private long tamanyo;

    public Imagen(String nombreFichero, String uriDescargaFichero, String tipoFichero, long tamanyo) {
        this.nombreFichero = nombreFichero;
        this.uriDescargaFichero = uriDescargaFichero;
        this.tipoFichero = tipoFichero;
        this.tamanyo = tamanyo;
    }

    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public String getUriDescargaFichero() {
        return uriDescargaFichero;
    }

    public void setUriDescargaFichero(String uriDescargaFichero) {
        this.uriDescargaFichero = uriDescargaFichero;
    }

    public String getTipoFichero() {
        return tipoFichero;
    }

    public void setTipoFichero(String tipoFichero) {
        this.tipoFichero = tipoFichero;
    }

    public long getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(long tamanyo) {
        this.tamanyo = tamanyo;
    }
}
