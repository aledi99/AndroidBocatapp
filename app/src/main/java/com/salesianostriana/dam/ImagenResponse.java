package com.salesianostriana.dam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImagenResponse {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombreFichero")
    @Expose
    private String nombreFichero;
    @SerializedName("uriDescargaFichero")
    @Expose
    private String uriDescargaFichero;
    @SerializedName("tipoFichero")
    @Expose
    private String tipoFichero;
    @SerializedName("tamanyo")
    @Expose
    private Integer tamanyo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(Integer tamanyo) {
        this.tamanyo = tamanyo;
    }

}