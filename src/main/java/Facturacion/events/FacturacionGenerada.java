package co.com.sofka.blog.domain.usuario.events;

import co.com.sofka.blog.domain.usuario.Factura;
import co.com.sofka.blog.domain.usuario.Empleado;
import co.com.sofka.blog.domain.usuario.Registro;
import co.com.sofka.domain.generic.DomainEvent;

public class FacturacionGenerada extends DomainEvent {


    private final Registro registro;
    private final Empleado empleado;
    private final Factura factura;

    public FacturacionGenerada(Registro registro, Empleado empleado, Factura factura) {
        super("blog.usuario.usuariocreado");
        this.registro = registro;
        this.empleado = empleado;
        this.factura = factura;
    }

    public Registro getSuscripcion() {
        return registro;
    }

    public Empleado getPersona() {
        return empleado;
    }

    public Factura getCuenta() {
        return factura;
    }
}
