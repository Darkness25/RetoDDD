package estacionamiento.commands;

import co.com.sofka.domain.generic.Command;
import estacionamiento.values.EstacionamientoId;
import estacionamiento.values.NombreCliente;
import estacionamiento.values.TipoVehiculo;
import estacionamiento.values.VehiculoId;

public class AgregarVehiculo implements Command {

    private final EstacionamientoId estacionamientoId;
    private final VehiculoId vehiculoId;
    private final NombreCliente nombreCliente;
    private final TipoVehiculo tipoVehiculo;

    public AgregarVehiculo(EstacionamientoId estacionamientoId, VehiculoId vehiculoId, NombreCliente nombreCliente, TipoVehiculo tipoVehiculo) {
        this.estacionamientoId = estacionamientoId;
        this.vehiculoId = vehiculoId;
        this.nombreCliente = nombreCliente;
        this.tipoVehiculo = tipoVehiculo;

    }

    public EstacionamientoId getEstacionamientoId() {
        return estacionamientoId;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}
