package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.CeldaAsignada;
import parking.values.HoraIngreso;
import parking.values.TiqueteId;

public class TiqueteAgregado extends DomainEvent {

    private final TiqueteId tiqueteId;
    private final HoraIngreso horaIngreso;
    private final CeldaAsignada celdaAsignada;

    public TiqueteAgregado(TiqueteId tiqueteId, HoraIngreso horaIngreso, CeldaAsignada celdaAsignada) {
        super("sofka.parking.tiqueteagregado");
        this.tiqueteId = tiqueteId;
        this.horaIngreso = horaIngreso;
        this.celdaAsignada = celdaAsignada;
    }

    public TiqueteId TiqueteId() {
        return tiqueteId;
    }

    public HoraIngreso HoraIngreso() {
        return horaIngreso;
    }

    public CeldaAsignada CeldaAsignada() {
        return celdaAsignada;
    }



}
