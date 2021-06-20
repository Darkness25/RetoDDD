package estacionamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.values.NombreCliente;
import estacionamiento.values.VehiculoId;

public class NombreClienteDeVehiculoActualizado extends DomainEvent {


    private final VehiculoId vehiculoId;
    private final NombreCliente nombreCliente;

    public NombreClienteDeVehiculoActualizado(VehiculoId vehiculoId, NombreCliente nombreCliente) {
        super("sofka.estacionamiento.nombreclientedevehiculoactualizado");
        this.vehiculoId = vehiculoId;
        this.nombreCliente = nombreCliente;

    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}
