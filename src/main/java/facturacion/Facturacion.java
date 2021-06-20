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
        var facturacion = new Facturacion(parkingId);
        events.forEach(facturacion::applyEvent);
        return facturacion;
    }

    public void modificarHoraSalidaDefactura(HoraSalida horaSalida){
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

    public void aumentarTipoMensualidadDeRegistro(TipoMensualidad tipoMensualidad){
        appendChange(new TipoDeMensualidadActualizadaUp(tipoMensualidad)).apply();
    }

    public void disminuirTipoMensualidadDeRegistro(TipoMensualidad tipoMensualidad){
        appendChange(new TipoDeMensualidadActualizadaDown(tipoMensualidad)).apply();
    }

    public void modificarPrecioDeRegistro(Precio precio){
        Objects.requireNonNull(precio);
        appendChange(new PrecioDeRegistroActualizado(precio)).apply();
    }

    public Registro registro(){
        return this.registro;
    }

    public Empleado empleado(){
        return this.empleado;
    }

    public Factura factura(){
        return this.factura;
    }

}
