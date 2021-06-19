package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarDownTipoMensualidadDeRegistro;

public class ActualizarDownTipoMensualidadDeRegistroUseCase extends UseCase<RequestCommand<ActualizarDownTipoMensualidadDeRegistro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDownTipoMensualidadDeRegistro> disminuirMensualidadRequestCommand) {
        var command = disminuirMensualidadRequestCommand.getCommand();
        var usuario = Facturacion.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.disminuirRangoDeSuscripcion(command.getRango());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
