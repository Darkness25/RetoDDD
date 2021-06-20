package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarUpTipoMensualidadDeRegistro;

public class ActualizarUpTipoMensualidadDeRegistroUseCase extends UseCase<RequestCommand<ActualizarUpTipoMensualidadDeRegistro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarUpTipoMensualidadDeRegistro> actualizarUpTipoMensualidadDeRegistroUseCaseRequestCommand) {
        var command = actualizarUpTipoMensualidadDeRegistroUseCaseRequestCommand.getCommand();
        var facturacion = Facturacion.from(command.getParkingId(), retrieveEvents(String.valueOf(command.getTipoMensualidad().value())));

        facturacion.aumentarTipoMensualidadDeRegistro(command.getTipoMensualidad());
        emit().onResponse(new ResponseEvents(facturacion.getUncommittedChanges()));
    }
}
