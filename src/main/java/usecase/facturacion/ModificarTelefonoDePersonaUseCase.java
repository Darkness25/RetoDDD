package usecase.facturacion;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarTelefonoDeEmpleado;

public class ModificarTelefonoDePersonaUseCase extends UseCase<RequestCommand<ActualizarTelefonoDeEmpleado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoDeEmpleado> modificarTelefonoDePersonaRequestCommand) {
        var command = modificarTelefonoDePersonaRequestCommand.getCommand();
        var usuario = Facturacion.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.modificarTelefonoDePersona(command.getTelefono());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
