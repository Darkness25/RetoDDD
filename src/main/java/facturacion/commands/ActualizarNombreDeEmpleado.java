package facturacion.commands;


import co.com.sofka.domain.generic.Command;
import facturacion.values.Nombre;
import facturacion.values.ParkingId;

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
