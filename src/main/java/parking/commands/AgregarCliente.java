package parking.commands;

import co.com.sofka.domain.generic.Command;
import parking.values.ClienteId;
import parking.values.CorreoCliente;
import parking.values.NombreCliente;
import parking.values.ParkingId;

public class AgregarCliente implements Command {

    private final ParkingId parkingId;
    private final ClienteId entityId;
    private final NombreCliente nombreCliente;
    private final CorreoCliente correoCliente;

    public AgregarCliente(ParkingId parkingId, ClienteId entityId, NombreCliente nombreCliente, CorreoCliente correoCliente){

        this.parkingId = parkingId;
        this.entityId = entityId;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
    }

    public ParkingId getParkingId() {
        return parkingId;
    }

    public ClienteId getEntityId() {
        return entityId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }

    public CorreoCliente getCorreoCliente() {
        return correoCliente;
    }
}
