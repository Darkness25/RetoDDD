package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.TipoVehiculo;
import parking.values.VehiculoId;

public class TipoVehiculoActualizado extends DomainEvent {


    private final VehiculoId vehiculoId;
    private final TipoVehiculo tipoVehiculo;

    public TipoVehiculoActualizado(VehiculoId vehiculoId, TipoVehiculo tipoVehiculo) {
        super("sofka.parking.tipovehiculoactualizado");
        this.vehiculoId = vehiculoId;
        this.tipoVehiculo = tipoVehiculo;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

}
