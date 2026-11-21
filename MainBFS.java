
import java.util.*;

public class MainBFS {

    static Map<String, List<String>> grafo = new TreeMap<>();

    // Agregar vertices
    public static void agregarVertice(String v) {
        grafo.putIfAbsent(v, new ArrayList<>());
    }

    // Agregar conexiones
    public static void agregarArista(String v1, String v2) {

        agregarVertice(v1);
        agregarVertice(v2);

        grafo.get(v1).add(v2);
        grafo.get(v2).add(v1);

        Collections.sort(grafo.get(v1));
        Collections.sort(grafo.get(v2));
    }

    // Busqueda por anchura BFS
    public static void BFS(String inicio) {

        Queue<String> cola = new LinkedList<>();
        Set<String> visitados = new LinkedHashSet<>();

        visitados.add(inicio);
        cola.add(inicio);

        int paso = 1;

        System.out.println("===== RECORRIDO BFS =====");

        while (!cola.isEmpty()) {

            String actual = cola.poll();

            System.out.println("\nPaso: " + paso);
            System.out.println("Vertice actual: " + actual);

            for (String vecino : grafo.get(actual)) {

                if (!visitados.contains(vecino)) {

                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }

            System.out.println("Visitados: " + visitados);
            System.out.println("Cola: " + cola);

            paso++;
        }

        System.out.println("\nSecuencia final BFS:");
        System.out.println(visitados);
    }

    public static void main(String[] args) {

        // Construccion del grafo

        agregarArista("A", "B");
        agregarArista("A", "C");

        agregarArista("B", "D");
        agregarArista("B", "E");

        agregarArista("C", "F");
        agregarArista("C", "G");

        agregarArista("D", "H");

        agregarArista("E", "H");
        agregarArista("E", "I");

        agregarArista("F", "I");
        agregarArista("F", "J");

        agregarArista("G", "J");

        agregarArista("H", "I");
        agregarArista("I", "J");

        // Ejecutar BFS desde A
        BFS("A");
    }
}
