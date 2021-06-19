package facturacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import facturacion.values.HoraSalida;

public class HoraDeSalidaDeFacturaActualizada extends DomainEvent {

    private final HoraSalida horaSalida;

    public HoraDeSalidaDeFacturaActualizada(HoraSalida horaSalida) {
        super("sofka.facturacion.horadesalidadefacturaactualizada");
        this.horaSalida = horaSalida;
    }

    public HoraSalida getClaveUsuario() {
        return horaSalida;
    }
}
