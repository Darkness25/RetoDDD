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
        var facturacion = Facturacion.from(command.getParkingId(), retrieveEvents(command.getParkingId().value()));

        facturacion.modificarHoraSalidaDefactura(command.getHoraSalida());
        emit().onResponse(new ResponseEvents(facturacion.getUncommittedChanges()));
    }

}
