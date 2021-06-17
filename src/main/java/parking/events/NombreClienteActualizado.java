package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.ClienteId;
import parking.values.NombreCliente;

public class NombreClienteActualizado extends DomainEvent {




    private ClienteId clienteId;
    private NombreCliente nombreCliente;

    public NombreClienteActualizado(ClienteId clienteId, NombreCliente nombreCliente) {
        super("sofka.parking.nombreclienteactualizado");
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }


}
