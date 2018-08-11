package com.speedrunsbrasil.blindraces.core.dao;

import java.sql.SQLException;
import java.util.List;
import com.speedrunsbrasil.blindraces.dominio.EntidadeDominio;

public interface IDAO {
	public int salvar(EntidadeDominio entidade) throws SQLException;
	public void alterar(EntidadeDominio entidade)throws SQLException;
	public void excluir(EntidadeDominio entidade)throws SQLException;
	public List<EntidadeDominio> consultar(EntidadeDominio entidade)throws SQLException;

}
