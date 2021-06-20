/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.UsuarioVO;
import persistencia.Conexao;

/**
 *
 * @author Medeiros
 */
public class UsuarioDAO {
    public void cadastrarUsuario (UsuarioVO uVO) throws SQLException{
        Connection con = Conexao.getConexao();
        //busca conexao com o BD
        
        Statement stat = con.createStatement();
        //cira um objeto 'stat' responsável por enviar os 
        //comandos java para serem executados dentro do BD
        try{
            String sql;
            sql = "insert into usuarios (id, nome, endereco, cidade, estado, email, doencas, alergias, telefone, cpf, idade, sexo, peso, altura)values"+"(null,'"+uVO.getNome()+"','"+uVO.getEndereco()+"','"+uVO.getCidade()+"','"+uVO.getEstado()+"','"+uVO.getEmail()+"','"+uVO.getDoencas()+"','"+uVO.getAlergias()+"',"+uVO.getTelefone()+","+uVO.getCpf()+",'"+uVO.getIdade()+"',"+uVO.getSexo()+","+uVO.getPeso()+","+uVO.getAltura()+");";
            stat.execute(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao inserir dados"+e.getMessage());
        }finally{
            stat.close();
            con.close();
        }
    }
    
    public ArrayList<UsuarioVO> perquisar() throws SQLException{
        Connection con= Conexao.getConexao();
        Statement stat = con.createStatement();
        try{
            String sql;
            sql="select * from usuario";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<UsuarioVO> usu = new ArrayList<>();
            
            while(rs.next()){
                UsuarioVO u = new UsuarioVO();
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setEndereco(rs.getString("endereco"));
                u.setCidade(rs.getString("cidade"));
                u.setEstado(rs.getString("estado"));
                u.setEmail(rs.getString("email"));
                u.setDoencas(rs.getString("doencas"));
                u.setAlergias(rs.getString("alergias"));
                u.setTelefone(rs.getInt("telefone"));
                u.setCpf(rs.getInt("cpf"));
                u.setIdade(rs.getString("idade"));
                u.setSexo(rs.getString("sexo"));
                u.setPeso(rs.getInt("peso"));
                u.setAltura(rs.getDouble("altura"));
                
                usu.add(u);                
            }
            return usu;
        }catch(SQLException e){
            throw new SQLException("Erro ao pesquisar os dados"+e.getMessage());
        }finally{
            con.close();
            stat.close();
        }
    }
    public void deletarUsuario (long id)  throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta= con.createStatement();
        try{
            String sql;
            sql="delette from produto where id+"+id;
                sta.execute(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao buscar dados no banco"+e.getMessage());
        }finally{
            con.close();
            sta.close();
        }
    }
    public ArrayList<UsuarioVO> filtrar(String query)throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
        try{
            String sql;
            sql = "select * from produto"+query;
            ResultSet rs = sta.executeQuery(sql);
            ArrayList<UsuarioVO> usu = new ArrayList<>();
            
            while(rs.next()){
                UsuarioVO u = new UsuarioVO();
                u.setId(rs.getLong("id")); 
                u.setNome(rs.getString("nome"));
                u.setEndereco(rs.getString("endereco"));
                u.setCidade(rs.getString("cidade"));
                u.setEstado(rs.getString("estado"));
                u.setEmail(rs.getString("email"));
                u.setDoencas(rs.getString("doencas"));
                u.setAlergias(rs.getString("alergias"));
                u.setTelefone(rs.getInt("telefone"));
                u.setCpf(rs.getInt("cpf"));
                u.setIdade(rs.getString("idade"));
                u.setSexo(rs.getString("sexo"));
                u.setPeso(rs.getInt("peso"));
                u.setAltura(rs.getDouble("altura"));
                
                usu.add(u);
            }return usu;
        }catch (SQLException e){
            throw new SQLException("Erro ao pesquisar dados no banco"+e.getMessage());
        }finally{
            con.close();
            sta.close();
        }
    }
    public void alterarUsuario(UsuarioVO uVO) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement sta = con. createStatement();
        try{
            String sql;
            sql = "update usuario set nome = '"+uVO.getNome()+"', endereco = "+uVO.getEndereco()+", cidade = '"+uVO.getCidade()+"', estado = '"+uVO.getEstado()+"', email = '"+uVO.getEmail()+"', doencas = '"+uVO.getDoencas()+"', alergias = '"+uVO.getAlergias()+"', telefone = "+uVO.getTelefone()+", cpf = "+uVO.getCpf()+", idade = '"+uVO.getIdade()+"', sexo = "+uVO.getSexo()+", peso = "+uVO.getPeso()+", altura = "+uVO.getAltura()+"where id = "+uVO.getId();
            
            sta.executeUpdate(sql);
        }catch(SQLException e){
            throw new SQLException("Erro ao atualizar os dados do banco"+e.getMessage());
        }finally{
            con.close();
            sta.close();
        }
    }
}
