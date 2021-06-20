package usecase.facturacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import facturacion.Facturacion;
import facturacion.commands.GenerarFacturacion;

public class GenerarFacturacionUseCase extends UseCase<RequestCommand<GenerarFacturacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarFacturacion> generarFacturacionRequestCommand) {
        var commnad = generarFacturacionRequestCommand.getCommand();
        var facturacion = new Facturacion(commnad.getParkingId(), commnad.getRegistro(), commnad.getEmpleado(), commnad.getFactura());
        emit().onResponse(new ResponseEvents(facturacion.getUncommittedChanges()));
    }
}
