package estacionamiento.commands;

import co.com.sofka.domain.generic.Command;
import estacionamiento.values.EstacionamientoId;
import estacionamiento.values.NombreCliente;
import estacionamiento.values.VehiculoId;

public class ActualizarNombreClienteDeVehiculo implements Command {

    private final EstacionamientoId estacionamientoId;
    private final VehiculoId vehiculoId;
    private final NombreCliente nombreCliente;

    public ActualizarNombreClienteDeVehiculo(EstacionamientoId estacionamientoId, VehiculoId vehiculoId, NombreCliente nombreCliente) {
        this.estacionamientoId = estacionamientoId;
        this.vehiculoId = vehiculoId;
        this.nombreCliente = nombreCliente;

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
}
