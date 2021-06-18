package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.ParkingId;
import co.com.sofka.blog.domain.usuario.values.Telefono;
import co.com.sofka.domain.generic.Command;

public class ActualizarTelefonoDeEmpleado implements Command {

    private final ParkingId parkingId;
    private final Telefono telefono;

    public ActualizarTelefonoDeEmpleado(ParkingId parkingId, Telefono telefono) {
        this.parkingId = parkingId;
        this.telefono = telefono;
    }

    public ParkingId getIdUsuario() {
        return parkingId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
