

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
    
    //abstract boolean operacion(Cuenta cuenta);

    
    
}
