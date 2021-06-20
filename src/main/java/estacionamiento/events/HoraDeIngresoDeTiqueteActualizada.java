package estacionamiento.events;

import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.values.HoraIngreso;
import estacionamiento.values.TiqueteId;

public class HoraDeIngresoDeTiqueteActualizada extends DomainEvent {


    private final TiqueteId tiqueteId;
    private final HoraIngreso horaIngreso;

    public HoraDeIngresoDeTiqueteActualizada(TiqueteId tiqueteId, HoraIngreso horaIngreso) {
        super("sofka.estacionamiento.horadeingresodetiqueteactualizada");
        this.tiqueteId = tiqueteId;
        this.horaIngreso = horaIngreso;

    }

    public TiqueteId getTiqueteId() {
        return tiqueteId;
    }

    public HoraIngreso getHoraIngreso() {
        return horaIngreso;
    }
}
