package facturacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import facturacion.values.Nombre;

public class NombreDeEmpleadoActualizado extends DomainEvent {

    private final Nombre nombre;

    public NombreDeEmpleadoActualizado(Nombre nombre) {
        super("sofka.facturacion.nombredeempleadoactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
