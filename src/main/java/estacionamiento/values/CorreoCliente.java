package estacionamiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CorreoCliente implements ValueObject<String> {

    private final String value;

    public CorreoCliente(String value) {

        if(value.length()<12){
            throw new IllegalArgumentException("El Correo no puede ser menor a 12 caracteres");
        }

        if(!value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new IllegalArgumentException("El correo no cumple con el formato requerido");
        }

        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var titulo1 = (CorreoCliente) o;
        return Objects.equals(value, titulo1.value);
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
