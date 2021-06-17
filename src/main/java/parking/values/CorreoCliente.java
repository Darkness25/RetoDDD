package parking.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CorreoCliente implements ValueObject<String> {

    private final String value;

    public CorreoCliente(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El correo no puede estar vacio");
        }
        if(this.value.length() <= 10){
            throw new IllegalArgumentException("EL correo debe tener minimo 10 caracteres");
        }
        if(!value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new IllegalArgumentException("El correo no cumple con el formato requerido");
        }
    }


    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorreoCliente that = (CorreoCliente) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
