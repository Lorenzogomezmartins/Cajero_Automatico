

package Model;


public abstract class Transaccion {
    protected int cantidad;
    protected String nroTarjeta;
    protected boolean estadoTransaccion;

     public Transaccion(int cantidad, String nroTarjeta, boolean estadoTransaccion) {
        this.cantidad = cantidad;
        this.nroTarjeta = nroTarjeta;
        this.estadoTransaccion = estadoTransaccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public boolean isEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(boolean estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }
}
