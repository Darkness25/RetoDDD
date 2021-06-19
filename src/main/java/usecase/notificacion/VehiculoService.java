package usecase.notificacion;


import facturacion.values.Correo;
import facturacion.values.ParkingId;

public interface VehiculoService {
    Correo getCorreoPorIdUsuario(ParkingId parkingId);
}
