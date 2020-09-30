package mobile;
import java.io.Serializable;

public class Data implements Serializable {
	private static final long serialVersionUID = 1L;

	private byte dia;
	private byte mes;
	private byte ano;

	private int calculaUltimoDia() {

		int valores[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (ehFevereiro() && ehBisexto()) {
			return 29;
		}
		return valores[mes - 1];
	}

	private boolean ehFevereiro() {
		return mes == 2;
	}

	private boolean ehBisexto() {
		return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
	}

	public Data() {
		this.dia = 1;
		this.mes = 1;
		this.ano = 1;
	}
	
	public Data(int dia,int mes, int ano) {
		this();
		
		setAno((short)ano);
		setMes((byte)mes);
		setDia((byte)dia);
	}
	
	public  byte getDia() {
		return dia;
	}
	public void setDia(int dia) {
		int ultimoDia = calculaUltimoDia();
		
		if(dia<=1 &&dia <= ultimoDia) {
			this.dia = (byte)dia;
		}
	}
	public byte getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		if (mes >= 1 && mes <= 12) {
			this.mes = (byte)mes;
		}
	}

	public short getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		if(ano >=1 && ano <= 9999) {
			this.ano = (byte) ano;
		}
	}
	


	@Override
	public String toString() {
		return this.dia +"/" + this.mes +"/" + this.ano;
	}
	
	public void incrementarDia() {
		int d = dia +1;
		if(d == calculaUltimoDia()+1) {
			dia = 1;
			incrementarMes();
		}else {
			dia = (byte)d;
		}
	}
	
	public void incrementarMes() {
		int m = mes +1;
		if(m ==13) {
			mes =1;
			incrementarAno();
		}else {
			mes = (byte)m;
		}
	}
	
	public void incrementarAno() {
		int a = ano +1;
		
		if(a == 10000) {
			ano = 1;
		}else {
			ano = (byte) a;
		}
	}
	

}