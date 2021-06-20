package estacionamiento;

import co.com.sofka.domain.generic.Entity;
import estacionamiento.values.HoraIngreso;
import estacionamiento.values.TipoVehiculo;
import estacionamiento.values.TiqueteId;

import java.util.Objects;

public class Tiquete extends Entity<TiqueteId> {

    protected TipoVehiculo tipoVehiculo;
    protected HoraIngreso horaIngreso;


    public Tiquete(TiqueteId entityId, TipoVehiculo tipoVehiculo, HoraIngreso horaIngreso) {
        super(entityId);
        this.tipoVehiculo = tipoVehiculo;
        this.horaIngreso = horaIngreso;

    }

    public void modificarHoraDeIngreso(HoraIngreso horaIngreso){
        this.horaIngreso = Objects.requireNonNull(horaIngreso);
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public HoraIngreso getHoraIngreso() {
        return horaIngreso;
    }
}
