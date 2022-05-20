package exercicio_interfaces;

public class RentalServices {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	//ASSOCIACAO COM A CLASSE llll
	private TaxService taxService;
	
	public RentalServices() {		
	}

	public RentalServices(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	public void processInvoice(CarRental carRental) {
		//DATA DE RETIRADA DO VEICULO
		long t1 = carRental.getStart().getTime();
		//DATA DE DEVOLUCAO DO VEICULO
		long t2 = carRental.getFinish().getTime();
		//DIFERENCA DE HORAS ENTRE t1 e t2
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;
		double basicPayment;
		//SE ESSE VALOR EM HORAS FOR MENOR OU IGUAL A DOZE, CALCULAR O PREÇO EM HORAS
		if(hours <= 12.0) {
			//VALOR EM HORAS ARREDONDADO PARA CIMA(math.ceil) E MULTIPLICAR PELO PREÇO DA HORA
			basicPayment = Math.ceil(hours) * pricePerHour;
		}else {
			//ACHAR A QUANTIDADE EM DIAS E MULTIPLICAR PELO VALOR EM DIAS
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
		//CALCULAR IMPOSTO
		double tax = taxService.tax(basicPayment);
		//CRIAÇÃO NOVO OBJETO DE NOTA DE PAGAMENTO(new Invoice) e ASSOCIAR COM OBJETO DE ALUGUEL(carRental)
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
	

}
