package parking;

import co.com.sofka.domain.generic.AggregateEvent;
import parking.values.ClienteId;
import parking.values.ParkingId;
import parking.values.TiqueteId;
import parking.values.VehiculoId;

import java.util.Set;

public class Parking extends AggregateEvent<ParkingId> {

    protected ParkingId parkingId;
    protected TiqueteId tiqueteId;
    protected ClienteId clienteId;
    protected VehiculoId vehiculoId;
    protected Set<Cliente> clientes;
    protected Set<Tiquete> tiquetes;
    protected Set<Vehiculo> vehiculos;



    public Parking(ParkingId entityId) {
        super(entityId);
    }
}
