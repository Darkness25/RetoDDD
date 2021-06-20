package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.ActualizarNombreDeEmpleado;

public class ActualizarNombreDeEmpleadoUseCase extends UseCase<RequestCommand<ActualizarNombreDeEmpleado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDeEmpleado> actualizarNombreDeEmpleadoRequestCommand) {
        var command = actualizarNombreDeEmpleadoRequestCommand.getCommand();
        var facturacion = Facturacion.from(command.getParkingId(), retrieveEvents(command.getParkingId().value()));

        facturacion.modificarNombreDePersona(command.getNombre());
        emit().onResponse(new ResponseEvents(facturacion.getUncommittedChanges()));
    }
}
