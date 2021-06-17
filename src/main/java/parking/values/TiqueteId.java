package parking.values;

import co.com.sofka.domain.generic.Identity;

public class TiqueteId extends Identity {

    public TiqueteId(){

    }

    private TiqueteId(String id){ super(id);
    }

    public static TiqueteId of(String id){return new TiqueteId(id);
    }

}
