package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeEmpleadoActualizado extends DomainEvent {

    private final Nombre nombre;

    public NombreDeEmpleadoActualizado(Nombre nombre) {
        super("blog.usuario.nombredepersonamodificado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
