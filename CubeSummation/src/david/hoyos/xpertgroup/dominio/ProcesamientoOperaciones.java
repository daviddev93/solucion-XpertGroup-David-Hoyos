package david.hoyos.xpertgroup.dominio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcesamientoOperaciones {

	private static String OPERACIONACTUALIZACION = "UPDATE";
	static Map<Coordenada, Integer> actualizacionesRealizadas = new HashMap<Coordenada, Integer>();


	public static  void procesarOperaciones(Integer tamañoMatriz, List<String> operaciones) {

		for (String operacion : operaciones) {
			String[] datosOperacion = operacion.split(" ");
			if (OPERACIONACTUALIZACION.equals(datosOperacion[0])) {
				procesarActualizacion(datosOperacion);
			} else {
				procesarQuerySuma(datosOperacion);
			}
		}
	}

	private static void procesarActualizacion(String[] datosOperacion) {
		Integer x =Integer.parseInt(datosOperacion[1]);
		Integer y =Integer.parseInt(datosOperacion[2]);
		Integer z =Integer.parseInt(datosOperacion[3]);
		Integer w = Integer.parseInt(datosOperacion[4]);
		Coordenada coordenada = new Coordenada(x,y,z);
		actualizacionesRealizadas.put(coordenada,w);
	}

	private static void procesarQuerySuma(String[] datosOperacion) {
		actualizacionesRealizadas.values().stream().filter(arg0);
	}
	
	/*private static boolean valorEstaEnSubmatriz() {
		
	}
	*/
}
