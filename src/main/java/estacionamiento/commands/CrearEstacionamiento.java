package estacionamiento.commands;

import co.com.sofka.domain.generic.Command;
import estacionamiento.values.CorreoCliente;
import estacionamiento.values.EstacionamientoId;
import estacionamiento.values.NombreCliente;
import facturacion.values.ParkingId;


public class CrearEstacionamiento implements Command {

    private final ParkingId parkingId;
    private final EstacionamientoId estacionamientoId;
    private final NombreCliente nombreCliente;
    private final CorreoCliente correoCliente;


    public CrearEstacionamiento(EstacionamientoId estacionamientoId, ParkingId parkingId, NombreCliente nombreCliente, CorreoCliente correoCliente) {
        this.estacionamientoId = estacionamientoId;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.parkingId = parkingId;

    }

    public ParkingId getParkingId() {
        return parkingId;
    }

    public EstacionamientoId getEstacionamientoId() {
        return estacionamientoId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }

    public CorreoCliente getCorreoCliente() {
        return correoCliente;
    }
}
