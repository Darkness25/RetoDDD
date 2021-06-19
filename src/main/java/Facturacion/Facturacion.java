package facturacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import facturacion.events.*;
import facturacion.values.*;

import java.util.List;
import java.util.Objects;

public class Facturacion extends AggregateEvent<ParkingId> {

    protected Registro registro;
    protected Empleado empleado;
    protected Factura factura;

    public Facturacion(ParkingId entityId, Registro registro, Empleado empleado, Factura factura) {
        super(entityId);
        Objects.requireNonNull(registro);
        Objects.requireNonNull(empleado);
        Objects.requireNonNull(factura);
        appendChange(new FacturacionGenerada(registro, empleado, factura)).apply();
    }

    public Facturacion(ParkingId parkingId){
        super(parkingId);
        subscribe(new FacturacionChange(this));
    }

    public static Facturacion from(ParkingId parkingId, List<DomainEvent> events){
        var usuario = new Facturacion(parkingId);
        events.forEach(usuario::applyEvent);
        return usuario;
    }

    public void modificarClaveUsuarioDeCuenta(HoraSalida horaSalida){
        Objects.requireNonNull(horaSalida);
        appendChange(new HoraDeSalidaDeFacturaActualizada(horaSalida)).apply();
    }

    public void modificarNombreDePersona(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreDeEmpleadoActualizado(nombre)).apply();
    }

    public void modificarTelefonoDePersona(Telefono telefono){
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoDeEmpleadoActualizado(telefono)).apply();
    }

    public void aumentarRangoDeSuscripcion(TipoMensualidad tipoMensualidad){
        appendChange(new TipoDeMensualidadActualizadaUp(tipoMensualidad)).apply();
    }

    public void disminuirRangoDeSuscripcion(TipoMensualidad tipoMensualidad){
        appendChange(new TipoDeMensualidadActualizadaDown(tipoMensualidad)).apply();
    }

    public void modificarPrecioDeSuscripcion(Precio precio){
        Objects.requireNonNull(precio);
        appendChange(new PrecioDeRegistroActualizado(precio)).apply();
    }

    public Registro suscripcion(){
        return this.registro;
    }

    public Empleado persona(){
        return this.empleado;
    }

    public Factura cuenta(){
        return this.factura;
    }

}
