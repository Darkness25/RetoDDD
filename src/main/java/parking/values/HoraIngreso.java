package parking.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class HoraIngreso implements ValueObject<String> {


    private final String value;

    public HoraIngreso(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }
        if(!value.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")){
            throw new IllegalArgumentException("EL campo no cumple con el formato requerido");
        }

    }


    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoraIngreso that = (HoraIngreso) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }



}
