package usecase.estacionamiento;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import estacionamiento.Estacionamiento;
import estacionamiento.commands.CrearEstacionamiento;

public class CrearEstacionamientoUseCase extends UseCase<RequestCommand<CrearEstacionamiento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEstacionamiento> crearEstacionamientoRequestCommand) {
        var command = crearEstacionamientoRequestCommand.getCommand();
        var publicacion = new Estacionamiento(command.getEstacionamientoId(),command.getParkingId(),command.getNombreCliente(), command.getCorreoCliente());
        emit().onResponse(new ResponseEvents(publicacion.getUncommittedChanges()));
    }
}
