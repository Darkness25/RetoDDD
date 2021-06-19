package facturacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorTotal implements ValueObject<String> {

    private final String value;

    public ValorTotal(String value) {

        if(value.length()<3){
            throw new IllegalArgumentException("El valor total no puede ser menor a 3 caracteres");
        }

        if(value.length()>10){
            throw new IllegalArgumentException("El valor total no puede ser mayor a 10 caracteres");
        }

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValorTotal that = (ValorTotal) o;
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
