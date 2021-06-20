/*
 * Classe respoonsável por instanciar automaticamente um novo cadastro de produtos
 */
package dao;

/**
 *
 * @author Medeiros
 */
public class DAOFactory {
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public static UsuarioDAO getUsuarioDAO(){
        return usuarioDAO;
    }
}
