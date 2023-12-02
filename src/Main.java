import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ponto> pontos = new ArrayList<>();

        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 100; j++) {
                pontos.add(new Ponto(i, j));
            }
        }

        Collections.shuffle(pontos);

        print("Ingenuo");
        long startTime = System.currentTimeMillis();
        double temp = ParProximoIngenuo.executar(pontos);
        print(System.currentTimeMillis() - startTime + " milisegundos.");
        print("Distancia UM: " + temp);

        print("\nDivisao e conquista");
        startTime = System.currentTimeMillis();
        double temp_2 = ParProximo.executar(pontos);
        print(System.currentTimeMillis() - startTime + " milisegundos.");
        print("Distancia DOIS: " + temp_2);
    }

    private static void print(String msg) {
        System.out.println(msg);
    }
}