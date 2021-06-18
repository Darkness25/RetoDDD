package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.TipoMensualidad;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeMensualidadActualizadaDown extends DomainEvent {

    private final TipoMensualidad tipoMensualidad;

    public TipoDeMensualidadActualizadaDown(TipoMensualidad tipoMensualidad) {
        super("blog.usuario.rengodesuscripciondisminuido");
        this.tipoMensualidad = tipoMensualidad;
    }

    public TipoMensualidad getRango() {
        return tipoMensualidad;
    }
}
