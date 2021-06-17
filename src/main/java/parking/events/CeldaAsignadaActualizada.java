package parking.events;

import co.com.sofka.domain.generic.DomainEvent;

public class CeldaAsignadaActualizada extends DomainEvent {
    public CeldaAsignadaActualizada(String type) {
        super(type);
    }
}
