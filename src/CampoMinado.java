import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CampoMinado {
    List<GeraPosicao> minas;

    CampoMinado(int x){
        int tamanho_matriz = x * x;
        int  qtd_minas= (int)(tamanho_matriz * 0.2);
        minas = new ArrayList<>();
        while (true){
            if (minas.size()==qtd_minas){
                break;
            }
            GeraPosicao posicao = new GeraPosicao(tamanho_matriz);
            if (!minas.contains(posicao)){
                minas.add(posicao);
            }
        }
        minas.stream().forEach(System.out::println);
        System.out.println(minas.size());
    }

}

class Teste{
    public static void main(String[] args) {
        CampoMinado c = new CampoMinado(50);

    }
}
class GeraPosicao{
    int [] posicao;
    Random  pos = new Random();

    GeraPosicao(int x){
        int X = pos.nextInt(x);
        int Y = pos.nextInt(x);
        posicao = new int[]{X, Y};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeraPosicao that = (GeraPosicao) o;
        return Arrays.equals(posicao, that.posicao);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(posicao);
    }

    @Override
    public String toString() {
        return "GeraPosicao{" +
                "posicao=" + Arrays.toString(posicao) +
                '}';
    }
}