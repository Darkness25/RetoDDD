package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.ClienteId;
import parking.values.CorreoCliente;
import parking.values.NombreCliente;

public class ClienteAgregado extends DomainEvent {




    private final ClienteId entityId;
    private final NombreCliente nombreCliente;
    private final CorreoCliente correoCliente;

    public ClienteAgregado(ClienteId entityId, NombreCliente nombreCliente, CorreoCliente correoCliente) {
        super("sofka.parking.clienteagregado");
        this.entityId = entityId;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
    }

    public ClienteId getEntityId() {
        return entityId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }

    public CorreoCliente getCorreoCliente() {
        return correoCliente;
    }


}
