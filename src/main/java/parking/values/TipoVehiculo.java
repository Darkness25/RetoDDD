package parking.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoVehiculo implements ValueObject {

    private final String value;

    public TipoVehiculo(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }
        if(this.value.length() <= 4){
            throw new IllegalArgumentException("EL campo debe tener minimo 4 caracteres");
        }
        if(!value.matches("^[a-zA-Z\\s]*$")){
            throw new IllegalArgumentException("EL campo no cumple con el formato requerido solo se permiten letras");
        }
    }


    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoVehiculo that = (TipoVehiculo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
