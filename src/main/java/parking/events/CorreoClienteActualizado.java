package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.ClienteId;
import parking.values.CorreoCliente;

public class CorreoClienteActualizado extends DomainEvent {




    private ClienteId clienteId;
    private CorreoCliente correoCliente;

    public CorreoClienteActualizado(ClienteId clienteId, CorreoCliente correoCliente) {
        super("sofka.parking.correoclienteactualizado");
        this.clienteId = clienteId;
        this.correoCliente = correoCliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CorreoCliente getCorreoCliente() {
        return correoCliente;
    }
}
