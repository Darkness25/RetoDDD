package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.ParkingId;
import co.com.sofka.blog.domain.usuario.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDeEmpleado implements Command {

    private final ParkingId parkingId;
    private final Nombre nombre;

    public ActualizarNombreDeEmpleado(ParkingId parkingId, Nombre nombre) {
        this.parkingId = parkingId;
        this.nombre = nombre;
    }

    public ParkingId getIdUsuario() {
        return parkingId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
