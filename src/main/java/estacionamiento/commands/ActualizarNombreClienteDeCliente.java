package estacionamiento.commands;


import co.com.sofka.domain.generic.Command;
import estacionamiento.values.EstacionamientoId;
import estacionamiento.values.NombreCliente;

public class ActualizarNombreClienteDeCliente implements Command {

    private final EstacionamientoId estacionamientoId;
    private final NombreCliente nombreCliente;

    public ActualizarNombreClienteDeCliente(EstacionamientoId estacionamientoId, NombreCliente nombreCliente) {
        this.estacionamientoId = estacionamientoId;
        this.nombreCliente = nombreCliente;

    }

    public EstacionamientoId getEstacionamientoId() {
        return estacionamientoId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}
