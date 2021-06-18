package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import parking.Parking;
import parking.commands.CrearParking;

public class CrearParkingUseCase extends UseCase<RequestCommand<CrearParking>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearParking> crearParkingRequestCommand) {
        var command = crearParkingRequestCommand.getCommand();
        var parking = new Parking(command.getEntityId(), gett);
    }
}
