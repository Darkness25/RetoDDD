package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.NombrePropietario;
import parking.values.VehiculoId;

public class NombrePropietarioActualizado extends DomainEvent {


    private final VehiculoId vehiculoId;
    private final NombrePropietario nombrePropietario;

    public NombrePropietarioActualizado(VehiculoId vehiculoId, NombrePropietario nombrePropietario) {
        super("sofka.parking.nombrepropietarioactualizado");
        this.vehiculoId = vehiculoId;
        this.nombrePropietario = nombrePropietario;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public NombrePropietario getNombrePropietario() {
        return nombrePropietario;
    }

}
