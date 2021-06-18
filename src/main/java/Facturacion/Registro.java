package co.com.sofka.blog.domain.usuario;

import co.com.sofka.blog.domain.usuario.values.RegistroId;
import co.com.sofka.blog.domain.usuario.values.Precio;
import co.com.sofka.blog.domain.usuario.values.TipoMensualidad;
import co.com.sofka.domain.generic.Entity;

public class Registro extends Entity<RegistroId>{

    protected Precio precio;
    protected TipoMensualidad tipoMensualidad;

    public Registro(RegistroId entityId, Precio precio, TipoMensualidad tipoMensualidad) {
        super(entityId);
        this.precio = precio;
        this.tipoMensualidad = tipoMensualidad;
    }

    public void aumentarRango(TipoMensualidad tipoMensualidad){
        this.tipoMensualidad = tipoMensualidad;
    }

    public void disminuirRango(TipoMensualidad tipoMensualidad){
        this.tipoMensualidad = tipoMensualidad;
    }

    public void modificarPrecio(Precio precio){
        this.precio = precio;
    }

    public Precio precio(){
        return this.precio;
    }

    public TipoMensualidad rango(){
        return this.tipoMensualidad;
    }
}
