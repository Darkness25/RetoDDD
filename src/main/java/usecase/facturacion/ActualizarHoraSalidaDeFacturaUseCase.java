package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarHoraSalidaDeFactura;

public class ActualizarHoraSalidaDeFacturaUseCase extends UseCase<RequestCommand<ActualizarHoraSalidaDeFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarHoraSalidaDeFactura> actualizarHoraSalidaRequestCommand) {
        var command = actualizarHoraSalidaRequestCommand.getCommand();
        var usuario = Facturacion.from(command.getIdUsuario(), retrieveEvents(command.getIdUsuario().value()));

        usuario.modificarClaveUsuarioDeCuenta(command.getClaveUsuario());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }

}
