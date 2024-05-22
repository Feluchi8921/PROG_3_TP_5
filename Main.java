import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[]args){
        // Crear un grafo dirigido
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar aristas
        grafo.agregarArco(1, 2, 1);
        grafo.agregarArco(1, 3, 2);
        grafo.agregarArco(3, 2, 6);
        grafo.agregarArco(2, 4, 3);
        grafo.agregarArco(3, 5, 4);
        grafo.agregarArco(4, 5, 5);

        int entrada = 1;
        int salida = 5;


        // Crear un objeto de la clase `AtravesarMayorCantidadSalas`
        AtravesarMayorCantidadSalas caminoMasLargo = new AtravesarMayorCantidadSalas(grafo, entrada, salida);
        // Encontrar el camino más largo
        List<Integer> caminoEncontrado = caminoMasLargo.caminoMayorSalas(entrada, salida);

        // Imprimir el camino más largo
        System.out.println("\nCamino más largo de " + entrada + " a " + salida + ":");
        System.out.println(caminoEncontrado);
    }
}
