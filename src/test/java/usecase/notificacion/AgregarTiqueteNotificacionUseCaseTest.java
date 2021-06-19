package usecase.notificacion;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import estacionamiento.events.TiqueteAgregado;
import estacionamiento.values.HoraIngreso;
import estacionamiento.values.TipoVehiculo;
import estacionamiento.values.TiqueteId;
import facturacion.values.Correo;
import facturacion.values.ParkingId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AgregarTiqueteNotificacionUseCaseTest {
    private AgregarTiqueteNotificacionUseCase agregarTiqueteNotificacionUseCase;

    private TiqueteService tiqueteService;
    private SenderEmailService senderEmailService;

    @BeforeEach
    public void setup() {
        agregarTiqueteNotificacionUseCase = new AgregarTiqueteNotificacionUseCase();
        tiqueteService = mock(TiqueteService.class);
        senderEmailService = mock(SenderEmailService.class);

        ServiceBuilder bilder = new ServiceBuilder();
        bilder.addService(tiqueteService);
        bilder.addService(senderEmailService);
        agregarTiqueteNotificacionUseCase.addServiceBuilder(bilder);
    }

    @Test
    void agregarTiqueteNotificacionHappyPath() {
        //arrange
        var event = new TiqueteAgregado(
                TiqueteId.of("xx"),
                new TipoVehiculo(
                        ParkingId.of("1"),
                        "Motocicleta"
                ),
                new HoraIngreso(3)
        );

        when(tiqueteService.getCorreoPorIdUsuario(any())).thenReturn(new Correo("jlara@gmail.com.co"));
        doNothing().when(senderEmailService).sendEmail(any(), anyString());

        var response = UseCaseHandler.getInstance()
                .syncExecutor(
                        agregarTiqueteNotificacionUseCase,
                        new TriggeredEvent<>(event)
                );

        //assert
        verify(tiqueteService).getCorreoPorIdUsuario(any());
        verify(senderEmailService).sendEmail(any(), anyString());

    }
}