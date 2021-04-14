package mc322.lab03;

public class Animacao {
	//Atributos
    
    int movAtual, totalMov; //controla os movimentos
    String movimentos;    
    
    AquarioLombriga lombriga; //controla estado da lombriga
    
    //Construtor
    Animacao(String animacoes){
        int tamanhoAquario = Integer.parseInt(animacoes.substring(0,2));
        int tamanhoLombriga = Integer.parseInt(animacoes.substring(2,4));
        int posicaoInicial = Integer.parseInt(animacoes.substring(4,6));
        lombriga = new AquarioLombriga(tamanhoLombriga, tamanhoAquario, posicaoInicial);
        movimentos = animacoes.substring(6,animacoes.length());
        totalMov = movimentos.length();
    }
    
    void passo(){
        if(movAtual < totalMov){
            if(movimentos.charAt(movAtual)=='M'){
                lombriga.mover();
            }
            else if(movimentos.charAt(movAtual)=='C'){
                lombriga.crescer();
            }
            else {
                lombriga.virar();
            }
            movAtual++;
        } else {
            System.out.println("Sem mais movimentos");
        }
    }
    
    String apresenta(){
        return lombriga.apresenta();
    }
}
