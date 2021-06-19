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

class ActualizarNombreDeEmpleadoUseCaseTest {

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
    void modificarNombreDePersonaHappyPath() {
        //arrange
        var command = new ActualizarNombreDeEmpleado(
                ParkingId.of("xxx-xxx"),
                new Nombre("Juan Sebastian")
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
        Assertions.assertEquals("Juan Sebastian", evento.getNombre().value());
        Assertions.assertEquals("blog.usuario.nombredepersonamodificado", evento.type);
    }

    private List<DomainEvent> events() {
        return List.of(new FacturacionGenerada(
                new Registro(new RegistroId("xxx-xx1"),
                        new Precio("50000"),
                        new TipoMensualidad(1)),
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