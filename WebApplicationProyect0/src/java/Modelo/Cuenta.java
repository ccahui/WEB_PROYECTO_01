package Modelo;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Cuenta implements HttpSessionBindingListener{
	private String numCuenta;
	private String propietario;
    
	public Cuenta(String numCuenta,String propietario){
		this.numCuenta=numCuenta;
		this.propietario=propietario;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	@Override
	public String toString() {
		return "Cuenta [numCuenta=" + numCuenta + ", propietario=" + propietario + "]";
	}

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
       //To change body of generated methods, choose Tools | Templates.
    }

}
