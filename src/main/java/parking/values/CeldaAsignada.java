package parking.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CeldaAsignada implements ValueObject<String> {

    private final String value;

    public CeldaAsignada(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }
        if(this.value.length() <= 2){
            throw new IllegalArgumentException("EL campo debe tener minimo 2 caracteres");
        }
        if(this.value.length() > 3){
            throw new IllegalArgumentException("EL campo no puede tener mas de 3 caracteres");
        }
        if(!value.matches("[A-Za-z0-9]")){
            throw new IllegalArgumentException("El campo solo puede contener numeros y letras");

        }

    }


    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CeldaAsignada that = (CeldaAsignada) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
