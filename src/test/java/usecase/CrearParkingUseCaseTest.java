package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking.commands.CrearParking;
import parking.events.ParkingCreado;
import parking.values.ParkingId;
import parking.values.TiqueteId;
import usecase.Parking.CrearParkingUseCase;

class CrearParkingUseCaseTest {

    private CrearParkingUseCase crearParkingUseCase;

    @BeforeEach
    public void setup(){
        crearParkingUseCase = new CrearParkingUseCase();
    }

    @Test
    void crearParkingHappyPath(){
        //arrange
        var command = new CrearParking(

                ParkingId.of("xxx-xxx-xxx"),
                TiqueteId.of("xx-xx")
        );

        //act
       var response =  UseCaseHandler.getInstance().syncExecutor(crearParkingUseCase, new RequestCommand<>(command)).orElseThrow();
       var events = response.getDomainEvents();

       //asserts

        ParkingCreado parkingCreado = (ParkingCreado)events.get(0);
        //Assertions.assertEquals("12345", parkingCreado.getParkingId().value());


    }

}