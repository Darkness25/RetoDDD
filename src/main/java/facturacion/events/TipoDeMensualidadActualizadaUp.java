package facturacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import facturacion.values.TipoMensualidad;

public class TipoDeMensualidadActualizadaUp extends DomainEvent {

    private final TipoMensualidad tipoMensualidad;

    public TipoDeMensualidadActualizadaUp(TipoMensualidad tipoMensualidad) {
        super("sofka.facturacion.tipodemensualidadactualizadaup");
        this.tipoMensualidad = tipoMensualidad;
    }

    public TipoMensualidad getRango() {
        return tipoMensualidad;
    }
}
