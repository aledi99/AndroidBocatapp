package com.salesianostriana.dam;


import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class User {

    private String nombre, username,apellidos, password;
    private int edad;
    private long[] favoritos;
    private Ubicacion localizacion;
    private Avatar avatar;
    private List<Pedido> listPedidos;
    private Set<Role> roles;
    private Date fechaCreacion;
    private LocalDateTime lastPasswordChangedAt;

    public User(String nombre, String username, String apellidos, String password, int edad, long[] favoritos, Ubicacion localizacion, Avatar avatar, List<Pedido> listPedidos, Set<Role> roles, Date fechaCreacion, LocalDateTime lastPasswordChangedAt) {
        this.nombre = nombre;
        this.username = username;
        this.apellidos = apellidos;
        this.password = password;
        this.edad = edad;
        this.favoritos = favoritos;
        this.localizacion = localizacion;
        this.avatar = avatar;
        this.listPedidos = listPedidos;
        this.roles = roles;
        this.fechaCreacion = fechaCreacion;
        this.lastPasswordChangedAt = lastPasswordChangedAt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long[] getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(long[] favoritos) {
        this.favoritos = favoritos;
    }

    public Ubicacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Ubicacion localizacion) {
        this.localizacion = localizacion;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getLastPasswordChangedAt() {
        return lastPasswordChangedAt;
    }

    public void setLastPasswordChangedAt(LocalDateTime lastPasswordChangedAt) {
        this.lastPasswordChangedAt = lastPasswordChangedAt;
    }
}