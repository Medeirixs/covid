/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author Medeiros
 */
public class ServicosFactory {
        //Cria instância estática para que a messma nunca seja modificada ou receba interfacerências
    private static UsuarioServicos usuarioServicos = new UsuarioServicos();
    
    public static UsuarioServicos getUsuarioServicos(){
        return usuarioServicos;
    }
}
