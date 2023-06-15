import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(10, 15));
        pontos.add(new Ponto(19, 16));
        pontos.add(new Ponto(1, 3));
        pontos.add(new Ponto(2, 3));
        pontos.add(new Ponto(5, 4));
        pontos.add(new Ponto(12, 5));

        double temp = ParProximoIngenuo.executar(pontos);
        double temp_2 = ParProximo.executar(pontos);

        print("Distancia UM: " + temp);
        print("Distancia DOIS: " + temp_2);
    }

    private static void print(String msg) {
        System.out.println(msg);
    }
}