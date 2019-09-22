package david.hoyos.xpertgroup.dominio;

import java.util.ArrayList;
import java.util.List;

public class ProcesamientoOperaciones {

	private static final String OPERACIONACTUALIZACION = "UPDATE";
	private static final Integer[] XYZ = {1,2,3};
	private static final Integer[] X1Y1Z1 = {1,2,3};
	private static final Integer[] X2Y2Z2 = {4,5,6};


	/**
	 * Metodo encargado de procesar las operaciones de las matrices
	 * @param tamañoMatriz
	 * @param operaciones
	 * @return List<Integer>
	 */
	public static List<Integer> procesarOperaciones(Integer tamañoMatriz, List<String> operaciones) {
		List<Integer> resultadoConsultas = new ArrayList<Integer>();
		List<OperacionActualizacion> actualizacionesRealizadas = new ArrayList<>();

		for (String operacion : operaciones) {
			String[] datosOperacion = operacion.split(" ");
			if (OPERACIONACTUALIZACION.equals(datosOperacion[0])) {
				OperacionActualizacion actualizacionBloque = procesarActualizacion(datosOperacion);
				actualizacionesRealizadas.add(actualizacionBloque);
			} else {
				Integer consulta = procesarQuerySuma(datosOperacion, actualizacionesRealizadas);
				resultadoConsultas.add(consulta);
			}
		}
		return resultadoConsultas;
	}

	
	/**
	 * Metodo encargado de crear un objeto de tipo OperacionActualizacion
	 * @param datosOperacion
	 * @return
	 */
	private static OperacionActualizacion procesarActualizacion(String[] datosOperacion) {
		Coordenada coordenada = crearCoordenada(datosOperacion,XYZ);
		Integer valor = Integer.parseInt(datosOperacion[4]);
		return new OperacionActualizacion(coordenada, valor);
	}

	
	/**
	 * Metodo encargado de crear un objeto coordenada 
	 * @param datosOperacion
	 * @param indicesCoordenadas
	 * @return Coordenada
	 */
	private static Coordenada crearCoordenada(String[] datosOperacion,Integer[] indicesCoordenadas) {
		Integer x = Integer.parseInt(datosOperacion[indicesCoordenadas[0]]);
		Integer y = Integer.parseInt(datosOperacion[indicesCoordenadas[1]]);
		Integer z = Integer.parseInt(datosOperacion[indicesCoordenadas[1]]);
		Coordenada coordenada = new Coordenada(x, y, z);
		return coordenada;
	}

	
	/**
	 * Metodo encargado de Sumar todos los valores de los bloques en un rango determinado
	 * @param datosOperacion
	 * @param actualizacionesRealizadas
	 * @return Integer
	 */
	private static Integer procesarQuerySuma(String[] datosOperacion,
			List<OperacionActualizacion> actualizacionesRealizadas) {
		
		Coordenada coordenadaX1Y1Z1 = crearCoordenada(datosOperacion,X1Y1Z1);
		Coordenada coordenadaX2Y2Z2 = crearCoordenada(datosOperacion,X2Y2Z2);

		return actualizacionesRealizadas.stream().filter(
				bloque -> Coordenada.coordenadaEstaEnSubmatriz(bloque.getCoordenada(),
						coordenadaX1Y1Z1, coordenadaX2Y2Z2))
				.mapToInt(bloque -> bloque.getValor()).sum();
	}
}
