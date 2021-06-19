package usecase.estacionamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.commands.AgregarTiquete;
import estacionamiento.events.EstacionamientoCreado;
import estacionamiento.events.TiqueteAgregado;
import estacionamiento.values.*;
import facturacion.values.ParkingId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AgregarTiqueteUseCaseTest {

    private AgregarTiqueteUseCase agregarTiqueteUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        agregarTiqueteUseCase = new AgregarTiqueteUseCase();
        repository = mock(DomainEventRepository.class);
        agregarTiqueteUseCase.addRepository(repository);
    }

    @Test
    void agregarTiqueteHappyPath() {
        //
        var command = new AgregarTiquete(
                EstacionamientoId.of("xxx"),
                TiqueteId.of("xx"),
                new TipoVehiculo(
                        ParkingId.of("1"),
                        "Motocicleta"
                ),
                new HoraIngreso(3)
        );

        when(repository.getEventsBy(any())).thenReturn(events());
        //ACT
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        agregarTiqueteUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (TiqueteAgregado) response.getDomainEvents().get(0);

        //ASSERT
        Assertions.assertEquals(3, evento.getHoraIngreso().value());
        Assertions.assertEquals("xx", evento.getTiqueteId().value());
        Assertions.assertEquals("1", evento.getTipoVehiculo().value().parkingId().value());
        Assertions.assertEquals("Motocicleta", evento.getTipoVehiculo().value().nombre());
    }

    private List<DomainEvent> events() {
        return List.of(new EstacionamientoCreado(
                ParkingId.of("xx"),
                ClienteId.of("xxx"),
                new NombreCliente("Jesus Lara"),
                new CorreoCliente("jlara@hotmail.com")
        ));
    }

}