package usecase.estacionamiento;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import estacionamiento.commands.CrearEstacionamiento;
import estacionamiento.events.EstacionamientoCreado;
import estacionamiento.values.CorreoCliente;
import estacionamiento.values.EstacionamientoId;
import estacionamiento.values.NombreCliente;
import facturacion.values.ParkingId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearEstacionamientoUseCaseTest {

    private CrearEstacionamientoUseCase crearEstacionamientoUseCase;

    @BeforeEach
    public void setup() {
        crearEstacionamientoUseCase = new CrearEstacionamientoUseCase();
    }

    @Test
    void crearEstacionamientoHappyPath() {
        //arrange
        var command = new CrearEstacionamiento(
                EstacionamientoId.of("xx"),
                ParkingId.of("xx"),
                new NombreCliente("Jesus Lara"),
                new CorreoCliente("jlara@hotmail.com")
        );
        //act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx-xxx")
                .syncExecutor(
                        crearEstacionamientoUseCase,
                        new RequestCommand<>(command)
                ).orElseThrow();
        var events = (EstacionamientoCreado) response.getDomainEvents().get(0);
        //assert
        Assertions.assertEquals("jlara@hotmail.com", events.getCorreoCliente().value());
        Assertions.assertEquals("Jesus Lara", events.getNombreCliente().value());
        Assertions.assertEquals("xx", events.getParkingId().value());
    }

}