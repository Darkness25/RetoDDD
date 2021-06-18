package parking;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import parking.values.CeldaAsignada;
import parking.values.HoraIngreso;
import parking.values.TiqueteId;

import java.util.Objects;

public class Tiquete extends Entity<TiqueteId> {
    private HoraIngreso horaIngreso;
    private CeldaAsignada celdaAsignada;

    public Tiquete(TiqueteId entityId, HoraIngreso horaIngreso, CeldaAsignada celdaAsignada) {
        super(entityId);
        this.horaIngreso = horaIngreso;
        this.celdaAsignada = celdaAsignada;
    }

    public void ActualizarCeldaAsignada(CeldaAsignada celdaAsignada){
        this.celdaAsignada = Objects.requireNonNull(celdaAsignada);
    }

    public void ActualizarHoraIngreso(HoraIngreso horaIngreso){
        this.horaIngreso = Objects.requireNonNull(horaIngreso);
    }

    public HoraIngreso HoraIngreso() {
        return horaIngreso;
    }

    public CeldaAsignada CeldaAsignada() {
        return celdaAsignada;
    }
}
