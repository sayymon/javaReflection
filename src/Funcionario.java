
/**
 * @author user
 *
 */
public class Funcionario {
	String nome;
	String departamento;
	double salario;
	Data dataDeEntradaBanco;
	String rg;
	int identificador;
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	public Funcionario(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Data getDataDeEntradaBanco() {
		return dataDeEntradaBanco;
	}
	public void setDataDeEntradaBanco(Data dataDeEntradaBanco) {
		this.dataDeEntradaBanco = dataDeEntradaBanco;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public void testNome(){
		System.out.println(nome);
	}

	public void testRg(){
		System.out.println(rg);
	}	
	
}