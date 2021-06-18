package parking;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import parking.values.NombrePropietario;
import parking.values.TipoVehiculo;
import parking.values.VehiculoId;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoId> {
    private NombrePropietario nombrePropietario;
    private TipoVehiculo tipoVehiculo;

    public Vehiculo(VehiculoId entityId, NombrePropietario nombrePropietario, TipoVehiculo tipoVehiculo) {
        super(entityId);
        this.nombrePropietario = nombrePropietario;
        this.tipoVehiculo = tipoVehiculo;
    }

    public void ActualizarNombrePropietario(NombrePropietario nombrePropietario){
        this.nombrePropietario = Objects.requireNonNull(nombrePropietario);
    }


    public void ActualizarTipoVehiculo(TipoVehiculo tipoVehiculo){
        this.tipoVehiculo = Objects.requireNonNull(tipoVehiculo);
    }

    public NombrePropietario NombrePropietario() {
        return nombrePropietario;
    }

    public TipoVehiculo TipoVehiculo() {
        return tipoVehiculo;
    }
}
