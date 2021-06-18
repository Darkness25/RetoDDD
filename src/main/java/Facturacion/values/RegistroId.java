package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.blog.domain.publicacion.values.IdPublicacion;
import co.com.sofka.domain.generic.Identity;

public class RegistroId extends Identity {

    public RegistroId(String uuid) {
        super(uuid);
    }

    public RegistroId() {
    }

    public static IdPublicacion of(String id){
        return new IdPublicacion(id);
    }
}
