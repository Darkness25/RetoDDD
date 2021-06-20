package estacionamiento.commands;

import co.com.sofka.domain.generic.Command;
import estacionamiento.values.EstacionamientoId;
import estacionamiento.values.HoraIngreso;
import estacionamiento.values.TiqueteId;

public class ActualizarHoraDeIngresoDeTiquete implements Command {

    private final EstacionamientoId estacionamientoId;
    private final TiqueteId tiqueteId;
    private final HoraIngreso horaIngreso;

    public ActualizarHoraDeIngresoDeTiquete(EstacionamientoId estacionamientoId, TiqueteId tiqueteId, HoraIngreso horaIngreso) {
        this.estacionamientoId = estacionamientoId;
        this.tiqueteId = tiqueteId;
        this.horaIngreso = horaIngreso;

    }

    public EstacionamientoId getEstacionamientoId() {
        return estacionamientoId;
    }

    public TiqueteId getTiqueteId() {
        return tiqueteId;
    }

    public HoraIngreso getHoraIngreso() {
        return horaIngreso;
    }
}
