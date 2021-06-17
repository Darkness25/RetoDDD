package parking.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombrePropietario implements ValueObject<String> {

    private final String value;

    public NombrePropietario(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if(this.value.length() <= 5){
            throw new IllegalArgumentException("EL nombre debe tener minimo 5 caracteres");
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
        NombrePropietario that = (NombrePropietario) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }



}
