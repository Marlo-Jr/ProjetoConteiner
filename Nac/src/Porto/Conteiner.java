package Porto;

public class Conteiner {
	private int id;
	private int contMove;

	public Conteiner() {
		
	}

	public Conteiner(int id) {
		this.id = id;
		this.contMove = 0;
	}

	public void mover() {
		contMove++;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContMove() {
		return contMove;
	}

	public void setContMove(int contMove) {
		this.contMove = contMove;
	}
}
