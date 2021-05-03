package gui;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import clasesUsuario.Usuario;




public class MetodoPago {
	protected PaymentEnum paymentType = null;
	
	private Usuario user;
	
	public PaymentEnum getPaymentType() {
		return this.paymentType;
	}
}
