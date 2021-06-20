package usecase.notificacion;


import facturacion.values.Correo;

public interface SenderEmailService {
    void sendEmail(Correo email, String tiquete);
}
