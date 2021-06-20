package estacionamiento.commands;

import co.com.sofka.domain.generic.Command;
import estacionamiento.Estacionamiento;
import estacionamiento.values.CorreoCliente;
import estacionamiento.values.EstacionamientoId;

public class ActualizarCorreoClienteDeCliente implements Command {
    private final EstacionamientoId estacionamientoId;
    private final CorreoCliente correoCliente;

    public ActualizarCorreoClienteDeCliente(EstacionamientoId estacionamientoId, CorreoCliente correoCliente) {
        this.estacionamientoId = estacionamientoId;
        this.correoCliente = correoCliente;
    }

    public EstacionamientoId getEstacionamientoId() {
        return estacionamientoId;
    }

    public CorreoCliente getCorreoCliente() {
        return correoCliente;
    }
}
