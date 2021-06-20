package estacionamiento.values;

import co.com.sofka.domain.generic.ValueObject;
import facturacion.values.ParkingId;

import java.util.Objects;

public class TipoVehiculo implements ValueObject<TipoVehiculo.Props> {

    private final ParkingId parkingId;
    private final String nombre;

    public TipoVehiculo(ParkingId parkingId, String nombre) {
        this.parkingId = Objects.requireNonNull(parkingId);
        this.nombre = Objects.requireNonNull(nombre);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public ParkingId parkingId() {
                return parkingId;
            }

            @Override
            public String nombre() {
                return nombre;
            }
        };
    }

    public interface  Props{
        ParkingId parkingId();
        String nombre();
    }

}
