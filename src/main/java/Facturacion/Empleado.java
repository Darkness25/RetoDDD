package facturacion;


import co.com.sofka.domain.generic.Entity;
import facturacion.values.*;

import java.util.Objects;

public class Empleado extends Entity<EmpleadoId> {

    protected FechaNacimiento fechaNacimiento;
    protected Nombre nombre;
    protected Correo correo;
    protected Telefono telefono;

    public Empleado(EmpleadoId entityId, FechaNacimiento fechaNacimiento, Nombre nombre, Correo correo, Telefono telefono) {
        super(entityId);
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public void modificarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void modificarTelefono(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }

    public FechaNacimiento fechaNacimiento(){
        return this.fechaNacimiento;
    }

    public Nombre nombre(){
        return this.nombre;
    }

    public Correo correo(){
        return this.correo;
    }

    public Telefono telefono(){
        return this.telefono;
    }
}
