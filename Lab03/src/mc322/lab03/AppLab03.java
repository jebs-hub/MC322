package mc322.lab03;

public class AppLab03 {
	public static void main(String[] args) {
		Animacao lombriga = new Animacao("080403MCMVM");
		int totalMovimentos = lombriga.totalMov;
		System.out.println(lombriga.apresenta());
		for(int i = 0; i<totalMovimentos; i++){
		    lombriga.passo();
		    System.out.println(lombriga.apresenta());
		}
	}
}
