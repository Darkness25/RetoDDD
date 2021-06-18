package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.CeldaAsignada;
import parking.values.HoraIngreso;
import parking.values.ParkingId;
import parking.values.TiqueteId;

public class TiqueteAgregado extends DomainEvent {

    private final ParkingId parkingId;
    private final TiqueteId tiqueteId;
    private final HoraIngreso horaIngreso;
    private final CeldaAsignada celdaAsignada;

    public TiqueteAgregado(ParkingId parkingId, TiqueteId tiqueteId, HoraIngreso horaIngreso, CeldaAsignada celdaAsignada) {
        super("sofka.parking.tiqueteagregado");
        this.parkingId = parkingId;
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

    public ParkingId ParkingId() {
        return parkingId;
    }
}
