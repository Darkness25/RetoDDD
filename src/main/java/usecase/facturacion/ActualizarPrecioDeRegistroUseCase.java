package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarPrecioDeRegistro;

public class ActualizarPrecioDeRegistroUseCase extends UseCase<RequestCommand<ActualizarPrecioDeRegistro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarPrecioDeRegistro> actualizarPrecioDeRegistroRequestCommand) {
        var command = actualizarPrecioDeRegistroRequestCommand.getCommand();
        var facturacion = Facturacion.from(command.getParkingId(), retrieveEvents(command.getParkingId().value()));

        facturacion.modificarPrecioDeRegistro(command.getPrecio());
        emit().onResponse(new ResponseEvents(facturacion.getUncommittedChanges()));
    }
}
