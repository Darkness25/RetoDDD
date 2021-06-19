package usecase.Parking;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import parking.commands.AgregarTiquete;
import parking.events.TiqueteAgregado;
import parking.values.CeldaAsignada;
import parking.values.HoraIngreso;
import parking.values.ParkingId;
import parking.values.TiqueteId;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AgregarTiqueteUseCaseTest {
    private AgregarTiqueteUseCase agregarTiqueteUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup(){
        agregarTiqueteUseCase = new AgregarTiqueteUseCase();
        repository = mock(DomainEventRepository.class);
        agregarTiqueteUseCase.addRepository(repository);

    }

    @Test
    void AgregarTiqueteHappyPath(){
        var command = new AgregarTiquete(
                ParkingId.of("xx-xx"),

                TiqueteId.of("xx-xxxx"),
                new HoraIngreso("8:30"),
                new CeldaAsignada("C24")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xx-xx")
                .syncExecutor(
                        agregarTiqueteUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (TiqueteAgregado)response.getDomainEvents().get(0);

        Assertions.assertEquals("8:30", evento.HoraIngreso().value());
        Assertions.assertEquals("C24", evento.CeldaAsignada().value());


    }

    private List<DomainEvent> events() {
        return List.of(new TiqueteAgregado(
                ParkingId.of("xx-xx"),
                TiqueteId.of("xx-xxxx"),
                new HoraIngreso("8:30"),
                new CeldaAsignada("C24")
        ));
    }



}