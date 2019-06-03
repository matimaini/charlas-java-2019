package matias.prestamo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import matias.prestamo.entities.Cuota;
import matias.prestamo.entities.Prestamo;
import matias.prestamo.enums.SistemaAmortizacion;

/**
 * Fuente <a href="https://ambito-financiero.com/formulas-calcular-prestamo/">ambito-financiero.com</a>
 * 
 * @author ismael.ait
 */
public class CalculadoraPrestamos {
	
	private static BigDecimal calcularTasaPeriodo(BigDecimal porcentajeTasaAnual, Integer periodo) {
		BigDecimal tasaAnual = porcentajeTasaAnual.divide(BigDecimal.valueOf(100));
		Double tasaPeriodoDouble = Math.pow(1 + tasaAnual.doubleValue(), 1/periodo.doubleValue()) - 1;
		BigDecimal tasaPeriodo = BigDecimal.valueOf(tasaPeriodoDouble);
		return tasaPeriodo;
	}
	
	public static List<Cuota> calcularCuotas(Prestamo prestamo) {
		final int scale = 100;
		//
		BigDecimal tasaMensual = calcularTasaPeriodo(prestamo.getTna(), 12);
		BigDecimal capitalInicial = prestamo.getCapital();
		Integer nroCuotas = prestamo.getNroCuotas();
		SistemaAmortizacion sistema = prestamo.getSistema();
		//
		if (sistema != SistemaAmortizacion.FRANCES) {
			throw new UnsupportedOperationException();
		}
		//
		BigDecimal valorCuota = capitalInicial.multiply(
				tasaMensual.multiply(BigDecimal.ONE.add(tasaMensual).pow(nroCuotas)).divide(
				BigDecimal.ONE.add(tasaMensual).pow(nroCuotas).subtract(BigDecimal.ONE), scale, RoundingMode.HALF_EVEN));
		//
		List<Cuota> cuotas = new ArrayList<>();
		BigDecimal capitalAnterior = capitalInicial;
		for (int i = 1; i <= nroCuotas; i++) {
			
			BigDecimal saldo = valorCuota.multiply(
					BigDecimal.ONE.subtract(BigDecimal.ONE.divide(BigDecimal.ONE.add(tasaMensual), scale, RoundingMode.HALF_EVEN)
							.pow(nroCuotas-i))
					.divide(tasaMensual, scale, RoundingMode.HALF_EVEN));
			BigDecimal capital = capitalAnterior.subtract(saldo);
			BigDecimal interes = valorCuota.subtract(capital);
			capitalAnterior = saldo;
			
			Cuota cuota = new Cuota(i, valorCuota, interes, capital, saldo);
			cuotas.add(cuota);
		}
		return cuotas;
	}

}
