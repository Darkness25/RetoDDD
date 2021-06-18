package co.com.sofka.blog.domain.usuario;

import co.com.sofka.blog.domain.usuario.events.*;
import co.com.sofka.domain.generic.EventChange;

public class FacturacionChange extends EventChange {
    public FacturacionChange(Facturacion facturacion) {

        apply((FacturacionGenerada event)->{
            facturacion.registro = event.getSuscripcion();
            facturacion.empleado = event.getPersona();
            facturacion.factura = event.getCuenta();
        });

        apply((HoraDeSalidaDeFacturaActualizada event)->{
            facturacion.factura.modificarClaveUsuario(event.getClaveUsuario());
        });

        apply((NombreDeEmpleadoActualizado event)->{
            facturacion.empleado.modificarNombre(event.getNombre());
        });

        apply((TelefonoDeEmpleadoActualizado event)->{
            facturacion.empleado.modificarTelefono(event.getTelefono());
        });

        apply((TipoDeMensualidadActualizadaUp event)->{
            facturacion.registro.aumentarRango(event.getRango());
        });

        apply((TipoDeMensualidadActualizadaDown event)->{
            facturacion.registro.disminuirRango(event.getRango());
        });

        apply((PrecioDeRegistroActualizado event)->{
            facturacion.registro.modificarPrecio(event.getPrecio());
        });

    }
}
