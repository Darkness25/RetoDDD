package parking.commands;

import co.com.sofka.domain.generic.Command;
import parking.values.CeldaAsignada;
import parking.values.HoraIngreso;
import parking.values.ParkingId;
import parking.values.TiqueteId;

public class AgregarTiquete implements Command {


    private final ParkingId parkingId;
    private final TiqueteId entityId;
    private final HoraIngreso horaIngreso;
    private final CeldaAsignada celdaAsignada;


    public AgregarTiquete(ParkingId parkingId, TiqueteId entityId, HoraIngreso horaIngreso, CeldaAsignada celdaAsignada){
        this.parkingId = parkingId;


        this.entityId = entityId;
        this.horaIngreso = horaIngreso;
        this.celdaAsignada = celdaAsignada;
    }



    public TiqueteId getEntityId() {
        return entityId;
    }

    public HoraIngreso getHoraIngreso() {
        return horaIngreso;
    }

    public CeldaAsignada getCeldaAsignada() {
        return celdaAsignada;
    }

    public ParkingId getParkingId() {
        return parkingId;
    }
}
