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
    void crearUsuarioHappyPath() {
        //arrange
        var command = new GenerarFacturacion(
                ParkingId.of("xxx-xxx"),
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
        );

        //act
        var response = UseCaseHandler.getInstance().
                syncExecutor(generarFacturacionUseCase, new RequestCommand<>(command)).orElseThrow();

        var events = response.getDomainEvents();

        //asserts
        FacturacionGenerada facturacionGenerada = (FacturacionGenerada) events.get(0);

        Assertions.assertEquals("Sebastian cano grajales", facturacionGenerada.getPersona().nombre().value());
        Assertions.assertEquals("sebas99cano@gmail.com", facturacionGenerada.getPersona().correo().value());
        Assertions.assertEquals("clave123", facturacionGenerada.getCuenta().claveUsuario().value());
        Assertions.assertEquals("sebas99cano", facturacionGenerada.getCuenta().nombreUsuario().value());
        Assertions.assertEquals(1, facturacionGenerada.getSuscripcion().rango().value());
    }

}