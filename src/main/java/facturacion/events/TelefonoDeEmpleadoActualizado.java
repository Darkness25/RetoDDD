package facturacion.events;


import co.com.sofka.domain.generic.DomainEvent;
import facturacion.values.Telefono;

public class TelefonoDeEmpleadoActualizado extends DomainEvent {

    private final Telefono telefono;

    public TelefonoDeEmpleadoActualizado(Telefono telefono) {
        super("sofka.facturacion..telefonodeempleadoactualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
