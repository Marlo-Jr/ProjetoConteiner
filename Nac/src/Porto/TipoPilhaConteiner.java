package Porto;

public class TipoPilhaConteiner {
	public final int TAMANHO_PILHA = 4;
	private Conteiner conteinerControler[] = new Conteiner[TAMANHO_PILHA];
	private int topAuxiliar = 0;
	private Conteiner conteiners[] = new Conteiner[TAMANHO_PILHA];
	private int top;

	public void init() {
		top = 0;
	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (top == TAMANHO_PILHA) {
			return true;
		} else {
			return false;
		}
	}

	public void push(Conteiner conteiner) {
		if (!isFull()) {
			conteiners[top] = conteiner;
			top++;
		}
	}

	public Conteiner pop() {
		top--;
		conteiners[top].mover();
		return conteiners[top];
	}

	public Conteiner top() {
		return conteiners[top - 1];
	}

	public void esvaziar() {
		while (top != 0) {
			System.out.println("Retirando contêiner: " + pop());
		}
	}

	public int getTop() {
		return this.top;
	}

	public void mostrar(int numeroPilha) {
		System.out.println("=============== Planilha de contêiners (Pilha " + numeroPilha + ") ===============");
		for (int i = 0; i < top; i++) {
			System.out.println("Container: " + conteiners[i].getId());
		}
	}

	public void ocupacaoDeConteiners() {
		System.out.println("Topo -> " + top);
		for (int i = 0; i < top; i++) {
			if (conteiners[i] == null) {
				System.out.println("Null");
				continue;
			}
			System.out.println(i + "]: Conteiner [contMove=" + conteiners[i].getContMove() + ", id="
					+ conteiners[i].getId() + "]");
		}
	}

	public boolean idExiste(int idProcura) {
		boolean retorno = false;
		for (int i = 0; i < conteiners.length; i++) {
			if (conteiners[i] == null) {
				continue;
			}
			if (conteiners[i].getId() == idProcura) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}

	public int getMover() {
		int moveu = 0;
		for (int i = 0; i < top; i++) {
			moveu += conteiners[i].getContMove();
		}
		return moveu;
	}
}
