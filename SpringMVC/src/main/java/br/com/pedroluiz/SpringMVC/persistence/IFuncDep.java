package br.com.pedroluiz.SpringMVC.persistence;

import java.sql.SQLException;
import java.util.List;

import br.com.pedroluiz.SpringMVC.model.FuncDep;

public interface IFuncDep {

	public List<FuncDep> findfuncdep() throws SQLException, ClassNotFoundException;
	public double findsoma(int FuncDep) throws SQLException, ClassNotFoundException;
	
}
