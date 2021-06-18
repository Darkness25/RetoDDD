package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class PrecioDeRegistroActualizado extends DomainEvent {

    private final Precio precio;

    public PrecioDeRegistroActualizado(Precio precio) {
        super("blog.usuario.preciodesuscripcionmodificado");
        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }
}
