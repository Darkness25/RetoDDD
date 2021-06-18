package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.ParkingId;
import parking.values.TiqueteId;

public class ParkingCreado extends DomainEvent {
    private final ParkingId parkingId;
    private final TiqueteId tiqueteId;

    public ParkingCreado(ParkingId parkingId, TiqueteId tiqueteId) {
        super("sofka.parking.parkingcreado");
        this.parkingId = parkingId;
        this.tiqueteId = tiqueteId;
    }

    public ParkingId getParkingId() {
        return parkingId;
    }

    public TiqueteId getTiqueteId() {
        return tiqueteId;
    }
}
