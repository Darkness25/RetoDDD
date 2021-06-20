package facturacion;


import co.com.sofka.domain.generic.Entity;
import facturacion.values.FacturaId;
import facturacion.values.HoraSalida;
import facturacion.values.ValorTotal;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {

    protected HoraSalida horaSalida;
    protected ValorTotal valorTotal;

    public Factura(FacturaId entityId, HoraSalida horaSalida, ValorTotal valorTotal) {
        super(entityId);
        this.horaSalida = horaSalida;
        this.valorTotal = valorTotal;
    }

    public void modificarHoraSalidaDefactura(HoraSalida horaSalida){
        this.horaSalida = Objects.requireNonNull(horaSalida);
    }

    public HoraSalida horaSalida(){
        return this.horaSalida;
    }

    public ValorTotal valorTotal(){
        return this.valorTotal;
    }
}
