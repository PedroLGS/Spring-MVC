package br.com.pedroluiz.SpringMVC.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.pedroluiz.SpringMVC.model.FuncDep;

@Repository
public class FuncDepDao implements IFuncDep {
	
	@Autowired
	GenericDao gDao;

	@Override
	public List<FuncDep> findfuncdep() throws SQLException, ClassNotFoundException {	
		List<FuncDep> funcdep = new ArrayList<FuncDep>();
		
		Connection c = gDao.getConnection();		
		String sql = "SELECT nome, nome_dependente, salario, salario_dependente FROM fn_tablefunc()";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			FuncDep fd = new FuncDep();
			fd.setNomeFuncionario(rs.getString("nome"));
			fd.setNomeDependente(rs.getString("nome_dependente"));
			fd.setSalarioFuncionario(rs.getFloat("salario"));
			fd.setSalarioDependente(rs.getFloat("salario_dependente"));
			
			funcdep.add(fd);
		}
		rs.close();
		ps.close();
		c.close();
		
		return funcdep;
	}

	@Override
	public double findsoma(int FuncDep) throws SQLException, ClassNotFoundException {
		double soma_salario = 0;
		Connection c = gDao.getConnection();
		String sql = "SELECT dbo.fn_soma(?) AS func";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, FuncDep);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			soma_salario = rs.getDouble(FuncDep);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return soma_salario;
	}
}