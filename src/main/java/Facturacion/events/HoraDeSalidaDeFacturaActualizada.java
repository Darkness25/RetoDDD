package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.HoraSalida;
import co.com.sofka.domain.generic.DomainEvent;

public class HoraDeSalidaDeFacturaActualizada extends DomainEvent {

    private final HoraSalida horaSalida;

    public HoraDeSalidaDeFacturaActualizada(HoraSalida horaSalida) {
        super("blog.usuario.claveusuariodecuentamodificado");
        this.horaSalida = horaSalida;
    }

    public HoraSalida getClaveUsuario() {
        return horaSalida;
    }
}
