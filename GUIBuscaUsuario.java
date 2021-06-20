/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UsuarioVO;
import servicos.UsuarioServicos;

/**
 *
 * @author Medeiros
 */
public class GUIBuscaUsuario extends javax.swing.JInternalFrame {
    
    DefaultTableModel dtm = new DefaultTableModel(

	new Object[][]{},
	new Object[]{"id, nome, endereço, cidade, estado, email, doenças, alergias, telefone, cpf, idade, sexo, peso, altura"}
    );

    public void preencherTabela(){
        
        try{
            UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
            ArrayList<UsuarioVO> user = new ArrayList<>();
		user = us.pesquisar();
                
                // Laço que percorre o Array List auxiliar e busca em cada linha preencher com dados de suas respectivas colunas.
                // Ou seja, retorna 1 produto por linha, dividido em colunas como "código, nome, valor custo, quantidade".
                for(int i=0; i<user.size(); i++){
                    dtm.addRow(new String[]{
                            String.valueOf(user.get(i).getId()),
                            String.valueOf(user.get(i).getIdade()),
                            String.valueOf(user.get(i).getSexo()),
                            String.valueOf(user.get(i).getPeso()),
                            String.valueOf(user.get(i).getAltura()),
                            String.valueOf(user.get(i).getEndereco()),
                            String.valueOf(user.get(i).getCidade()),
                            String.valueOf(user.get(i).getEstado()),
                            String.valueOf(user.get(i).getEmail()),
                            String.valueOf(user.get(i).getDoencas()),
                            String.valueOf(user.get(i).getAlergias()),
                            String.valueOf(user.get(i).getTelefone()),
                            String.valueOf(user.get(i).getCpf()),
                                    
                    });
        }//fecha o for
                jTableResultado.setModel(dtm);
    }catch(Exception e){
	
              JOptionPane.showMessageDialog(null, "Ops, algo deu errado! "+e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);  
            
	}
	
	}
    public void limparTabela(){
    dtm.setNumRows(0);
    }
    
    public void deletar(){
	try{
	int linha = jTableResultado.getSelectedRow();
	if(linha == -1){
		JOptionPane.showMessageDialog(null, "Você não selecionou uma linha para exclusão! ","Erro!", JOptionPane.ERROR_MESSAGE);
	}else{
		UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
		String idUsuario = (String) jTableResultado.getValueAt(linha, 0);
                
                int r = JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir este produto?","Confirmação", JOptionPane.WARNING_MESSAGE);
                
                if(r==JOptionPane.YES_OPTION){
		us.deletarUsuario(Long.parseLong(idUsuario));
                
                
                }else {
                  JOptionPane.showMessageDialog(null, "Sua exclusão não foi realizada! ","Erro!", JOptionPane.ERROR_MESSAGE);  
                }
                
            }

	}catch(Exception e){
	JOptionPane.showMessageDialog(null, "Ops, algo deu errado! "+e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);
	}
}
    
    
       public void filtrar(){
try{

if(jtfPesquisar.getText().isEmpty()){
preencherTabela();
}else{
UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
/* Buscando o valor da JComboBox. O método getSelectedItem
devolve um Object selecionado na JCombo */
String pesquisa = (String) jcbTipoDePesquisa.getSelectedItem();
// Variável que armazenará a pesquisa
String query = null;


// Testar o que o usuário selecionou para realizar a pesquisa no jComboBox

if(pesquisa.equals("Id do Usuário")){
query = "where userid = "+jtfPesquisar.getText();
}else if (pesquisa.equals("Nome Completo")){
    query = "where nome like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Endereço")){
    query = "where endereco like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Cidade")){
    query = "where cidade like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Estado")){
    query = "where estado like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Email")){
    query = "where email like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Idade")){
    query = "where idade like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("telefone")){
    query = "where telefone like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Cpf")){
    query = "where cpf like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("sexo")){
    query = "where seco like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Peso")){
    query = "where peso like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Altura")){
query = "where altura like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Alergias")){
query = "where alergias like '%"+jtfPesquisar.getText()+"%'";
}
else {
    query ="where doencas = '%"+jtfPesquisar.getText()+"%'";
}


