package ejemplo1;

public class PatioAutos {
    private Vehiculo[] vehiculos;
    private int contador;

    public PatioAutos(int capacidad) {
        vehiculos = new Vehiculo[capacidad];
        contador = 0;
    }

    public boolean agregarVehiculo(Vehiculo v) {
        if (contador < vehiculos.length) {
            vehiculos[contador] = v;
            contador++;
            return true;
        }
        return false;
    }

    public boolean retirarVehiculo(String modeloBusqueda) {
        for (int i = 0; i < contador; i++) {
            if (vehiculos[i].modelo.equalsIgnoreCase(modeloBusqueda)) {
                for (int j = i; j < contador - 1; j++) {
                    vehiculos[j] = vehiculos[j + 1];
                }
                vehiculos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    public String listarVehiculos() {
        if (contador == 0) {
            return "El patio de autos esta actualmente vacio.";
        }
        
        StringBuilder sb = new StringBuilder("\n--- LISTA DE VEHICULOS EN EL PATIO ---\n");
        for (int i = 0; i < contador; i++) {
            sb.append("[Vehiculo ").append(i + 1).append("]\n")
              .append(vehiculos[i].informacion())
              .append("\n-----------------------------------\n");
        }
        return sb.toString();
    }
}