package usecase.facturacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import facturacion.Empleado;
import facturacion.Factura;
import facturacion.Registro;
import facturacion.commands.ActualizarNombreDeEmpleado;
import facturacion.events.FacturacionGenerada;
import facturacion.events.NombreDeEmpleadoActualizado;
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

class ActualizarNombreClienteDeEmpleadoUseCaseTest {

    private ActualizarNombreDeEmpleadoUseCase actualizarNombreDeEmpleadoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarNombreDeEmpleadoUseCase = new ActualizarNombreDeEmpleadoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarNombreDeEmpleadoUseCase.addRepository(repository);
    }

    @Test
    void actualizarNombreDeEmpleadoHappyPath() {
        //arrange
        var command = new ActualizarNombreDeEmpleado(
                ParkingId.of("xxx-xxx"),
                new Nombre("Jesus Lara")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        //act

        var response = UseCaseHandler.getInstance().
                setIdentifyExecutor("xxx-xxx").syncExecutor(
                actualizarNombreDeEmpleadoUseCase,
                new RequestCommand<>(command)
        ).orElseThrow();

        var evento = (NombreDeEmpleadoActualizado) response.getDomainEvents().get(0);

        //assert
        Assertions.assertEquals("Jesus Lara", evento.getNombre().value());
        Assertions.assertEquals("sofka.facturacion.nombredeempleadoactualizado", evento.type);
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