package parking;

import co.com.sofka.domain.generic.EventChange;
import parking.events.ClienteAgregado;
import parking.events.ParkingCreado;
import parking.events.TiqueteAgregado;
import parking.events.VehiculoAgregado;

public class ParkingChange extends EventChange {
    public ParkingChange(Parking parking){

        apply((ParkingCreado event) ->{
            parking.parkingId = event.getParkingId();
        });
        apply((TiqueteAgregado event) ->{
            parking.tiquetes.add(new Tiquete(
                    event.TiqueteId(),
                    event.HoraIngreso(),
                    event.CeldaAsignada()
            ));
        });

        apply((VehiculoAgregado event) -> {
            parking.vehiculos.add(new Vehiculo(
                    event.VehiculoId(),
                    event.NombrePropietario(),
                    event.TipoVehiculo()


            ));
        });

        apply((ClienteAgregado event) ->{
            parking.clientes.add(new Cliente(
                    event.EntityId(),
                    event.NombreCliente(),
                    event.CorreoCliente()

            ));
        });

    }
}
