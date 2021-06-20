package estacionamiento;

import co.com.sofka.domain.generic.EventChange;
import estacionamiento.events.*;

import java.util.ArrayList;

public class EstacionamientoChange extends EventChange {
    public EstacionamientoChange(Estacionamiento estacionamiento) {

        apply((EstacionamientoCreado event)->{
            estacionamiento.parkingId = event.getParkingId();
            estacionamiento.cliente = new Cliente(event.getClienteId(), event.getCorreoCliente(), event.getNombreCliente());
            estacionamiento.vehiculos = new ArrayList<>();
            estacionamiento.tiquetes = new ArrayList<>();
        });

        apply((HoraDeIngresoDeTiqueteActualizada event)->{
            estacionamiento.tiquetePorId(event.getTiqueteId()).modificarHoraDeIngreso(event.getHoraIngreso());
        });

        apply((NombreClienteDeVehiculoActualizado event)->{
            estacionamiento.vehculoPorId(event.getVehiculoId()).modificarNombre(event.getNombreCliente());
        });

        apply((CorreoClienteDeClienteActualizado event)->{
            estacionamiento.cliente.modificarCorreo(event.getCorreoCliente());
        });

        apply((NombreClienteDeClienteActualizado event)->{
            estacionamiento.cliente.modificarNombre(event.getNombreCliente());
        });

        apply((TiqueteAgregado event)->{
            estacionamiento.tiquetes.add(new Tiquete(
                    event.getTiqueteId(),
                    event.getTipoVehiculo(),
                    event.getHoraIngreso()
            ));
        });

        apply((VehiculoAgregado event)->{
            estacionamiento.vehiculos.add(new Vehiculo(
                    event.getVehiculoId(),
                    event.getNombreCliente(),
                    event.getTipoVehiculo()
            ));
        });
    }
}
