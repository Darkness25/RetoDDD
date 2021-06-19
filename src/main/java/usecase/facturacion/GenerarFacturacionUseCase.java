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
        var usuario = new Facturacion(commnad.getIdUsuario(), commnad.getSuscripcion(), commnad.getPersona(), commnad.getCuenta());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
