package parking.commands;

import co.com.sofka.domain.generic.Command;
import parking.values.NombreCliente;
import parking.values.NombrePropietario;
import parking.values.ParkingId;
import parking.values.TipoVehiculo;

public class AgregarVehiculo implements Command {

    private final ParkingId parkingId;
    private final TipoVehiculo tipoVehiculo;
    private final NombrePropietario nombrePropietario;

    public AgregarVehiculo(ParkingId parkingId, TipoVehiculo tipoVehiculo, NombrePropietario nombrePropietario){

        this.parkingId = parkingId;
        this.tipoVehiculo = tipoVehiculo;
        this.nombrePropietario = nombrePropietario;
    }

    public ParkingId getParkingId() {
        return parkingId;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public NombrePropietario getNombrePropietario() {
        return nombrePropietario;
    }
}
