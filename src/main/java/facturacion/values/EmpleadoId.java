package facturacion.values;

import co.com.sofka.domain.generic.Identity;

public class EmpleadoId extends Identity {
    public EmpleadoId(String uuid) {
        super(uuid);
    }

    public EmpleadoId() {
    }

    public static EmpleadoId of(String id){
        return new EmpleadoId(id);
    }
}
