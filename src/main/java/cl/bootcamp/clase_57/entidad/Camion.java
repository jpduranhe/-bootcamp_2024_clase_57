package cl.bootcamp.clase_57.entidad;

public class Camion {
	
	private int id;
	private String marca;
	private String modelo;
	private int choferId;
	
	public Camion() {};
	public Camion(int id, String marca, String modelo, int choferId) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.choferId = choferId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getChoferId() {
		return choferId;
	}
	public void setChoferId(int choferId) {
		this.choferId = choferId;
	}
	
	
}
