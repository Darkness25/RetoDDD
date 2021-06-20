package estacionamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.values.NombreCliente;
import estacionamiento.values.TipoVehiculo;
import estacionamiento.values.VehiculoId;

public class VehiculoAgregado extends DomainEvent {


    private final VehiculoId vehiculoId;
    private final NombreCliente nombreCliente;
    private final TipoVehiculo tipoVehiculo;

    public VehiculoAgregado(VehiculoId vehiculoId, NombreCliente nombreCliente, TipoVehiculo tipoVehiculo) {
        super("sofka.estacionamiento.vehiculoagregado");
        this.vehiculoId = vehiculoId;
        this.nombreCliente = nombreCliente;
        this.tipoVehiculo = tipoVehiculo;

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
