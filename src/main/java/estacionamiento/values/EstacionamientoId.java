package estacionamiento.values;

import co.com.sofka.domain.generic.Identity;

public class EstacionamientoId extends Identity {
    public EstacionamientoId(String uuid) {
        super(uuid);
    }

    public EstacionamientoId() {
    }

    public static EstacionamientoId of(String id){return  new EstacionamientoId(id);}
}
