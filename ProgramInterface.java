package exercicio_interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramInterface {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		//LEITURA DOS DADOS
		System.out.println("Enter rental data: ");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:ss): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy HH:ss): ");
		Date finish = sdf.parse(sc.nextLine());
		
		//OBJETO DO ALUGUEL
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		//INSTANCIAR O SERVIÇO DE ALUGUEL DO VEICULO.
		RentalServices rentalService = new RentalServices(pricePerHour, pricePerDay, new BrazilTaxServices ());
		
		//ACESSAR O SERVIÇO DE ALUGUEL E CHAMAR A OPERACAO: "processInvoice", PASSANDO COMO ARGUMENTO O OBJETO "cr"
		rentalService.processInvoice(cr);
		
		System.out.println("INVOICE: ");
		System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
		sc.close();

	}

}
