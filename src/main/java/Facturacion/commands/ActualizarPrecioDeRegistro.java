package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.ParkingId;
import co.com.sofka.blog.domain.usuario.values.Precio;
import co.com.sofka.domain.generic.Command;

public class ActualizarPrecioDeRegistro implements Command {

    private final ParkingId parkingId;
    private final Precio precio;

    public ActualizarPrecioDeRegistro(ParkingId parkingId, Precio precio) {
        this.parkingId = parkingId;
        this.precio = precio;
    }

    public ParkingId getIdUsuario() {
        return parkingId;
    }

    public Precio getPrecio() {
        return precio;
    }
}

