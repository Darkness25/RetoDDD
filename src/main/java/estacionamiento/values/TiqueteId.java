package estacionamiento.values;

import co.com.sofka.domain.generic.Identity;

public class TiqueteId extends Identity {
    public TiqueteId(String uuid) {
        super(uuid);
    }

    public TiqueteId() {
    }
    public static TiqueteId of(String id){
        return new TiqueteId(id);
    }
}
