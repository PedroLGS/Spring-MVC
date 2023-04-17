package br.com.pedroluiz.SpringMVC.model;

public class FuncDep {
	
	private int codigo;
	private String nomeFuncionario;
	private Float salarioFuncionario;
	private String nomeDependente;
	private Float salarioDependente;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public Float getSalarioFuncionario() {
		return salarioFuncionario;
	}
	public void setSalarioFuncionario(Float salarioFuncionario) {
		this.salarioFuncionario = salarioFuncionario;
	}
	public String getNomeDependente() {
		return nomeDependente;
	}
	public void setNomeDependente(String nomeDependente) {
		this.nomeDependente = nomeDependente;
	}
	public Float getSalarioDependente() {
		return salarioDependente;
	}
	public void setSalarioDependente(Float salarioDependente) {
		this.salarioDependente = salarioDependente;
	}

	@Override
	public String toString() {
		return "FuncDep [codigo=" + codigo + ", nomeFuncionario=" + nomeFuncionario + ", salarioFuncionario="
				+ salarioFuncionario + ", nomeDependente=" + nomeDependente + ", salarioDependente=" + salarioDependente
				+ "]";
	}
}