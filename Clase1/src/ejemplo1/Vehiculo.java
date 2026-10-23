package ejemplo1;

public class Vehiculo {
	public String modelo, marca;
	public int km = 0;
	private double precio = 0.0;
	
	public Vehiculo() {
		this.modelo = "No definido";
		this.marca = "No definido";
	}
	
	public Vehiculo(String modelo_, String marca_) {
		this.modelo = modelo_;
		this.marca = marca_;
	}
	
	public Vehiculo(String modelo_, String marca_, double precio_) {
		this.modelo = modelo_;
		this.marca = marca_;
		this.precio = precio_;
	}
	
	public String informacion() {
		return String.format("Modelo: %s\nMarca: %s\nKilometraje: %d km\nPrecio: $%.2f", modelo, marca, km, precio);
	}
}