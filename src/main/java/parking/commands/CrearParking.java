package parking.commands;

import co.com.sofka.domain.generic.Command;
import parking.values.ParkingId;

public class CrearParking  implements Command {

    private final ParkingId entityId;

    public CrearParking(ParkingId entityId){
        this.entityId = entityId;
    }

    public ParkingId getEntityId() {
        return entityId;
    }
}
