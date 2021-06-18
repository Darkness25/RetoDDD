package co.com.sofka.blog.domain.usuario.commands;

import co.com.sofka.blog.domain.usuario.values.HoraSalida;
import co.com.sofka.blog.domain.usuario.values.ParkingId;
import co.com.sofka.domain.generic.Command;

public class ActualizarHoraSalidaDeFactura implements Command {

    private final ParkingId parkingId;
    private final HoraSalida horaSalida;

    public ActualizarHoraSalidaDeFactura(ParkingId parkingId, HoraSalida horaSalida) {
        this.parkingId = parkingId;
        this.horaSalida = horaSalida;
    }

    public ParkingId getIdUsuario() {
        return parkingId;
    }

    public HoraSalida getClaveUsuario() {
        return horaSalida;
    }
}
