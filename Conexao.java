/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Medeiros
 */
public class Conexao {
    //cria uma constante com endereçamento de base de dados no conector com mysql
    private static String URL = "jdbc:mysql://localhost:3306/covid";
   // cria uma constante para determinar usuario predefinido no banco de dados
    private static String USUARIO ="root";
   //cria uam constante para determinar a senha do usuario 
    private static String SENHA = "";
    
    //metodo que estabelece a conecxao com o banco de dados
   public static Connection getConexao() throws SQLException{
       Connection c = null;
       //tenta estabelecer conexão
       try{
           c= DriverManager.getConnection(URL, USUARIO, SENHA);
       //caso a tentativa tenha sido falha, gera uma exceção   
       }catch(SQLException e){
           throw new SQLException("Erro ao conectar", e.getMessage());   
       }
       return c;
   }
}
