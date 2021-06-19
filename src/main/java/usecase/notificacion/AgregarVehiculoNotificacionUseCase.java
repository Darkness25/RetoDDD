package usecase.notificacion;

;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import estacionamiento.events.VehiculoAgregado;

public class AgregarVehiculoNotificacionUseCase extends UseCase<TriggeredEvent<VehiculoAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<VehiculoAgregado> vehiculoAgregadoTriggeredEvent) {
        var event = vehiculoAgregadoTriggeredEvent.getDomainEvent();
        var vehiculoService = getService(VehiculoService.class).orElseThrow();
        var senderEmailService = getService(SenderEmailService.class).orElseThrow();

        var email = vehiculoService.getCorreoPorIdUsuario(event.getTipoVehiculo().value().parkingId());
        senderEmailService.sendEmail(email, "nuevo vehiculo");
    }
}
