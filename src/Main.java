import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(10, 15));
        pontos.add(new Ponto(19, 16));
        pontos.add(new Ponto(1, 3));
        pontos.add(new Ponto(5, 4));
        pontos.add(new Ponto(12, 5));

        Map temp = ParProximo.executar(pontos);

        print("Distancia: "+temp.keySet().toString());
        temp.values().forEach(m -> print(m.toString()));
        System.out.println();
    }

    private static void print(String msg){
        System.out.println(msg);
    }
}