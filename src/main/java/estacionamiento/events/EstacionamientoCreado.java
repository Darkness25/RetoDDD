package estacionamiento.events;

import co.com.sofka.domain.generic.DomainEvent;

import estacionamiento.values.ClienteId;
import estacionamiento.values.CorreoCliente;
import estacionamiento.values.NombreCliente;
import facturacion.values.ParkingId;

public class EstacionamientoCreado extends DomainEvent {

    private final ParkingId parkingId;
    private final ClienteId clienteId;
    private final NombreCliente nombreCliente;
    private final CorreoCliente correoCliente;


    public EstacionamientoCreado(ParkingId parkingId, ClienteId clienteId, NombreCliente nombreCliente, CorreoCliente correoCliente) {
        super("sofka.estacionamiento.estacionamientocreado");
        this.parkingId = parkingId;
        this.clienteId = clienteId;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;

    }

    public ParkingId getParkingId() {
        return parkingId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }

    public CorreoCliente getCorreoCliente() {
        return correoCliente;
    }
}
