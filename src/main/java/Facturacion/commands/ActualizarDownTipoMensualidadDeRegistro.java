package facturacion.commands;


import co.com.sofka.domain.generic.Command;
import facturacion.values.ParkingId;
import facturacion.values.TipoMensualidad;

public class ActualizarDownTipoMensualidadDeRegistro implements Command {

    private final ParkingId parkingId;
    private final TipoMensualidad tipoMensualidad;

    public ActualizarDownTipoMensualidadDeRegistro(ParkingId parkingId, TipoMensualidad tipoMensualidad) {
        this.parkingId = parkingId;
        this.tipoMensualidad = tipoMensualidad;
    }

    public ParkingId getIdUsuario() {
        return parkingId;
    }

    public TipoMensualidad getRango() {
        return tipoMensualidad;
    }
}
