package facturacion.commands;

import co.com.sofka.domain.generic.Command;
import facturacion.values.ParkingId;
import facturacion.values.Telefono;

public class ActualizarTelefonoDeEmpleado implements Command {

    private final ParkingId parkingId;
    private final Telefono telefono;

    public ActualizarTelefonoDeEmpleado(ParkingId parkingId, Telefono telefono) {
        this.parkingId = parkingId;
        this.telefono = telefono;
    }

    public ParkingId getParkingId() {
        return parkingId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
