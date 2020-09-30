package mobile;

import java.io.Serializable;

public class Relogio implements Serializable {
	private static final long SerialVersionUID = 1L;

	private Data d;
	private Horario h;

	public Relogio(int dia, int mes, int ano) {
		d = new Data(dia, mes, ano);
		h = new Horario();
	}

	public Relogio(int dia, int mes, int ano, int hora, int minuto, int segundo) {
		d = new Data(dia, mes, ano);
		h = new Horario(hora, minuto, segundo);
	}

	public Relogio(Data data) {
		this(data.getDia(), data.getMes(), data.getAno());
	}

	public Relogio(Data data, Horario horario) {
		this(data.getDia(), data.getMes(), 
				data.getAno(), horario.getHora(), 
				horario.getMinuto(), horario.getSegundo());
	}
	
	public void tictac() {
		if(h.ehUltimoSegundo()) {
			d.incrementarDia();
		}
	}

	@Override
	public String toString() {
		return "Relogio [d=" + d + ", h=" + h + "]";
	}
	
}
