package com.speedrunsbrasil.blindraces.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.speedrunsbrasil.blindraces.dominio.EntidadeDominio;
import com.speedrunsbrasil.blindraces.dominio.Jogo;
import com.speedrunsbrasil.blindraces.dominio.Submit;
import com.speedrunsbrasil.blindraces.dominio.StatusSubmit;

public class SubmitDAO extends AbstractJdbcDAO {

	public SubmitDAO() {
		super("Submit", "idSubmit");
	}

	public int salvar(EntidadeDominio entidade) throws SQLException {
		
		abrirConexao();
		PreparedStatement pst=null;
		Submit submit = (Submit) entidade;
		
		int idSubmitInserido;
		JogoDAO jDAO = new JogoDAO();
		
		List<EntidadeDominio> lstRetorno = jDAO.consultar(submit.getJogo());		
		try {
			if(lstRetorno.size() == 0){
				Jogo jogo = submit.getJogo();
				int idInserida = jDAO.salvar(jogo);
				jogo.setId(idInserida);
				submit.setJogo(jogo);
			} else {
				Jogo jogo = (Jogo) lstRetorno.get(0);
				submit.setJogo(jogo);
			}
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO Submit (nickRunner, nickDiscord, fkJogo, objetivo, linkDownload, linkPastebin, estimativaMinutos, fkStatusSubmit) ");
			sql.append("VALUES (?,?,?,?,?,?,?,?) ");
			sql.append("RETURNING idSubmit ");
					
			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, submit.getRunner().getNickTwitch());
			pst.setString(2, submit.getRunner().getNameTagDiscord());
			pst.setInt(3, submit.getJogo().getId());
			pst.setString(4, submit.getObjetivo());
			pst.setString(5, submit.getLinkDownload());
			pst.setString(6, submit.getLinkPastebin());
			pst.setInt(7, submit.getEstimate());
			pst.setInt(8, StatusSubmit.PENDENTE.getCodigo());
			
			if (pst.execute()) {
				ResultSet rs = pst.getResultSet();
				rs.next();
				idSubmitInserido = rs.getInt(1);
			} else {
				idSubmitInserido = pst.getUpdateCount();
			}
			
			connection.commit();			
			return idSubmitInserido;
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

	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
