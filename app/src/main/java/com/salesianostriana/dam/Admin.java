package com.salesianostriana.dam;

import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Admin extends User {

    private long idAdmin;

    public Admin(String nombre, String username, String apellidos, String password, int edad, long[] favoritos, Ubicacion localizacion, Avatar avatar, List<Pedido> listPedidos, Set<Role> roles, Date fechaCreacion, LocalDateTime lastPasswordChangedAt, long idAdmin) {
        super(nombre, username, apellidos, password, edad, favoritos, localizacion, avatar, listPedidos, roles, fechaCreacion, lastPasswordChangedAt);
        this.idAdmin = idAdmin;
    }

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }
}
