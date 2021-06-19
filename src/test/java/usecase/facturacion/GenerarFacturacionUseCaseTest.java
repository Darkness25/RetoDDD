package usecase.facturacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import facturacion.Empleado;
import facturacion.Factura;
import facturacion.Registro;
import facturacion.commands.GenerarFacturacion;
import facturacion.events.FacturacionGenerada;
import facturacion.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;


class GenerarFacturacionUseCaseTest {

    private GenerarFacturacionUseCase generarFacturacionUseCase;

    @BeforeEach
    public void setup() {
        generarFacturacionUseCase = new GenerarFacturacionUseCase();
    }

    @Test
    void generarFacturacionHappyPath() {
        //arrange
        var command = new GenerarFacturacion(
                ParkingId.of("xxx-xxx"),
                new Registro(new RegistroId("xxx-xx1"),
                        new Precio("50000"),
                        new TipoMensualidad(1)),
                new Empleado(new EmpleadoId("xxx-xx2"),
                        new FechaNacimiento(new Date(2021, 2, 8)),
                        new Nombre("Jesus Lara"),
                        new Correo("abc123@gmail.com"),
                        new Telefono("3207317601")),
                new Factura(new FacturaId("xxx-xx3"),
                        new HoraSalida("10"),
                        new ValorTotal("100000"))
        );

        //act
        var response = UseCaseHandler.getInstance().
                syncExecutor(generarFacturacionUseCase, new RequestCommand<>(command)).orElseThrow();

        var events = response.getDomainEvents();

        //asserts
        FacturacionGenerada facturacionGenerada = (FacturacionGenerada) events.get(0);

        Assertions.assertEquals("Jesus Lara", facturacionGenerada.getPersona().nombre().value());
        Assertions.assertEquals("abc123@gmail.com", facturacionGenerada.getPersona().correo().value());
        Assertions.assertEquals("10", facturacionGenerada.getCuenta().claveUsuario().value());
        Assertions.assertEquals("100000", facturacionGenerada.getCuenta().nombreUsuario().value());
        Assertions.assertEquals(1, facturacionGenerada.getSuscripcion().rango().value());
    }

}