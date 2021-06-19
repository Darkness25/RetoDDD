package usecase.facturacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import facturacion.Empleado;
import facturacion.Factura;
import facturacion.Registro;
import facturacion.commands.ActualizarPrecioDeRegistro;
import facturacion.events.FacturacionGenerada;
import facturacion.events.PrecioDeRegistroActualizado;
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

class ActualizarPrecioDeRegistroUseCaseTest {

    private ActualizarPrecioDeRegistroUseCase actualizarPrecioDeRegistroUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        actualizarPrecioDeRegistroUseCase = new ActualizarPrecioDeRegistroUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarPrecioDeRegistroUseCase.addRepository(repository);
    }

    @Test
    void modificarPrecioDeSuscripcionHappyPath() {
        //arrange
        var command = new ActualizarPrecioDeRegistro(
                ParkingId.of("xxx-xxx"),
                new Precio("100000")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxxx")
                .syncExecutor(
                        actualizarPrecioDeRegistroUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var evento = (PrecioDeRegistroActualizado) response.getDomainEvents().get(0);
        //assert
        Assertions.assertEquals("100000", evento.getPrecio().value());
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