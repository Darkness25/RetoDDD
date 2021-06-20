package estacionamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.values.HoraIngreso;
import estacionamiento.values.TipoVehiculo;
import estacionamiento.values.TiqueteId;

public class TiqueteAgregado extends DomainEvent {

    private final TiqueteId tiqueteId;
    private final TipoVehiculo tipoVehiculo;
    private final HoraIngreso horaIngreso;

    public TiqueteAgregado(TiqueteId tiqueteId, TipoVehiculo tipoVehiculo, HoraIngreso horaIngreso) {
        super("sofka.estacionamiento.tiqueteagregado");
        this.tiqueteId = tiqueteId;
        this.tipoVehiculo = tipoVehiculo;
        this.horaIngreso = horaIngreso;

    }

    public TiqueteId getTiqueteId() {
        return tiqueteId;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public HoraIngreso getHoraIngreso() {
        return horaIngreso;
    }
}
