package com.salesianostriana.dam;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstablecimientoResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("presupuesto")
    @Expose
    private Double presupuesto;
    @SerializedName("abierto")
    @Expose
    private Boolean abierto;
    @SerializedName("valoracion")
    @Expose
    private Double valoracion;
    @SerializedName("imagen")
    @Expose
    private ImagenResponse imagen;
    @SerializedName("localizacion")
    @Expose
    private Ubicacion localizacion;
    @SerializedName("horaApertura")
    @Expose
    private String horaApertura;
    @SerializedName("horaCierre")
    @Expose
    private String horaCierre;
    @SerializedName("gerente")
    @Expose
    private Gerente gerente;
    @SerializedName("categoria")
    @Expose
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Boolean getAbierto() {
        return abierto;
    }

    public void setAbierto(Boolean abierto) {
        this.abierto = abierto;
    }

    public Double getValoracion() {
        return valoracion;
    }

    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }

    public ImagenResponse getImagen() {
        return imagen;
    }

    public void setImagen(ImagenResponse imagen) {
        this.imagen = imagen;
    }

    public Ubicacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Ubicacion localizacion) {
        this.localizacion = localizacion;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}