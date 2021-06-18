package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.ParkingId;
import co.com.sofka.blog.domain.usuario.values.TipoMensualidad;
import co.com.sofka.domain.generic.Command;

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
