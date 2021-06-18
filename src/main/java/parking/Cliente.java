package parking;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import parking.values.ClienteId;
import parking.values.CorreoCliente;
import parking.values.NombreCliente;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {
    private NombreCliente nombreCliente;
    private CorreoCliente correoCliente;

    public Cliente(ClienteId entityId, NombreCliente nombreCliente, CorreoCliente correoCliente) {
        super(entityId);
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
    }

    public void ActualizarNombreCliente(NombreCliente nombreCliente){
        this.nombreCliente = Objects.requireNonNull(nombreCliente);
    }

    public void ActualizarCorreoCliente(CorreoCliente correoCliente){
        this.correoCliente = Objects.requireNonNull(correoCliente);
    }

    public NombreCliente NombreCliente() {
        return nombreCliente;
    }

    public CorreoCliente CorreoCliente() {
        return correoCliente;
    }
}
