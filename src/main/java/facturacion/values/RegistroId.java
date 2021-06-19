package facturacion.values;


import co.com.sofka.domain.generic.Identity;

public class RegistroId extends Identity {

    public RegistroId(String uuid) {
        super(uuid);
    }

    public RegistroId() {
    }

    public static RegistroId of(String id){
        return new RegistroId(id);
    }
}
