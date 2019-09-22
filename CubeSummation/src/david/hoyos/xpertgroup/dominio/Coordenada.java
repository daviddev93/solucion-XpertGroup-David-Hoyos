package david.hoyos.xpertgroup.dominio;

public class Coordenada {

	private Integer x;
	private Integer y;
	private Integer z;

	public Coordenada(Integer x, Integer y, Integer z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	
	/**
	 * Metodo Encargado de establecer si un bloque pertenece a la Submatriz
	 * @param coordenadaXYZ
	 * @param coordenadaX1Y1Z1
	 * @param coordenadaX2Y2Z2
	 * @return boolean
	 */
	public static boolean coordenadaEstaEnSubmatriz(Coordenada coordenadaXYZ, Coordenada coordenadaX1Y1Z1,
			Coordenada coordenadaX2Y2Z2) {
		if ((coordenadaXYZ.x >= coordenadaX1Y1Z1.x && coordenadaXYZ.x <= coordenadaX2Y2Z2.x)
			&& (coordenadaXYZ.y >= coordenadaX1Y1Z1.y && coordenadaXYZ.x <= coordenadaX2Y2Z2.y)
			&& (coordenadaXYZ.z >= coordenadaX1Y1Z1.z && coordenadaXYZ.z <= coordenadaX2Y2Z2.z)) {
			return true;
		}
		return false;
	}
}
