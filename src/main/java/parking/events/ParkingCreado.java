package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.ParkingId;

public class ParkingCreado extends DomainEvent {
    private final ParkingId parkingId;

    public ParkingCreado(ParkingId parkingId) {
        super("sofka.parking.parkingcreado");
        this.parkingId = parkingId;
    }

    public ParkingId getParkingId() {
        return parkingId;
    }
}
