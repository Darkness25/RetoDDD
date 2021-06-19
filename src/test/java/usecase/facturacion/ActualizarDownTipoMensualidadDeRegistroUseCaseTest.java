package usecase.facturacion;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import facturacion.Empleado;
import facturacion.Factura;
import facturacion.Registro;
import facturacion.commands.ActualizarDownTipoMensualidadDeRegistro;
import facturacion.events.FacturacionGenerada;
import facturacion.events.TipoDeMensualidadActualizadaDown;
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

class ActualizarDownTipoMensualidadDeRegistroUseCaseTest {

    private ActualizarDownTipoMensualidadDeRegistroUseCase actualizarDownTipoMensualidadDeRegistroUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarDownTipoMensualidadDeRegistroUseCase = new ActualizarDownTipoMensualidadDeRegistroUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarDownTipoMensualidadDeRegistroUseCase.addRepository(repository);
    }

    @Test
    void actualizarDownTipoMensualidadDeRegistroHappyPath() {
        //arrange
        var command = new ActualizarDownTipoMensualidadDeRegistro(
                ParkingId.of("xxx-xxx"),
                new TipoMensualidad(1)
        );

        when(repository.getEventsBy(any())).thenReturn(events());
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(
                        actualizarDownTipoMensualidadDeRegistroUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (TipoDeMensualidadActualizadaDown) response.getDomainEvents().get(0);

        //assert
        Assertions.assertEquals(1, evento.getRango().value());
    }

    @Test
    void actualizarDownTipoMensualidadDeRegistroSadPath() {
        var response = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var command = new ActualizarDownTipoMensualidadDeRegistro(
                    ParkingId.of("xxx-xxx"),
                    new TipoMensualidad(-1)
            );
            when(repository.getEventsBy(any())).thenReturn(events());
        });

        //Assert
        Assertions.assertEquals("El tipoMensualidad no es valido, debe ser un valor entre 1 y 3", response.getMessage());

    }

    private List<DomainEvent> events() {
        return List.of(new FacturacionGenerada(
                new Registro(new RegistroId("xxx-xx1"),
                        new Precio("50000"),
                        new TipoMensualidad(2)),
                new Empleado(new EmpleadoId("xxx-xx2"),
                        new FechaNacimiento(new Date(100, 5, 3)),
                        new Nombre("Sebastian cano grajales"),
                        new Correo("sebas99cano@gmail.com"),
                        new Telefono("3058935891")),
                new Factura(new FacturaId("xxx-xx3"),
                        new HoraSalida("clave123"),
                        new NombreUsuario("sebas99cano"))
        ));
    }

}