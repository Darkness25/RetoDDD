package facturacion.commands;


import co.com.sofka.domain.generic.Command;
import facturacion.values.HoraSalida;
import facturacion.values.ParkingId;

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
