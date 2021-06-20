package facturacion;

import co.com.sofka.domain.generic.EventChange;
import facturacion.events.*;

public class FacturacionChange extends EventChange {
    public FacturacionChange(Facturacion facturacion) {

        apply((FacturacionGenerada event)->{
            facturacion.registro = event.getRegistro();
            facturacion.empleado = event.getEmpleado();
            facturacion.factura = event.getFactura();
        });

        apply((HoraDeSalidaDeFacturaActualizada event)->{
            facturacion.factura.modificarHoraSalidaDefactura(event.getHoraSalida());
        });

        apply((NombreDeEmpleadoActualizado event)->{
            facturacion.empleado.modificarNombre(event.getNombre());
        });

        apply((TelefonoDeEmpleadoActualizado event)->{
            facturacion.empleado.modificarTelefono(event.getTelefono());
        });

        apply((TipoDeMensualidadActualizadaUp event)->{
            facturacion.registro.aumentarTipoMensualidad(event.getTipoMensualidad());
        });

        apply((TipoDeMensualidadActualizadaDown event)->{
            facturacion.registro.disminuirTipoMensualidad(event.getTipoMensualidad());
        });

        apply((PrecioDeRegistroActualizado event)->{
            facturacion.registro.modificarPrecio(event.getPrecio());
        });

    }
}
