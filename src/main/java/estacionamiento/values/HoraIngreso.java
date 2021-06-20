package estacionamiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HoraIngreso implements ValueObject<Integer> {
    private final Integer value;

    public HoraIngreso(Integer value) {

        if(value <1){
            throw new IllegalArgumentException("La Hora no es valida, debe ser un valor mayor a cero");
        }
        if(value >12){
            throw new IllegalArgumentException("La Hora no es valido");
        }

        this.value = Objects.requireNonNull(value);
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

    @Override
    public Integer value() {
        return value;
    }
}
