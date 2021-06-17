package parking.events;

import co.com.sofka.domain.generic.DomainEvent;
import parking.values.CeldaAsignada;
import parking.values.TiqueteId;

public class CeldaAsignadaActualizada extends DomainEvent {




    private final TiqueteId tiqueteId;
    private final CeldaAsignada celdaAsignada;

    public CeldaAsignadaActualizada(TiqueteId tiqueteId, CeldaAsignada celdaAsignada) {
        super("sofka.parking.celdaasignadaactualizada");

        this.tiqueteId = tiqueteId;
        this.celdaAsignada = celdaAsignada;
    }

    public TiqueteId getTiqueteId() {
        return tiqueteId;
    }

    public CeldaAsignada getCeldaAsignada() {
        return celdaAsignada;
    }

}
