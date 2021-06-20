package estacionamiento;

import co.com.sofka.domain.generic.Entity;
import estacionamiento.values.NombreCliente;
import estacionamiento.values.TipoVehiculo;
import estacionamiento.values.VehiculoId;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoId> {

    protected NombreCliente nombreCliente;
    protected TipoVehiculo tipoVehiculo;


    public Vehiculo(VehiculoId entityId, NombreCliente nombreCliente, TipoVehiculo tipoVehiculo) {
        super(entityId);
        this.nombreCliente = nombreCliente;
        this.tipoVehiculo = tipoVehiculo;

    }

    public void modificarNombre(NombreCliente nombreCliente){
        this.nombreCliente = Objects.requireNonNull(nombreCliente);
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}
