package parking;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import parking.events.ClienteAgregado;
import parking.events.ParkingCreado;
import parking.events.TiqueteAgregado;
import parking.events.VehiculoAgregado;
import parking.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Parking extends AggregateEvent<ParkingId> {

    protected ParkingId parkingId;
    protected TiqueteId tiqueteId;
    protected ClienteId clienteId;
    protected VehiculoId vehiculoId;
    protected Set<Cliente> clientes;
    protected Set<Tiquete> tiquetes;
    protected Set<Vehiculo> vehiculos;



    public Parking(ParkingId entityId, TiqueteId tiqueteId) {
        super(entityId);
        appendChange(new ParkingCreado(entityId)).apply();

    }
    private Parking(ParkingId entityId){
        super(entityId);
        subscribe(new ParkingChange(this));

    }
    public static Parking from(ParkingId parkingId, List<DomainEvent> events){
        var parking = new Parking(parkingId);
        events.forEach(parking::applyEvent);
        return parking;
    }

    public void AgregarCliente(ClienteId entityId, NombreCliente nombreCliente, CorreoCliente correoCliente){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombreCliente);
        Objects.requireNonNull(correoCliente);

        appendChange(new ClienteAgregado(entityId, nombreCliente, correoCliente)).apply();

    }

    public void AgregarTiquete(TiqueteId entityId, HoraIngreso horaIngreso, CeldaAsignada celdaAsignada){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(horaIngreso);
        Objects.requireNonNull(celdaAsignada);

        appendChange(new TiqueteAgregado(entityId, horaIngreso, celdaAsignada)).apply();

    }

    public void AgregarVehiculo(VehiculoId entityId, TipoVehiculo tipoVehiculo, NombrePropietario nombrePropietario){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(tipoVehiculo);
        Objects.requireNonNull(nombrePropietario);

        appendChange(new VehiculoAgregado(entityId, tipoVehiculo, nombrePropietario)).apply();
    }

    public Optional<Cliente> getClientePorId( ClienteId entityId){
        return Clientes()
                .stream()
                .filter(cliente -> cliente.identity().equals(entityId))
                .findFirst();
    }

    public Optional<Tiquete> getTiquetePorId( TiqueteId entityId){
        return Tiquetes()
                .stream()
                .filter(tiquete -> tiquete.identity().equals(entityId))
                .findFirst();
    }


    public Optional<Vehiculo> getVehiculoPorId( VehiculoId entityId){
        return Vehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.identity().equals(entityId))
                .findFirst();
    }



    public ParkingId ParkingId() {
        return parkingId;
    }

    public TiqueteId TiqueteId() {
        return tiqueteId;
    }

    public ClienteId ClienteId() {
        return clienteId;
    }

    public VehiculoId VehiculoId() {
        return vehiculoId;
    }

    public Set<Cliente> Clientes() {
        return clientes;
    }

    public Set<Tiquete> Tiquetes() {
        return tiquetes;
    }

    public Set<Vehiculo> Vehiculos() {
        return vehiculos;
    }
}
