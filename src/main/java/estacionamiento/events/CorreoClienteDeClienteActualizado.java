package estacionamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.values.CorreoCliente;

public class CorreoClienteDeClienteActualizado extends DomainEvent {

    private final CorreoCliente correoCliente;

    public CorreoClienteDeClienteActualizado(CorreoCliente correoCliente) {
        super("sofka.estacionamiento.correodeclienteactualizado");
        this.correoCliente = correoCliente;

    }

    public CorreoCliente getCorreoCliente() {
        return correoCliente;
    }
}
