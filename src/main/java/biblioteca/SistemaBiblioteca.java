package biblioteca;
import java.util.*;

public class SistemaBiblioteca {
    private Map<String, Material> catalogo = new HashMap<>();
    private Map<String, List<String>> listaEspera = new HashMap<>();
    private Set<String> miembros = new HashSet<>();
//HashMap
    public void registrarMaterial(Material m) {
        catalogo.put(m.getCodigo(), m);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo);
    }

    public void mostrarCatalogo() {
        System.out.println("CATÁLOGO DE LA BIBLIOTECA");
        for (Map.Entry<String, Material> entry : catalogo.entrySet()) {
            entry.getValue().mostrarInfo();
        }
    }
    //ArrayList
    public void agregarEspera(String codigoMaterial, String usuario){
        listaEspera.putIfAbsent(codigoMaterial, new ArrayList<>());
        listaEspera.get(codigoMaterial).add(usuario);
    }

    public String siguienteEnEspera(String codigoMaterial) {
        List<String> espera = listaEspera.get(codigoMaterial);
        if (espera != null && !espera.isEmpty()) {
            return espera.remove(0);
        }
        return "No hay usuarios en espera ";
    }

    //HahSet
    public boolean registrarMiembro(String usuario){
        return miembros.add(usuario);
    }

    public boolean tieneMembresia(String usuario){
        return miembros.contains(usuario);
    }
}
