package usecase.notificacion;


import estacionamiento.values.CorreoCliente;

import facturacion.values.Correo;
import facturacion.values.ParkingId;

public interface TiqueteService {
    Correo getCorreoPorIdUsuario(ParkingId parkingId);
}
