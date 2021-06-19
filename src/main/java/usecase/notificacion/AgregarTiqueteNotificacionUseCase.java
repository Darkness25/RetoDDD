package usecase.notificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import estacionamiento.events.TiqueteAgregado;

public class AgregarTiqueteNotificacionUseCase extends UseCase<TriggeredEvent<TiqueteAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<TiqueteAgregado> tiqueteAgregadoTriggeredEvent) {
        var event = tiqueteAgregadoTriggeredEvent.getDomainEvent();
        var tiqueteService = getService(TiqueteService.class).orElseThrow();//opcional porque puede que el servicio no este implementado
        var senderEmailService = getService(SenderEmailService.class).orElseThrow();

        var email = tiqueteService.getCorreoPorIdUsuario(event.getTipoVehiculo().value().parkingId());
        senderEmailService.sendEmail(email, "tiquete agregada");
    }
}

