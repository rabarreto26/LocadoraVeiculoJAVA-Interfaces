package exercicio_interfaces;

public class Invoice {
	
	private double basicPayment; //PAGAMENTO BAISCO
	private double tax; //TAXA IMPOSTO
	
	public Invoice() {		
	}

	public Invoice(double basicPayment, double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	//METODO TOTAL PAGAMENTO
	public double getTotalPayment() {
		return getBasicPayment() + getTax();
	}
	

}
