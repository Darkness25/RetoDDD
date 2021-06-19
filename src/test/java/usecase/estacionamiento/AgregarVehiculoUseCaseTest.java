package usecase.estacionamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import estacionamiento.commands.AgregarVehiculo;
import estacionamiento.events.EstacionamientoCreado;
import estacionamiento.events.VehiculoAgregado;
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

class AgregarVehiculoUseCaseTest {
    private AgregarVehiculoUseCase agregarVehiculoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        agregarVehiculoUseCase = new AgregarVehiculoUseCase();
        repository = mock(DomainEventRepository.class);
        agregarVehiculoUseCase.addRepository(repository);
    }

    @Test
    void agregarVehiculoHappyPath() {
        var command = new AgregarVehiculo(
                EstacionamientoId.of("xxx"),
                VehiculoId.of("xx-xx"),
                new NombreCliente("Jesus Lara"),
                new TipoVehiculo(
                        ParkingId.of("1"),
                        "Motocicleta"
                ));
        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        agregarVehiculoUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (VehiculoAgregado) response.getDomainEvents().get(0);

        Assertions.assertEquals("Jesus Lara", evento.getNombreCliente().value());
        Assertions.assertEquals("xx-xx", evento.getVehiculoId().value());
        Assertions.assertEquals("1", evento.getTipoVehiculo().value().parkingId().value());
        Assertions.assertEquals("Motocicleta", evento.getTipoVehiculo().value().nombre());

    }

    private List<DomainEvent> events() {
        return List.of(new EstacionamientoCreado(
                ParkingId.of("1"),
                ClienteId.of("2"),
                new NombreCliente("Martin perez"),
                new CorreoCliente("martinperez@hotmail.com")
        ));
    }
}