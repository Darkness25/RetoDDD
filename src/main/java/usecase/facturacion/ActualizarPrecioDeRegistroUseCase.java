package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarPrecioDeRegistro;

public class ActualizarPrecioDeRegistroUseCase extends UseCase<RequestCommand<ActualizarPrecioDeRegistro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarPrecioDeRegistro> modificarPrecioDeSuscripcionRequestCommand) {
        var command = modificarPrecioDeSuscripcionRequestCommand.getCommand();
        var usuario = Facturacion.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.modificarPrecioDeSuscripcion(command.getPrecio());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
