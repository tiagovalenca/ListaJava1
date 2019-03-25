package exercicio4;

import java.util.Scanner;

public class Estatistica {

	public int maiorValor;

	public Estatistica(int maiorValor) {
		this.maiorValor = maiorValor;
	}

//somatorio
	public double somatorio(int num) {
		int soma = 0;
		while (num != 0) {
			soma += num;
			num--;
		}
		return soma;
	}

	// quant de numeros
	public double quantiNum(int num) {
		int cont = 0;
		for (int i = 0; i <= num; i++) {
			cont++;
		}
		return cont;
	}

	// media
	public double media(int num) {
		return somatorio(num) / quantiNum(num);
	}

//variancia
	public double variancia(int num) {
		double des = 0;
		double tot = 0;
		for (int i = 0; i <= num; i++) {

			des = ((i - media(num)) * (i - media(num)));
			tot += des;
		}

		return tot / quantiNum(num);
	}

	// impress�o
	public String imprimeValores(int num) {
		StringBuilder s = new StringBuilder();
		int i = 0;
		s.append("{ ");
		do {
			if (i % 2 == 0) {
				s.append("<" + i + "> � par, ");
			} else {
				s.append("<" + i + "> � impar, ");
			}
			i++;
		} while (i < num);
		if (num % 2 == 0) {
			s.append("<" + num + "> � par }");
		} else {
			s.append("<" + num + "> � impar }");
		}

		return s.toString();
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num, opc;

		System.out.println();
		System.out.println("Escolha uma das op��es do menu:");
		System.out.println("1 - Para calcular o somat�rio");
		System.out.println("2 - Para calcular a m�dia");
		System.out.println("3 - Para calcular a vari�ncia");
		System.out.println("4 - Para imprimir todos os valores");
		System.out.println("5 - Para sair");

		opc = scan.nextInt();

		if (opc == 5) {
			System.out.println("Encerrando a aplica��o...");
			scan.close();
			System.exit(0);
		}

		System.out.println("Digite um n�mero positivo");
		num = scan.nextInt();
		if (num < 0) {
			System.out.println("N�mero inv�lido, entre com um n�mero positivo\n");
			main(args);
		}

		Estatistica et = new Estatistica(num);

		switch (opc) {
		case 1:
			System.out.println("1 - A soma dos inteiros �: " + et.somatorio(num));
			main(args);
		case 2:
			System.out.println("2 - A m�dia dos n�meros �: " + et.media(num));
			main(args);
		case 3:
			System.out.println("3 - A vari�ncia dos n�meros �: " + et.variancia(num));
			main(args);
		case 4:
			System.out.println("4 - A impress�o �: ");
			System.out.println(et.imprimeValores(num));
			main(args);
		}
	}

}
