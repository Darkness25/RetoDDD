package estacionamiento;

import co.com.sofka.domain.generic.Entity;
import estacionamiento.values.ClienteId;
import estacionamiento.values.CorreoCliente;
import estacionamiento.values.NombreCliente;
import facturacion.values.Nombre;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {

    protected CorreoCliente correoCliente;
    protected NombreCliente nombreCliente;
    ;

    public Cliente(ClienteId entityId, CorreoCliente correoCliente, NombreCliente nombreCliente) {
        super(entityId);
        this.correoCliente = correoCliente;
        this.nombreCliente = nombreCliente;

    }

    public void modificarCorreo(CorreoCliente correoCliente){
        this.correoCliente = Objects.requireNonNull(correoCliente);
    }

    public void modificarNombre(NombreCliente nombreCliente){
        this.nombreCliente = Objects.requireNonNull(nombreCliente);
    }

    public CorreoCliente getCorreoCliente() {
        return correoCliente;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}
