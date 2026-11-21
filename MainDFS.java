
import java.util.*;

public class MainDFS {

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

    // Busqueda por profundidad DFS
    public static void DFS(String actual,
                           Set<String> visitados,
                           List<String> secuencia,
                           Deque<String> pila) {

        // Marcar como visitado
        visitados.add(actual);
        secuencia.add(actual);
        pila.addLast(actual);

        System.out.println("\nVertice actual: " + actual);
        System.out.println("Visitados: " + visitados);
        System.out.println("Pila: " + pila);

        // Revisar vertices adyacentes
        for (String vecino : grafo.get(actual)) {

            if (!visitados.contains(vecino)) {

                DFS(vecino, visitados, secuencia, pila);
            }
        }

        // Regresar al vertice anterior
        pila.removeLast();
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

        // Preparar estructuras
        Set<String> visitados = new LinkedHashSet<>();
        List<String> secuencia = new ArrayList<>();
        Deque<String> pila = new ArrayDeque<>();

        System.out.println("===== RECORRIDO DFS =====");

        // Ejecutar DFS desde A
        DFS("A", visitados, secuencia, pila);

        System.out.println("\nSecuencia final DFS:");
        System.out.println(secuencia);
    }
}
