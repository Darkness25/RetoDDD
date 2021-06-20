package usecase.facturacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import facturacion.Empleado;
import facturacion.Factura;
import facturacion.Registro;
import facturacion.commands.ActualizarUpTipoMensualidadDeRegistro;
import facturacion.events.FacturacionGenerada;
import facturacion.events.TipoDeMensualidadActualizadaUp;
import facturacion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ActualizarUpTipoMensualidadDeRegistroUseCaseTest {

    private ActualizarUpTipoMensualidadDeRegistroUseCase actualizarUpTipoMensualidadDeRegistroUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarUpTipoMensualidadDeRegistroUseCase = new ActualizarUpTipoMensualidadDeRegistroUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarUpTipoMensualidadDeRegistroUseCase.addRepository(repository);
    }

    @Test
    void actualizarUpTipoMensualidadDeRegistroHappyPath() {
        //arrange
        var command = new ActualizarUpTipoMensualidadDeRegistro(
                ParkingId.of("xxx-xxx"),
                new TipoMensualidad(2)
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //act

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        actualizarUpTipoMensualidadDeRegistroUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (TipoDeMensualidadActualizadaUp) response.getDomainEvents().get(0);

        //assert

        Assertions.assertEquals(2, evento.getTipoMensualidad().value());
    }



    private List<DomainEvent> events() {
        return List.of(new FacturacionGenerada(
                new Registro(new RegistroId("xxx-xx1"),
                        new Precio("50000"),
                        new TipoMensualidad(2)),
                new Empleado(new EmpleadoId("xxx-xx2"),
                        new FechaNacimiento(new Date(2021, 2, 8)),
                        new Nombre("Jesus Lara"),
                        new Correo("abc123@gmail.com"),
                        new Telefono("3207317601")),
                new Factura(new FacturaId("xxx-xx3"),
                        new HoraSalida("10"),
                        new ValorTotal("100000"))
        ));
    }

}