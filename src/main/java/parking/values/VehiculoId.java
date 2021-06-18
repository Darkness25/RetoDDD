package parking.values;

import co.com.sofka.domain.generic.Identity;


public class VehiculoId extends Identity {

    public VehiculoId(){

    }

    private VehiculoId(String id){ super(id);
    }

    public static VehiculoId of(String id){return new VehiculoId(id);
    }



}
