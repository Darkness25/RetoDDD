package facturacion.commands;


import co.com.sofka.domain.generic.Command;
import facturacion.values.ParkingId;
import facturacion.values.TipoMensualidad;

public class ActualizarUpTipoMensualidadDeRegistro implements Command {

    private final ParkingId parkingId;
    private final TipoMensualidad tipoMensualidad;

    public ActualizarUpTipoMensualidadDeRegistro(ParkingId parkingId, TipoMensualidad tipoMensualidad) {
        this.parkingId = parkingId;
        this.tipoMensualidad = tipoMensualidad;
    }

    public ParkingId getParkingId() {
        return parkingId;
    }

    public TipoMensualidad getTipoMensualidad() {
        return tipoMensualidad;
    }
}
