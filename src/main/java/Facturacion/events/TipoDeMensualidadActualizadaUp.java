package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.TipoMensualidad;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeMensualidadActualizadaUp extends DomainEvent {

    private final TipoMensualidad tipoMensualidad;

    public TipoDeMensualidadActualizadaUp(TipoMensualidad tipoMensualidad) {
        super("blog.usuario.rengodesuscripcionaumentado");
        this.tipoMensualidad = tipoMensualidad;
    }

    public TipoMensualidad getRango() {
        return tipoMensualidad;
    }
}
