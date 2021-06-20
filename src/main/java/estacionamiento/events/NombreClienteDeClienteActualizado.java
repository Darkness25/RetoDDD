package estacionamiento.events;


import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.values.NombreCliente;

public class NombreClienteDeClienteActualizado extends DomainEvent {


    private final NombreCliente nombreCliente;

    public NombreClienteDeClienteActualizado(NombreCliente nombreCliente) {
        super("sofka.estacionamiento.nombreclientedeclienteactualizado");
        this.nombreCliente = nombreCliente;

    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}
