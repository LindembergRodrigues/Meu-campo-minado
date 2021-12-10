import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CampoMinado {
    List<GeraPosicao> minas;

    CampoMinado(int x, int y){
        int tamanho_matriz = x * y;
        int  qtd_minas= (int)(tamanho_matriz * 0.2);
        minas = new ArrayList<>();
        while (true){
            if (minas.size()==qtd_minas){
                break;
            }
            GeraPosicao posicao = new GeraPosicao(x,y);
            if (!minas.contains(posicao)){
                minas.add(posicao);
            }
        }
        minas.stream().forEach(System.out::println);
        GeraTabela tabela = new GeraTabela(x,y);
        tabela.geraTable(minas);
        System.out.println(tabela.toString());
    }

}

class Teste{
    public static void main(String[] args) {
        CampoMinado c = new CampoMinado(50,20);

    }
}
class GeraPosicao{
    int [] posicao;
    Random  pos = new Random();

    GeraPosicao(int x , int y){
        int X = pos.nextInt(x);
        int Y = pos.nextInt(y);
        posicao = new int[]{X, Y};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeraPosicao that = (GeraPosicao) o;
        return Arrays.equals(posicao, that.posicao);
    }

    public int getPosicaoX(){
        return posicao[0];
    }
    public int getPosicaoY(){
        return posicao[1];
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

class GeraTabela{
    int [][] tabela;

    GeraTabela(int x, int y){
        tabela = new int[x][y];
    }

    public void geraTable(List<GeraPosicao> minas){
        for (int i =0; i<minas.size();i++){
            tabela[minas.get(i).getPosicaoX()][minas.get(i).getPosicaoY()]=1;
        }
    }

    public String toString (){
        String retorno ="";

        for (int i=0; i< tabela.length;i++) {
            retorno +="|";
            for (int j = 0; j < tabela[i].length; j++) {
                retorno += tabela[i][j]+"|";
            }
            retorno +="\n";
        }
        return retorno;
    }
}