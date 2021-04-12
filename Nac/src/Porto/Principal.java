package Porto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		TipoPilhaConteiner tpc = new TipoPilhaConteiner();
		List<TipoPilhaConteiner> tpcLista = new ArrayList<>();
		tpcLista.add(tpc);
		int contagemTipoPilhaConteiner = 0;
		Scanner le = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			menu();
			System.out.print("Opção: ");
			int escolha = le.nextInt();
			switch (escolha) {
			case 0:
				loop = false;
				break;
			case 1:
				System.out.print("Escolha um id para o seu contêiner: ");
				Conteiner conteiner = new Conteiner(le.nextInt());
				if (!tpcLista.get(contagemTipoPilhaConteiner).isFull()) {
					tpcLista.get(contagemTipoPilhaConteiner).push(conteiner);
				} else {
					contagemTipoPilhaConteiner++;
					tpcLista.add(new TipoPilhaConteiner());
					tpcLista.get(contagemTipoPilhaConteiner).init();
					tpcLista.get(contagemTipoPilhaConteiner).push(conteiner);
				}
				break;
			case 2:
				System.out.print("Digite o id do contêiner a ser retirado: ");
				int idProcurar = le.nextInt();
				for (TipoPilhaConteiner apagar : tpcLista) {
					if (apagar.idExiste(idProcurar)) {
						excluir(apagar, idProcurar);
						System.out.println("Conteiner "+idProcurar +" saindo para seu destino final");
						break;
					} else {
						
					}
				}

				break;
			case 3:
				System.out.print("Quantidade de Movimentos: ");
				int contaMovimentoFinal = 0;
				for (TipoPilhaConteiner contarMovimento : tpcLista) {
					contaMovimentoFinal += contarMovimento.getMover();
				}
				System.out.println(contaMovimentoFinal);
				break;
			case 4:
				System.out.println("Registro de Contêiners: ");
				int conta = 0;
				for (TipoPilhaConteiner pilhaConteinerMostrar : tpcLista) {
					System.out.println("Pilha " + conta);
					pilhaConteinerMostrar.ocupacaoDeConteiners();
					conta++;
				}
				break;
			case 5:
				System.out.println("Contêiners: ");
				int c = 1;
				for (TipoPilhaConteiner pilhaConteiner : tpcLista) {
					pilhaConteiner.mostrar(c);
					c++;
				}
			}
		}
		le.close();
	}

	public static void menu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("0 - Encerrar programa.\n" + "1 - Insere contêiner no pátio.\n"
				+ "2 - Retira contêiner do pátio.\n" + "3 - Cálculo do custo da movimentação dos conteineres.\n"
				+ "4 - Apresenta os conteineres em cada pilha do pátio.\n"
				+ "5 - Apresenta planilhas de conteineres de cada pilha do pátio.");
		System.out.println("------------------------------------------------------------");

	}

	public static void excluir(TipoPilhaConteiner conteiner, int idExcluir) {
		TipoPilhaConteiner auxilio = new TipoPilhaConteiner();
		int conteinerTop = conteiner.getTop();
		for (int i = 0; i < conteinerTop; i++) {
			if (conteiner.top().getId() == idExcluir) {
				conteiner.pop();
			} else {
				auxilio.push(conteiner.pop());
			}
		}
		conteiner.esvaziar();
		int topo = auxilio.getTop();
		for (int i = 0; i < topo; i++) {
			conteiner.push(auxilio.pop());
		}
	}

}
