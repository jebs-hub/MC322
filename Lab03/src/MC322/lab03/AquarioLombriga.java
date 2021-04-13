package MC322.lab03;

public class AquarioLombriga {
	 //Atributos
    char aquario[];
    int lombriga, posicaoInicial, posicaoFinal;
    
    //Construtor
    AquarioLombriga(int lombriga, int aquario, int posicaoInicial){
        this.aquario = new char[aquario];
        this.lombriga = lombriga;
        this.posicaoInicial = posicaoInicial - 1;
        this.posicaoFinal = posicaoInicial + lombriga - 2;
        //percorrer a array de aquário e coloca a lombriga na posição correta com respectivo tamanho
        //posicaoInicial é a posição do fim da cauda
        //posicao final é a posição da cabeça
        for (int i = 0; i<aquario ; i++){
            if(i == this.posicaoFinal){
                this.aquario[i] = 'O';
            }
            else if(i>=this.posicaoInicial && i<posicaoFinal){
                this.aquario[i] = '@';
            }
            else{
                this.aquario[i] = '#';
            }
        }
    }
    
    void crescer(){
        if(posicaoInicial+1 < aquario.length && aquario[posicaoInicial+1]=='#'){ //cresce para direita
            posicaoInicial++;
            aquario[posicaoInicial] = '@';
        }
        else if(posicaoInicial-1 > -1 && aquario[posicaoInicial-1]=='#'){ //cresce para esquerda
            posicaoInicial--;
            aquario[posicaoInicial] = '@';
        }
    }
    
    void virar(){
        aquario[posicaoFinal] = '@';   //troca posições inicias e finais
        aquario[posicaoInicial] = 'O';
        int aux = posicaoFinal;
        posicaoFinal = posicaoInicial;
        posicaoInicial = aux;
    }
    
    void mover(){
        if(posicaoFinal>posicaoInicial && posicaoFinal+1<aquario.length){ //virada para direita com espaço
            aquario[posicaoFinal+1] = 'O';
            aquario[posicaoFinal] = '@';
            aquario[posicaoInicial] = '#';
            posicaoInicial++;
            posicaoFinal++;
        }
        else if(posicaoFinal<posicaoInicial && posicaoFinal-1>-1){ //virada para esquerda com espaço
            posicaoFinal--;
            aquario[posicaoFinal] = 'O';
            aquario[posicaoFinal+1] = '@';
            aquario[posicaoInicial] = '#';
            posicaoInicial--;
        }
        else { //virada para direita ou para direita, mas sem espaço
            virar();
        }
    }
    
    String apresenta(){
        String estadoAtual = String.valueOf(aquario);
        return estadoAtual;
    }
}