ArrayList<UsuarioVO> user = new ArrayList<>();
		user = us.filtrar(query);
                
                // Laço que percorre o Array List auxiliar e busca em cada linha preencher com dados de suas respectivas colunas.
                // Ou seja, retorna 1 produto por linha, dividido em colunas como "código, nome, valor custo, quantidade".
                for(int i=0; i<user.size(); i++){
                    dtm.addRow(new String[]{
	                    String.valueOf(user.get(i).getId()),
                            String.valueOf(user.get(i).getIdade()),
                            String.valueOf(user.get(i).getSexo()),
                            String.valueOf(user.get(i).getPeso()),
                            String.valueOf(user.get(i).getAltura()),
                            String.valueOf(user.get(i).getEndereco()),
                            String.valueOf(user.get(i).getCidade()),
                            String.valueOf(user.get(i).getEstado()),
                            String.valueOf(user.get(i).getEmail()),
                            String.valueOf(user.get(i).getDoencas()),
                            String.valueOf(user.get(i).getAlergias()),
                            String.valueOf(user.get(i).getTelefone()),
                            String.valueOf(user.get(i).getCpf()),

                    });

                } // Fecha For
                jTableResultado.setModel(dtm);
}
}catch(Exception e){
JOptionPane.showMessageDialog(null, "Erro ao filtrar os dados! "+e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);
}


}// Fecha Filtrar 
       
       
    public void alterarDados(){
        int linha = jTableResultado.getSelectedRow();
        if(linha!= -1){
          jtfNomeCompletoAltera.setText((String)jTableResultado.getValueAt(linha,1));
          jtfAlturaAltera.setText((String)jTableResultado.getValueAt(linha,2));
          jtfAlergiasAltera.setText((String)jTableResultado.getValueAt(linha,3));
          jtfIdadeAltera.setText((String)jTableResultado.getValueAt(linha,4));
          jtfPesoAltera.setText((String)jTableResultado.getValueAt(linha,5));
          jtfCidadeAltera.setText((String)jTableResultado.getValueAt(linha, 6));
          jtfDoencasAltera.setText((String)jTableResultado.getValueAt(linha, 7));
          jtfEmailAltera.setText((String)jTableResultado.getValueAt(linha,8));
          jtfCpfAltera.setText((String)jTableResultado.getValueAt(linha, 9));
          jtfTelefoneAltera.setText((String)jTableResultado.getValueAt(linha, 10));
          jtfEnderecoAltera.setText((String)jTableResultado.getValueAt(linha,11));
        }else{
            JOptionPane.showMessageDialog(null, "Você não selecionou nenhumsa linha!");
        }
    }
    public void confirmarAlteracao(){
        try{
            UsuarioVO uVo = new UsuarioVO();
            uVo.setNome(jtfNomeCompletoAltera.getText());
            uVo.setAltura(Double.parseDouble(jtfAlturaAltera.getText()));
            uVo.setAlergias(jtfAlergiasAltera.getText());
            uVo.setIdade(jtfIdadeAltera.getText());
            uVo.setPeso(Integer.parseInt(jtfPesoAltera.getText()));
            uVo.setCidade(jtfCidadeAltera.getText());
            uVo.setDoencas(jtfDoencasAltera.getText());
            uVo.setEmail(jtfEmailAltera.getText());
            uVo.setCpf(Integer.parseInt(jtfCpfAltera.getText()));
            uVo.setTelefone(Integer.parseInt(jtfTelefoneAltera.getText()));
            uVo.setEndereco(jtfEnderecoAltera.getText());
            
            UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
            us.alterarUsuario(uVo);
            JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
        }catch(SQLException e ){
                JOptionPane.showMessageDialog(null, "Ops! Ocorreu um erro na alteração"+e.getMessage());
        }
    }   
    public void cancelar(){
        jtfNomeCompletoAltera.setText(null);
        jtfAlturaAltera.setText(null);
        jtfAlergiasAltera.setText(null);
        jtfIdadeAltera.setText(null);
        jtfPesoAltera.setText(null);
        jtfCidadeAltera.setText(null);
        jtfDoencasAltera.setText(null);
        jtfEmailAltera.setText(null);
        jtfCpfAltera.setText(null);
        jtfTelefoneAltera.setText(null);
        jtfEnderecoAltera.setText(null);
    
}
    public GUIBuscaUsuario() {
        initComponents();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTop = new javax.swing.JPanel();
        jlTituloPrincipal = new javax.swing.JLabel();
        jlTituloAdmin = new javax.swing.JLabel();
        jPanelPesquisarUsuario = new javax.swing.JPanel();
        jlTituloPesquisar = new javax.swing.JLabel();
        jlPesquisar = new javax.swing.JLabel();
        jtfAlturaAltera = new javax.swing.JTextField();
        jcbTipoDePesquisa = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultado = new javax.swing.JTable();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbConfirmarAlteracao = new javax.swing.JButton();
        jlNomeCompleto = new javax.swing.JLabel();
        jlIdade = new javax.swing.JLabel();
        jlPeso = new javax.swing.JLabel();
        jlAltura = new javax.swing.JLabel();
        jlAlergias = new javax.swing.JLabel();
        jlDoencas = new javax.swing.JLabel();
        jtfPesquisar = new javax.swing.JTextField();
        jtfAlergiasAltera = new javax.swing.JTextField();
        jtfIdadeAltera = new javax.swing.JTextField();
        jtfPesoAltera = new javax.swing.JTextField();
        jtfCidadeAltera = new javax.swing.JTextField();
        jtfDoencasAltera = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfEmailAltera = new javax.swing.JTextField();
        jlCidade = new javax.swing.JLabel();
        jlEndereco = new javax.swing.JLabel();
        jlTelefone = new javax.swing.JLabel();
        jlCpf = new javax.swing.JLabel();
        jtfNomeCompletoAltera = new javax.swing.JTextField();
        jtfCpfAltera = new javax.swing.JTextField();
        jtfTelefoneAltera = new javax.swing.JTextField();
        jtfEnderecoAltera = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(600, 500));

        jpTop.setBackground(new java.awt.Color(47, 85, 123));

        jlTituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jlTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        jlTituloPrincipal.setText("APP COVID 19");

        jlTituloAdmin.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlTituloAdmin.setForeground(new java.awt.Color(255, 255, 255));
        jlTituloAdmin.setText("Sistema de Administração");

        javax.swing.GroupLayout jpTopLayout = new javax.swing.GroupLayout(jpTop);
        jpTop.setLayout(jpTopLayout);
        jpTopLayout.setHorizontalGroup(
            jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTituloPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTituloAdmin)
                .addContainerGap())
        );
        jpTopLayout.setVerticalGroup(
            jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloPrincipal)
                    .addComponent(jlTituloAdmin))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelPesquisarUsuario.setBackground(new java.awt.Color(195, 213, 231));
        jPanelPesquisarUsuario.setForeground(new java.awt.Color(0, 0, 0));

        jlTituloPesquisar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlTituloPesquisar.setForeground(new java.awt.Color(47, 85, 123));
        jlTituloPesquisar.setText("Pesquisar Usuários");

        jlPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        jlPesquisar.setText("Pesquisar por:");

        jtfAlturaAltera.setPreferredSize(new java.awt.Dimension(80, 24));

        jcbTipoDePesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id do Usuário", "Nome Completo", "Data de Nascimento", "Peso", "Altura", "Email", "Alergias", "Doenças" }));
        jcbTipoDePesquisa.setPreferredSize(new java.awt.Dimension(200, 24));
        jcbTipoDePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoDePesquisaActionPerformed(evt);
            }
        });

        jTableResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        jScrollPane1.setViewportView(jTableResultado);

        jbAlterar.setBackground(new java.awt.Color(47, 85, 123));
        jbAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jbAlterar.setText("Alterar");
        jbAlterar.setPreferredSize(new java.awt.Dimension(100, 26));
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setBackground(new java.awt.Color(47, 85, 123));
        jbExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jbExcluir.setText("Excluir");
        jbExcluir.setPreferredSize(new java.awt.Dimension(100, 26));
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbConfirmarAlteracao.setBackground(new java.awt.Color(47, 85, 123));
        jbConfirmarAlteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbConfirmarAlteracao.setForeground(new java.awt.Color(255, 255, 255));
        jbConfirmarAlteracao.setText("Confirmar Alteração");
        jbConfirmarAlteracao.setPreferredSize(new java.awt.Dimension(160, 26));
        jbConfirmarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarAlteracaoActionPerformed(evt);
            }
        });

        jlNomeCompleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlNomeCompleto.setForeground(new java.awt.Color(0, 0, 0));
        jlNomeCompleto.setText("Nome Completo:");

        jlIdade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlIdade.setForeground(new java.awt.Color(0, 0, 0));
        jlIdade.setText("Idade:");

        jlPeso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlPeso.setForeground(new java.awt.Color(0, 0, 0));
        jlPeso.setText("Peso:");

        jlAltura.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlAltura.setForeground(new java.awt.Color(0, 0, 0));
        jlAltura.setText("Altura:");

        jlAlergias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlAlergias.setForeground(new java.awt.Color(0, 0, 0));
        jlAlergias.setText("Alergias:");

        jlDoencas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlDoencas.setForeground(new java.awt.Color(0, 0, 0));
        jlDoencas.setText("Doenças:");

        jtfPesquisar.setPreferredSize(new java.awt.Dimension(250, 24));
        jtfPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisarActionPerformed(evt);
            }
        });
        jtfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisarKeyReleased(evt);
            }
        });

        jtfAlergiasAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfIdadeAltera.setPreferredSize(new java.awt.Dimension(80, 24));
        jtfIdadeAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdadeAlteraActionPerformed(evt);
            }
        });

        jtfPesoAltera.setPreferredSize(new java.awt.Dimension(80, 24));

        jtfCidadeAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfDoencasAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jlEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlEmail.setForeground(new java.awt.Color(0, 0, 0));
        jlEmail.setText("E-mail:");

        jtfEmailAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jlCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlCidade.setForeground(new java.awt.Color(0, 0, 0));
        jlCidade.setText("Cidade:");

        jlEndereco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlEndereco.setForeground(new java.awt.Color(0, 0, 0));
        jlEndereco.setText("Endereço:");

        jlTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlTelefone.setForeground(new java.awt.Color(0, 0, 0));
        jlTelefone.setText("Telefone:");

        jlCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlCpf.setForeground(new java.awt.Color(0, 0, 0));
        jlCpf.setText("CPF:");

        jtfNomeCompletoAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfCpfAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfTelefoneAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfEnderecoAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        javax.swing.GroupLayout jPanelPesquisarUsuarioLayout = new javax.swing.GroupLayout(jPanelPesquisarUsuario);
        jPanelPesquisarUsuario.setLayout(jPanelPesquisarUsuarioLayout);
        jPanelPesquisarUsuarioLayout.setHorizontalGroup(
            jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                .addComponent(jlPesquisar)
                                .addGap(52, 52, 52)
                                .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlTituloPesquisar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                        .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                                .addComponent(jlNomeCompleto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfNomeCompletoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)
                                                .addComponent(jlCidade)
                                                .addGap(27, 27, 27))
                                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                                .addGap(165, 165, 165)
                                                .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)
                                                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(190, 190, 190)))
                                        .addComponent(jtfCidadeAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlEmail)
                                            .addComponent(jlIdade))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                                .addComponent(jtfEmailAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(jlDoencas))
                                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                                .addComponent(jtfIdadeAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlPeso)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfPesoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(jlAltura)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                                .addComponent(jtfAlturaAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jlEndereco)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfEnderecoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                                .addComponent(jtfDoencasAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jlAlergias)
                                                .addGap(12, 12, 12)))))
                                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfAlergiasAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                                .addComponent(jlTelefone)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfTelefoneAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                                .addComponent(jlCpf)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfCpfAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                .addGap(511, 511, 511)
                                .addComponent(jcbTipoDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jbConfirmarAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanelPesquisarUsuarioLayout.setVerticalGroup(
            jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTituloPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPesquisar)
                    .addComponent(jcbTipoDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNomeCompleto)
                    .addComponent(jtfCidadeAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNomeCompletoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCidade)
                    .addComponent(jlTelefone)
                    .addComponent(jtfTelefoneAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlAltura, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfIdadeAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlIdade)
                        .addComponent(jlPeso)
                        .addComponent(jtfPesoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfAlturaAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlEndereco)
                        .addComponent(jlCpf)
                        .addComponent(jtfCpfAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfEnderecoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEmailAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEmail)
                    .addComponent(jlAlergias)
                    .addComponent(jtfDoencasAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDoencas)
                    .addComponent(jtfAlergiasAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbConfirmarAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPesquisarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPesquisarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIdadeAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdadeAlteraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdadeAlteraActionPerformed

    private void jcbTipoDePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoDePesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoDePesquisaActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
       deletar();
       limparTabela();
       preencherTabela();
       JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!","Confirmação", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbConfirmarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarAlteracaoActionPerformed
         confirmarAlteracao();
         cancelar();
         limparTabela();
         preencherTabela();
         jbConfirmarAlteracao.setEnabled(false);
    }//GEN-LAST:event_jbConfirmarAlteracaoActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        jbConfirmarAlteracao.setEnabled(true);
        alterarDados();
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jtfPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisarActionPerformed
        
    }//GEN-LAST:event_jtfPesquisarActionPerformed

    private void jtfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisarKeyReleased
        // limparTabela();
        filtrar();
    }//GEN-LAST:event_jtfPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelPesquisarUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultado;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbConfirmarAlteracao;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox<String> jcbTipoDePesquisa;
    private javax.swing.JLabel jlAlergias;
    private javax.swing.JLabel jlAltura;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlDoencas;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlIdade;
    private javax.swing.JLabel jlNomeCompleto;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlPesquisar;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JLabel jlTituloAdmin;
    private javax.swing.JLabel jlTituloPesquisar;
    private javax.swing.JLabel jlTituloPrincipal;
    private javax.swing.JPanel jpTop;
    private javax.swing.JTextField jtfAlergiasAltera;
    private javax.swing.JTextField jtfAlturaAltera;
    private javax.swing.JTextField jtfCidadeAltera;
    private javax.swing.JTextField jtfCpfAltera;
    private javax.swing.JTextField jtfDoencasAltera;
    private javax.swing.JTextField jtfEmailAltera;
    private javax.swing.JTextField jtfEnderecoAltera;
    private javax.swing.JTextField jtfIdadeAltera;
    private javax.swing.JTextField jtfNomeCompletoAltera;
    private javax.swing.JTextField jtfPesoAltera;
    private javax.swing.JTextField jtfPesquisar;
    private javax.swing.JTextField jtfTelefoneAltera;
    // End of variables declaration//GEN-END:variables
}
