package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.HoraIngreso;
import parking.values.TiqueteId;

public class HoraIngresoActualizada extends DomainEvent {

    private TiqueteId tiqueteId;
    private HoraIngreso horaIngreso;

    public HoraIngresoActualizada(TiqueteId tiqueteId, HoraIngreso horaIngreso) {
        super("sofka.parking.horaingresoactualizada");
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
