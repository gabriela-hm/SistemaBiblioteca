package biblioteca;

public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        System.out.println("PRUEBA DE CATÁLOGO ");
        Libro libro1 = new Libro("23", "La trenza de la locura", 2011, true, "Benjamin Labatut", "978-8415130321");
        Libro libro2 = new Libro("24", "El ferrocarril subterráneo", 2016, false, "Colson Whitehead", "978-8416544783");
        Revista revista1 = new Revista("ISSN 0021-065X", "The Jack London Journal", 1994, true,  1, "Ensayo");
        Revista revista2 = new Revista("ISSN 1139-3637", "revista de poesía y pensamiento", 1926, true, 1, "Literatura");

        biblioteca.registrarMaterial(libro1);
        biblioteca.registrarMaterial(libro2);
        biblioteca.registrarMaterial(revista1);
        biblioteca.registrarMaterial(revista2);

        biblioteca.mostrarCatalogo();

        System.out.println("Buscando código existente (23):");
        Material encontrado = biblioteca.buscarMaterial("23");
        if (encontrado != null) encontrado.mostrarInfo();

        System.out.println("Buscando código inexistente (25):");
        Material noEncontrado = biblioteca.buscarMaterial("25");
        System.out.println(noEncontrado == null ? "Resultado: El material no existe." : "");


        System.out.println("2. PRUEBA DE MEMBRESÍAS (HashSet)");
        System.out.println("Registrando a 'Jeimy': " + biblioteca.registrarMiembro("Jeimy"));
        System.out.println("Registrando a ' Gabriela': " + biblioteca.registrarMiembro("Gabriela"));


        System.out.println("3. LISTA DE ESPERA (ArrayList)");
        String codigoPrestado = "ISSN 1139-3637";

        biblioteca.agregarEspera(codigoPrestado, "Gabriela");
        biblioteca.agregarEspera(codigoPrestado, "Jeimy");
        biblioteca.agregarEspera(codigoPrestado, "Liliana");

        System.out.println("Atendiendo al primer usuario en espera para la revista prestada:");
        System.out.println("-> Entregando a: " + biblioteca.siguienteEnEspera(codigoPrestado));

        System.out.println("Atendiendo al siguiente en la fila:");
        System.out.println("-> Entregando a: " + biblioteca.siguienteEnEspera(codigoPrestado));
    }

}
