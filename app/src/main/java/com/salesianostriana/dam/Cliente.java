package com.salesianostriana.dam;

import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Cliente extends User {

    private long idCliente;
    private boolean validado;

    public Cliente(String nombre, String username, String apellidos, String password, int edad, long[] favoritos, Ubicacion localizacion, Avatar avatar, List<Pedido> listPedidos, Set<Role> roles, Date fechaCreacion, LocalDateTime lastPasswordChangedAt, long idCliente, boolean validado) {
        super(nombre, username, apellidos, password, edad, favoritos, localizacion, avatar, listPedidos, roles, fechaCreacion, lastPasswordChangedAt);
        this.idCliente = idCliente;
        this.validado = validado;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
}
