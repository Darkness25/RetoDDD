package co.com.sofka.blog.domain.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class ParkingId extends Identity {
    public ParkingId(String uuid) {
        super(uuid);
    }

    public ParkingId() {
    }

    public static ParkingId of(String id){
        return new ParkingId(id);
    }
}
