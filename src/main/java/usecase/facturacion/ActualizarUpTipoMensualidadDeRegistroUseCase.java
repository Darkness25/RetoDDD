package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarUpTipoMensualidadDeRegistro;

public class ActualizarUpTipoMensualidadDeRegistroUseCase extends UseCase<RequestCommand<ActualizarUpTipoMensualidadDeRegistro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarUpTipoMensualidadDeRegistro> aumentarRangoDeSuscripcionUseCaseRequestCommand) {
        var command = aumentarRangoDeSuscripcionUseCaseRequestCommand.getCommand();
        var usuario = Facturacion.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.aumentarRangoDeSuscripcion(command.getRango());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
