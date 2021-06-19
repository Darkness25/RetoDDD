package parking.commands;

import co.com.sofka.domain.generic.Command;
import parking.values.CeldaAsignada;
import parking.values.HoraIngreso;
import parking.values.ParkingId;
import parking.values.TiqueteId;

public class CrearParking  implements Command {

    private final ParkingId entityId;
    private TiqueteId tiqueteId;


    public CrearParking(ParkingId entityId, TiqueteId tiqueteId){
        this.entityId = entityId;

        this.tiqueteId = tiqueteId;
    }

    public ParkingId getEntityId() {
        return entityId;
    }

    public TiqueteId getTiqueteId() {
        return tiqueteId;
    }
}
