package facturacion.commands;
import co.com.sofka.domain.generic.Command;
import facturacion.values.ParkingId;
import facturacion.values.Precio;

public class ActualizarPrecioDeRegistro implements Command {

    private final ParkingId parkingId;
    private final Precio precio;

    public ActualizarPrecioDeRegistro(ParkingId parkingId, Precio precio) {
        this.parkingId = parkingId;
        this.precio = precio;
    }

    public ParkingId getParkingId() {
        return parkingId;
    }

    public Precio getPrecio() {
        return precio;
    }
}

