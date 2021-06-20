/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.UsuarioVO;

/**
 *
 * @author Medeiros
 */
public class UsuarioServicos {
    public void cadastarUsuario (UsuarioVO uVO) throws SQLException{
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.cadastrarUsuario(uVO);
    }
    public ArrayList<UsuarioVO> pesquisar() throws SQLException{
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.perquisar();
    }
    public void deletarUsuario(long id) throws SQLException{
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.deletarUsuario(id);
    }
    public ArrayList <UsuarioVO> filtrar (String query) throws SQLException{
       UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
       return uDAO.filtrar(query);
    }
    public void alterarUsuario(UsuarioVO uVO) throws SQLException{
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        uDAO.alterarUsuario(uVO);
    }
}
