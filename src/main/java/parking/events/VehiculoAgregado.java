package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.NombrePropietario;
import parking.values.TipoVehiculo;
import parking.values.VehiculoId;

public class VehiculoAgregado extends DomainEvent {
    private final VehiculoId vehiculoId;
    private final TipoVehiculo tipoVehiculo;
    private final NombrePropietario nombrePropietario;

    public VehiculoId VehiculoId() {
        return vehiculoId;
    }

    public TipoVehiculo TipoVehiculo() {
        return tipoVehiculo;
    }

    public NombrePropietario NombrePropietario() {
        return nombrePropietario;
    }

    public VehiculoAgregado(VehiculoId vehiculoId, TipoVehiculo tipoVehiculo, NombrePropietario nombrePropietario) {
        super("sofka.parking.vehiculoagregado");
        this.vehiculoId = vehiculoId;
        this.tipoVehiculo = tipoVehiculo;
        this.nombrePropietario = nombrePropietario;
    }


}
