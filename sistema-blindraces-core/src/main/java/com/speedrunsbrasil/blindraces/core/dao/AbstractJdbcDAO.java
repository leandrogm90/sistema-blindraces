package com.speedrunsbrasil.blindraces.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.speedrunsbrasil.blindraces.core.util.Conexao;
import com.speedrunsbrasil.blindraces.dominio.EntidadeDominio;

public abstract class AbstractJdbcDAO implements IDAO {
	
	protected Connection connection;
	protected String tabela;
	protected String idTabela;
	protected boolean ctrlTransacao = true;
	
	public AbstractJdbcDAO(Connection conn, String tabela, String idTabela){
		this.tabela = tabela;
		this.idTabela = idTabela;
		this.connection = conn;
	}
	public AbstractJdbcDAO(String tabela, String idTabela){
		this.tabela = tabela;
		this.idTabela = idTabela;
	}
	public void excluir(EntidadeDominio entidade){
		abrirConexao();
		PreparedStatement ps = null;
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM");
		sb.append(tabela);
		sb.append("WHERE ");
		sb.append(idTabela);
		sb.append("=");
		sb.append("?");
		
		try{
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sb.toString());
			ps.setInt(1, entidade.getId());
			
			ps.executeUpdate();
			connection.commit();
		}
		catch(SQLException e){
			try{
				connection.rollback();
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
				if(ctrlTransacao)
					connection.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	protected void abrirConexao(){
		try {	
			if(connection == null || connection.isClosed())
				connection = Conexao.getConnection();		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
