package facturacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import facturacion.values.TipoMensualidad;

public class TipoDeMensualidadActualizadaDown extends DomainEvent {

    private final TipoMensualidad tipoMensualidad;

    public TipoDeMensualidadActualizadaDown(TipoMensualidad tipoMensualidad) {
        super("sofka.facturacion.tipodemensualidadactualizadadown");
        this.tipoMensualidad = tipoMensualidad;
    }

    public TipoMensualidad getRango() {
        return tipoMensualidad;
    }
}
