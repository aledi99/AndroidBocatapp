package com.salesianostriana.dam;

import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Gerente extends User {

    private boolean validado;
    private String tlfContacto;

    public Gerente(String nombre, String username, String apellidos, String password, int edad, long[] favoritos, Ubicacion localizacion, Avatar avatar, List<Pedido> listPedidos, Set<Role> roles, Date fechaCreacion, LocalDateTime lastPasswordChangedAt, boolean validado, String tlfContacto) {
        super(nombre, username, apellidos, password, edad, favoritos, localizacion, avatar, listPedidos, roles, fechaCreacion, lastPasswordChangedAt);
        this.validado = validado;
        this.tlfContacto = tlfContacto;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public String getTlfContacto() {
        return tlfContacto;
    }

    public void setTlfContacto(String tlfContacto) {
        this.tlfContacto = tlfContacto;
    }
}
