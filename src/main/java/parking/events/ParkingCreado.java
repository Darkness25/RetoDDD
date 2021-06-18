package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.ParkingId;
import parking.values.TiqueteId;

public class ParkingCreado extends DomainEvent {
    private final ParkingId parkingId;


    public ParkingCreado(ParkingId parkingId, TiqueteId tiqueteId) {
        super("sofka.parking.parkingcreado");
        this.parkingId = parkingId;

    }



    public ParkingId getParkingId() {
        return parkingId;
    }


}
