package matias.prestamo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import matias.prestamo.entities.Cuota;
import matias.prestamo.entities.Prestamo;
import matias.prestamo.enums.SistemaAmortizacion;
import matias.prestamo.utils.CalculadoraPrestamos;

public class App {

	public static void main(String[] args) {

		System.out.println("Bienvenido a la calculadora de pr�stamos");
		Scanner scanner = new Scanner(System.in);
		
		BigDecimal capital = null;
		while (capital == null) {
			System.out.println("Ingrese capital solicitado:");
			String capitalStr = scanner.nextLine();
			try {
				capital = new BigDecimal(capitalStr);
			} catch (NumberFormatException e) {
				System.out.println("�Valor inv�lido! Debe ingresarse un n�mero decimal.");
			}
		}
		
		Integer nroCuotas = null;
		while (nroCuotas == null) {
			System.out.println("Ingrese n�mero de cuotas:");
			String nroCuotasStr = scanner.nextLine();
			try {
				nroCuotas = Integer.valueOf(nroCuotasStr);
			} catch (NumberFormatException e) {
				System.out.println("�Valor inv�lido! Debe ingresarse un n�mero entero (sin decimales).");
			}
		}
		
		SistemaAmortizacion sistema = null;
		while (sistema == null) {
			System.out.println("Ingrese el sistema de amortizaci�n:");
			String sistemaStr = scanner.nextLine();
			try {
				sistema = SistemaAmortizacion.valueOf(sistemaStr.toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println(String.format("�Valor inv�lido! Debe ingresarse un valor entre: %s", 
						Arrays.asList(SistemaAmortizacion.values()).stream()
							.map(sist -> sist.name())
							.collect(Collectors.joining(", "))));
			}
		}
		
		BigDecimal tasa = null;
		while (tasa == null) {
			System.out.println("Ingrese la tasa de inter�s:");
			String tasaStr = scanner.nextLine();
			try {
				tasa = new BigDecimal(tasaStr);
			} catch (NumberFormatException e) {
				System.out.println("�Valor inv�lido! Debe ingresarse un n�mero decimal.");
			}
		}

		scanner.close();
		Prestamo prestamo = new Prestamo(capital, nroCuotas, tasa, sistema);
		List<Cuota> cuotas;
		try {
			cuotas = CalculadoraPrestamos.calcularCuotas(prestamo);
		} catch (UnsupportedOperationException e) {
			System.out.println(String.format("�Sistema de amortizaci�n %s todav�a no soportado!", sistema.name()));
			return;
		}
		
		System.out.println(prestamo);
		cuotas.stream().forEach(c -> System.out.println(c));
	}

}
