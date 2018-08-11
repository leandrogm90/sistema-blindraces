package com.speedrunsbrasil.blindraces.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.speedrunsbrasil.blindraces.dominio.EntidadeDominio;
import com.speedrunsbrasil.blindraces.dominio.Jogo;

public class JogoDAO extends AbstractJdbcDAO {

	public JogoDAO() {
		super("Jogo", "idJogo");
	}

	public int salvar(EntidadeDominio entidade) throws SQLException {
		
		abrirConexao();
		PreparedStatement pst=null;
		Jogo jogo = (Jogo) entidade;
		int idJogoInserido;
			
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO Jogo (titulo, genero, console) ");
			sql.append("VALUES (?,?,?) ");
			sql.append("RETURNING idJogo ");
					
			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, jogo.getTitulo());
			pst.setString(2, jogo.getGenero());
			pst.setString(3, jogo.getConsole());
			
			if (pst.execute()) {
				ResultSet rs = pst.getResultSet();
				rs.next();
				idJogoInserido = rs.getInt(1);
			} else {
				idJogoInserido = pst.getUpdateCount();
			}		
			connection.commit();
			return idJogoInserido;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
			return -1;
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		abrirConexao();
		PreparedStatement pst=null;
		Jogo jogo = (Jogo) entidade;
		
		List<EntidadeDominio> jogos = new ArrayList<EntidadeDominio>();

        try{
        	StringBuilder sql = new StringBuilder();
            sql.append("SELECT idJogo, titulo, genero, console");
            sql.append(" FROM Jogo");

            if (jogo.getId() <= 0){
            	sql.append(" WHERE titulo ILIKE ?");
            	pst = connection.prepareStatement(sql.toString());
    			pst.setString(1, jogo.getTitulo());
            } else {
            	pst = connection.prepareStatement(sql.toString());
            }

            ResultSet rs = pst.executeQuery();
	
			while (rs.next()) {
				Jogo j = new Jogo();
				j.setId(rs.getInt("idJogo"));
				j.setTitulo(rs.getString("titulo"));
				j.setGenero(rs.getString("genero"));
				j.setConsole(rs.getString("console"));
    			jogos.add(j);
    		}
    		
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return jogos;
	}
}
