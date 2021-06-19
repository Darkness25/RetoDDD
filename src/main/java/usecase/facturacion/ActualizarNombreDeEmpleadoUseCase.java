package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarNombreDeEmpleado;

public class ActualizarNombreDeEmpleadoUseCase extends UseCase<RequestCommand<ActualizarNombreDeEmpleado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDeEmpleado> modificarNombreDePersonaRequestCommand) {
        var command = modificarNombreDePersonaRequestCommand.getCommand();
        var usuario = Facturacion.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.modificarNombreDePersona(command.getNombre());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
