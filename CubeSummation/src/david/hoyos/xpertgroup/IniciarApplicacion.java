package david.hoyos.xpertgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import david.hoyos.xpertgroup.dominio.ProcesamientoOperaciones;

public class IniciarApplicacion {

	public static void main(String[] args) throws IOException {
		List<Integer> resultadoOperaciones = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String casosDePruebas = bufferedReader.readLine();
		Integer numeroDePruebas = Integer.parseInt(casosDePruebas);

		for (int caso = 0; caso < numeroDePruebas; caso++) {
			List<String> operaciones = new ArrayList<>();
			String[] nm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			Integer tamaņoMatriz = Integer.parseInt(nm[0]);
			Integer numeroOperaciones = Integer.parseInt(nm[1]);

			for (int operacion = 0; operacion < numeroOperaciones; operacion++) {
				operaciones.add(bufferedReader.readLine().toString());
			}
			resultadoOperaciones.addAll(ProcesamientoOperaciones.procesarOperaciones(tamaņoMatriz,
					operaciones));
		}
		
		resultadoOperaciones.forEach(a->{
			System.out.println(a);
		});
	}
}
