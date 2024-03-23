package ingenuo;

import utils.Ponto;
import utils.Utils;

import java.util.List;

public class ParProximoIngenuo {

    public static double executar(List<Ponto> pontos) {
        double menorDistancia = Double.MAX_VALUE;
        int n = pontos.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                menorDistancia = Utils.getMenorDistanciaOtimizada(menorDistancia, pontos.get(i), pontos.get(j));
            }
        }
        return menorDistancia;
    }
}
