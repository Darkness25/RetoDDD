package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.CeldaAsignada;
import parking.values.HoraIngreso;
import parking.values.TiqueteId;

public class TiqueteAgregado extends DomainEvent {

    private TiqueteId tiqueteId;
    private HoraIngreso horaIngreso;
    private CeldaAsignada celdaAsignada;

    public TiqueteAgregado(TiqueteId tiqueteId, HoraIngreso horaIngreso, CeldaAsignada celdaAsignada) {
        super("sofka.parking.tiqueteagregado");
        this.tiqueteId = tiqueteId;
        this.horaIngreso = horaIngreso;
        this.celdaAsignada = celdaAsignada;
    }

    public TiqueteId getTiqueteId() {
        return tiqueteId;
    }

    public HoraIngreso getHoraIngreso() {
        return horaIngreso;
    }

    public CeldaAsignada getCeldaAsignada() {
        return celdaAsignada;
    }
}
