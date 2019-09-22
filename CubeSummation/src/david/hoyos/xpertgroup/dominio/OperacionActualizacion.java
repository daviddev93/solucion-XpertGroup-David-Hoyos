package david.hoyos.xpertgroup.dominio;

public class OperacionActualizacion {
	
	 private Coordenada coordenada;
	 private Integer valor;
	
	public OperacionActualizacion(Coordenada coordenada,Integer valor) {
		this.coordenada = coordenada;
		this.valor = valor;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public Integer getValor() {
		return valor;
	}
}
