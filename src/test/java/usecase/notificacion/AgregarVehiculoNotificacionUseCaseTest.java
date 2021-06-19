package usecase.notificacion;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import estacionamiento.events.VehiculoAgregado;
import estacionamiento.values.NombreCliente;
import estacionamiento.values.TipoVehiculo;
import estacionamiento.values.VehiculoId;
import facturacion.values.Correo;
import facturacion.values.ParkingId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AgregarVehiculoNotificacionUseCaseTest {

    private AgregarVehiculoNotificacionUseCase agregarVehiculoNotificacionUseCase;

    private VehiculoService vehiculoService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup() {
        agregarVehiculoNotificacionUseCase = new AgregarVehiculoNotificacionUseCase();
        vehiculoService = mock(VehiculoService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder bilder = new ServiceBuilder();
        bilder.addService(vehiculoService);
        bilder.addService(senderEmailService);

        agregarVehiculoNotificacionUseCase.addServiceBuilder(bilder);
    }

    @Test
    void agregarVehiculoNotificacionHappyPath() {
        var event = new VehiculoAgregado(
                VehiculoId.of("xx"),
                new NombreCliente("Jesus Lara"),
                new TipoVehiculo(
                        ParkingId.of("1"),
                        "Motocicleta"
                )
        );

        when(vehiculoService.getCorreoPorIdUsuario(any())).thenReturn(new Correo("jlara@gmail.com"));
        doNothing().when(senderEmailService).sendEmail(any(), anyString());

        var response = UseCaseHandler.getInstance()
                .syncExecutor(
                        agregarVehiculoNotificacionUseCase,
                        new TriggeredEvent<>(event)
                );

        verify(vehiculoService).getCorreoPorIdUsuario(any());
        verify(senderEmailService).sendEmail(any(), anyString());
    }

}