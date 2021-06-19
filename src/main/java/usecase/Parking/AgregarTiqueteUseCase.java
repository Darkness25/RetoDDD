package usecase.Parking;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import parking.Parking;
import parking.commands.AgregarTiquete;
import parking.commands.CrearParking;

public class AgregarTiqueteUseCase extends UseCase<RequestCommand<AgregarTiquete>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTiquete> agregarTiqueteRequestCommand) {

        var command = agregarTiqueteRequestCommand.getCommand();
        var parking = Parking.from(command.getParkingId(), retrieveEvents(command.getParkingId().value()));
        parking.AgregarTiquete(command.getParkingId(), command.getEntityId(),command.getHoraIngreso(), command.getCeldaAsignada());
        emit().onResponse(new ResponseEvents(parking.getUncommittedChanges()));

    }
}
