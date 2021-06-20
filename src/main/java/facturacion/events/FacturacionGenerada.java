package facturacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import facturacion.Empleado;
import facturacion.Factura;
import facturacion.Registro;

public class FacturacionGenerada extends DomainEvent {


    private final Registro registro;
    private final Empleado empleado;
    private final Factura factura;

    public FacturacionGenerada(Registro registro, Empleado empleado, Factura factura) {
        super("sofka.facturacion.facturaciongenerada");
        this.registro = registro;
        this.empleado = empleado;
        this.factura = factura;
    }

    public Registro getRegistro() {
        return registro;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Factura getFactura() {
        return factura;
    }
}
