import java.util.Arrays;
import java.util.Random;

public class CampoMinado {
    GeraPosicao[] minas;

    CampoMinado(int x){
        minas = new GeraPosicao[x];
        while (minas.length<x){

        }
        System.out.println(Arrays.toString(minas));
    }

}
class GeraPosicao{
    int [] posicao;
    Random  pos = new Random();

    GeraPosicao(int x){
        int X = pos.nextInt(x);
        int Y = pos.nextInt(x);
        if (x!=Y) {
            posicao = new int[]{X, Y};
        }

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

class Teste{
    public static void main(String[] args) {
        CampoMinado f = new CampoMinado(10);

    }
}