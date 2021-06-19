package facturacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HoraSalida implements ValueObject<String> {

    private final String value;

    public HoraSalida(String value) {

        if(value.length()<8){
            throw new IllegalArgumentException("La clave de usuario no puede ser menor a 8 caracteres");
        }

        if(value.length()>20){
            throw new IllegalArgumentException("La clave de usuario no puede ser mayor a 20 caracteres");
        }

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoraSalida that = (HoraSalida) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}