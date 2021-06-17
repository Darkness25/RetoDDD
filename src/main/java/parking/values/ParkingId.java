package parking.values;


import co.com.sofka.domain.generic.Identity;

public class ParkingId extends Identity {

    public ParkingId(){

    }

    private ParkingId(String id){ super(id);
    }

    public static ParkingId of(String id){return new ParkingId(id);
    }
}
