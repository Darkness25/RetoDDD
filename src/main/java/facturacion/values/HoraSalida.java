package facturacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HoraSalida implements ValueObject<String> {

    private final String value;

    public HoraSalida(String value) {

        if(value.length()<2){
            throw new IllegalArgumentException("La Hora de salida no puede ser menor a 2 caracteres");
        }

        if(value.length()>8){
            throw new IllegalArgumentException("La Hora de salida no puede ser mayor a 8 caracteres");
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
