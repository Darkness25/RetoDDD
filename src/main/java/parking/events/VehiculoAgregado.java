package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.NombrePropietario;
import parking.values.TipoVehiculo;
import parking.values.VehiculoId;

public class VehiculoAgregado extends DomainEvent {
    private VehiculoId vehiculoid;
    private TipoVehiculo tipoVehiculo;
    private NombrePropietario nombrePropietario;

    public VehiculoAgregado(VehiculoId vehiculoid, TipoVehiculo tipoVehiculo, NombrePropietario nombrePropietario) {
        super("sofka.parking.vehiculoagregado");
        this.vehiculoid = vehiculoid;
        this.tipoVehiculo = tipoVehiculo;
        this.nombrePropietario = nombrePropietario;
    }
}
