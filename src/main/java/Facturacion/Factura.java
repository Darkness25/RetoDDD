package co.com.sofka.blog.domain.usuario;

import co.com.sofka.blog.domain.usuario.values.HoraSalida;
import co.com.sofka.blog.domain.usuario.values.FacturaId;
import co.com.sofka.blog.domain.usuario.values.NombreUsuario;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {

    protected HoraSalida horaSalida;
    protected NombreUsuario nombreUsuario;

    public Factura(FacturaId entityId, HoraSalida horaSalida, NombreUsuario nombreUsuario) {
        super(entityId);
        this.horaSalida = horaSalida;
        this.nombreUsuario = nombreUsuario;
    }

    public void modificarClaveUsuario(HoraSalida horaSalida){
        this.horaSalida = Objects.requireNonNull(horaSalida);
    }

    public HoraSalida claveUsuario(){
        return this.horaSalida;
    }

    public NombreUsuario nombreUsuario(){
        return this.nombreUsuario;
    }
}
