package estacionamiento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.events.*;
import estacionamiento.values.*;
import facturacion.values.ParkingId;

import java.util.List;
import java.util.Objects;

public class Estacionamiento extends AggregateEvent<EstacionamientoId> {

    protected NombreCliente nombreCliente;
    protected CorreoCliente correoCliente;
    protected ParkingId parkingId;
    protected Cliente cliente;
    protected List<Vehiculo> vehiculos;
    protected List<Tiquete> tiquetes;
    private TiqueteId tiqueteId;
    private HoraIngreso horaIngreso;

    public Estacionamiento(EstacionamientoId entityId, ParkingId parkingId, NombreCliente nombreCliente, CorreoCliente correoCliente) {
        super(entityId);
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        Objects.requireNonNull(parkingId);
        Objects.requireNonNull(nombreCliente);
        Objects.requireNonNull(correoCliente);
        var estacionamientoId = new ClienteId();
        appendChange(new EstacionamientoCreado(parkingId,estacionamientoId,nombreCliente,correoCliente)).apply();
    }

    public Estacionamiento(EstacionamientoId estacionamientoId){
        super(estacionamientoId);
        subscribe(new EstacionamientoChange(this));
    }

    public static Estacionamiento from(EstacionamientoId idPublicacion, List<DomainEvent> events){
        var estacionamiento = new Estacionamiento(idPublicacion);
        events.forEach(estacionamiento::applyEvent);
        return estacionamiento;
    }

    public void modificarHoraIngresoDeTiquete(TiqueteId tiqueteId, HoraIngreso horaIngreso){
        this.tiqueteId = tiqueteId;
        this.horaIngreso = horaIngreso;
        Objects.requireNonNull(tiqueteId);
        Objects.requireNonNull(horaIngreso);
        appendChange(new HoraDeIngresoDeTiqueteActualizada(tiqueteId,horaIngreso)).apply();
    }

    public void modificarNombreClienteDeVehiculo(VehiculoId vehiculoId, NombreCliente nombreCliente){
        Objects.requireNonNull(vehiculoId);
        Objects.requireNonNull(nombreCliente);
        appendChange(new NombreClienteDeVehiculoActualizado(vehiculoId,nombreCliente)).apply();
    }

    public void modificarCorreoClienteDeCliente(CorreoCliente correoCliente){
        Objects.requireNonNull(correoCliente);
        appendChange(new CorreoClienteDeClienteActualizado(correoCliente)).apply();
    }

    public void modificarNombreClienteDeCliente(NombreCliente nombreCliente){
        Objects.requireNonNull(nombreCliente);
        appendChange(new NombreClienteDeClienteActualizado(nombreCliente)).apply();
    }

    public void agregarTiquete(TiqueteId tiqueteId,TipoVehiculo tipoVehiculo,HoraIngreso horaIngreso){
        Objects.requireNonNull(tiqueteId);
        Objects.requireNonNull(tipoVehiculo);
        Objects.requireNonNull(horaIngreso);
        appendChange(new TiqueteAgregado(tiqueteId,tipoVehiculo,horaIngreso)).apply();
    }

    public void agregarVehiculo(VehiculoId vehiculoId,NombreCliente nombreCliente,TipoVehiculo tipoVehiculo){
        Objects.requireNonNull(vehiculoId);
        Objects.requireNonNull(nombreCliente);
        Objects.requireNonNull(tipoVehiculo);
        appendChange(new VehiculoAgregado(vehiculoId,nombreCliente,tipoVehiculo)).apply();
    }

    public Tiquete tiquetePorId(TiqueteId tiqueteId){
        return tiquetes.stream().filter(valor ->valor.identity().equals(tiqueteId)).findFirst().orElseThrow();
    }

    public Vehiculo vehculoPorId(VehiculoId vehiculoId){
        return vehiculos.stream().filter(vehiculo -> vehiculo.identity().equals(vehiculoId)).findFirst().orElseThrow();
    }

    public ParkingId idUsuario() {
        return parkingId;
    }

    public Cliente contenido() {
        return cliente;
    }

    public List<Vehiculo> comentarios() {
        return vehiculos;
    }

    public List<Tiquete> tiquetes() {
        return tiquetes;
    }
}
