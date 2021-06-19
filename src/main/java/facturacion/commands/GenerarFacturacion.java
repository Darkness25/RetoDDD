package facturacion.commands;

import co.com.sofka.domain.generic.Command;
import facturacion.Empleado;
import facturacion.Factura;
import facturacion.Registro;
import facturacion.values.ParkingId;

public class GenerarFacturacion implements Command {

    private final ParkingId parkingId;
    private final Registro registro;
    private final Empleado empleado;
    private final Factura factura;

    public GenerarFacturacion(ParkingId parkingId, Registro registro, Empleado empleado, Factura factura) {
        this.parkingId = parkingId;
        this.registro = registro;
        this.empleado = empleado;
        this.factura = factura;
    }

    public ParkingId getIdUsuario() {
        return parkingId;
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
