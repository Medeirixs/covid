/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;

import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.Conexao;

/**
 *
 * @author Medeiros
 */
public class GUITelaCadastro extends javax.swing.JInternalFrame {
    
    model.UsuarioVO uc = new model.UsuarioVO();
    public void cadastrar() throws SQLException{
        //Connection con = Conexao.getConexao();
        //busca conexao com o BD
        
        //Statement stat = con.createStatement();
        try{
            model.UsuarioVO u = new model.UsuarioVO();
        if(String.valueOf(jcbIdade.getSelectedItem()).equals("Informe sua idade")){
          JOptionPane.showMessageDialog(null, "Você precisa selecionar uma idade");
        }else{
        uc.setNome(jtfNome.getText());
        uc.setIdade(String.valueOf(jcbIdade.getSelectedItem()));
        uc.setSexo(buttonGroupSexo.getSelection().getActionCommand());
        uc.setPeso(Integer.parseInt(jtfPeso.getText()));
        uc.setAltura(Double.parseDouble(jtfAltura.getText()));
        uc.setEndereco(jtfEndereco.getText());
        uc.setCidade(jtfCidade.getText());
        uc.setEstado(String.valueOf(jcbEstados.getSelectedItem()));
        uc.setEmail(jtfEmail.getText());
        uc.setDoencas(textAreaDoenca.getText());
        uc.setAlergias(textAreaAlergia.getText());
        uc.setTelefone(Integer.parseInt(jtfTelefone.getText()));
        uc.setCpf(Integer.parseInt(jtfCpf.getText()));

        
        servicos.UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
        us.cadastarUsuario(u);
        
        }  
        JOptionPane.showMessageDialog(null, "Dados cadastrados: "+uc, "Cadastros", JOptionPane.INFORMATION_MESSAGE);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Ops, algo deu errado!"+e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);
    }
    }
    public void restaurar(){
        jtfNome.setText(null);
        jtfPeso.setText(null);
        jtfAltura.setText(null);
        jtfEndereco.setText(null);
        jtfCidade.setText(null);
        jtfEmail.setText(null);
        textAreaDoenca.setText(null);
        textAreaAlergia.setText(null);
        jtfTelefone.setText(null);
        jtfCpf.setText(null);
    }
    public GUITelaCadastro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jlSubtitulo = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jlPeso = new javax.swing.JLabel();
        jtfPeso = new javax.swing.JTextField();
        jlAltura = new javax.swing.JLabel();
        jtfAltura = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jlIdade = new javax.swing.JLabel();
        jlAlergias = new javax.swing.JLabel();
        jlDoenca = new javax.swing.JLabel();
        textAreaAlergia = new java.awt.TextArea();
        textAreaDoenca = new java.awt.TextArea();
        jbCadastrar = new javax.swing.JButton();
        jbRestaurar = new javax.swing.JButton();
        jlEndereço = new javax.swing.JLabel();
        jlCpf = new javax.swing.JLabel();
        jrbFemea = new javax.swing.JRadioButton();
        jrbMacho = new javax.swing.JRadioButton();
        jrbPrefiroNaoResponder = new javax.swing.JRadioButton();
        jtfEndereco = new javax.swing.JTextField();
        jlCidade = new javax.swing.JLabel();
        jtfCidade = new javax.swing.JTextField();
        jcbEstados = new javax.swing.JComboBox<>();
        jlEstado = new javax.swing.JLabel();
        telefone = new javax.swing.JLabel();
        jtfTelefone = new javax.swing.JTextField();
        jlSexo1 = new javax.swing.JLabel();
        jtfCpf = new javax.swing.JTextField();
        jcbIdade = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(47, 85, 123));
        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel1.setBackground(new java.awt.Color(195, 213, 231));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 480));

        jlTitulo.setBackground(new java.awt.Color(47, 85, 123));
        jlTitulo.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(47, 85, 123));
        jlTitulo.setText("SISTEMA DE AUXÍLIO DA PREVENÇÃO E COMBATE AO COIVD-19");
        jlTitulo.setFocusTraversalPolicyProvider(true);

        jlSubtitulo.setBackground(new java.awt.Color(47, 85, 123));
        jlSubtitulo.setFont(new java.awt.Font("Gill Sans MT", 1, 11)); // NOI18N
        jlSubtitulo.setForeground(new java.awt.Color(47, 85, 123));
        jlSubtitulo.setText("CADASTRO DE NOVO USUÁRIO");

        jlNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlNome.setForeground(new java.awt.Color(47, 85, 123));
        jlNome.setText("Nome:");

        jtfNome.setBackground(new java.awt.Color(47, 85, 123));
        jtfNome.setForeground(new java.awt.Color(255, 255, 255));
        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });

        jlPeso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlPeso.setForeground(new java.awt.Color(47, 85, 123));
        jlPeso.setText("Peso:");

        jtfPeso.setBackground(new java.awt.Color(47, 85, 123));
        jtfPeso.setForeground(new java.awt.Color(255, 255, 255));

        jlAltura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlAltura.setForeground(new java.awt.Color(47, 85, 123));
        jlAltura.setText("Altura:");

        jtfAltura.setBackground(new java.awt.Color(47, 85, 123));
        jtfAltura.setForeground(new java.awt.Color(255, 255, 255));

        jlEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlEmail.setForeground(new java.awt.Color(47, 85, 123));
        jlEmail.setText("Email:");

        jtfEmail.setBackground(new java.awt.Color(47, 85, 123));
        jtfEmail.setForeground(new java.awt.Color(255, 255, 255));
        jtfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEmailActionPerformed(evt);
            }
        });

        jlIdade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlIdade.setForeground(new java.awt.Color(47, 85, 123));
        jlIdade.setText("Idade:");

        jlAlergias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlAlergias.setForeground(new java.awt.Color(0, 0, 0));
        jlAlergias.setText("Alergias:");

        jlDoenca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlDoenca.setForeground(new java.awt.Color(0, 0, 0));
        jlDoenca.setText("Doenças:");

        textAreaAlergia.setBackground(new java.awt.Color(47, 85, 123));
        textAreaAlergia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        textAreaAlergia.setForeground(new java.awt.Color(255, 255, 255));

        textAreaDoenca.setBackground(new java.awt.Color(47, 85, 123));
        textAreaDoenca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        textAreaDoenca.setForeground(new java.awt.Color(255, 255, 255));

        jbCadastrar.setBackground(new java.awt.Color(47, 85, 123));
        jbCadastrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jbCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbRestaurar.setBackground(new java.awt.Color(47, 85, 123));
        jbRestaurar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jbRestaurar.setForeground(new java.awt.Color(255, 255, 255));
        jbRestaurar.setText("Restaurar");
        jbRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRestaurarActionPerformed(evt);
            }
        });

        jlEndereço.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlEndereço.setForeground(new java.awt.Color(47, 85, 123));
        jlEndereço.setText("Endereço:");

        jlCpf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlCpf.setForeground(new java.awt.Color(47, 85, 123));
        jlCpf.setText("Cpf:");

        jrbFemea.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroupSexo.add(jrbFemea);
        jrbFemea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrbFemea.setForeground(new java.awt.Color(47, 85, 123));
        jrbFemea.setText("Femenino");
        jrbFemea.setActionCommand("Femenino");
        jrbFemea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFemeaActionPerformed(evt);
            }
        });

        jrbMacho.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroupSexo.add(jrbMacho);
        jrbMacho.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrbMacho.setForeground(new java.awt.Color(47, 85, 123));
        jrbMacho.setSelected(true);
        jrbMacho.setText("Masculino");
        jrbMacho.setActionCommand("Masculino");

        jrbPrefiroNaoResponder.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroupSexo.add(jrbPrefiroNaoResponder);
        jrbPrefiroNaoResponder.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrbPrefiroNaoResponder.setForeground(new java.awt.Color(47, 85, 123));
        jrbPrefiroNaoResponder.setText("Prefiro não responder");
        jrbPrefiroNaoResponder.setPreferredSize(new java.awt.Dimension(148, 18));

        jtfEndereco.setBackground(new java.awt.Color(47, 85, 123));
        jtfEndereco.setForeground(new java.awt.Color(255, 255, 255));

        jlCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlCidade.setForeground(new java.awt.Color(47, 85, 123));
        jlCidade.setText("Cidade:");

        jtfCidade.setBackground(new java.awt.Color(47, 85, 123));
        jtfCidade.setForeground(new java.awt.Color(255, 255, 255));

        jcbEstados.setBackground(new java.awt.Color(47, 85, 123));
        jcbEstados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbEstados.setForeground(new java.awt.Color(255, 255, 255));
        jcbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um estado:", "AC - Acre ", "AL - Alagoas", "AP - Amapá", "AM - Amazonas ", "BA - Bahia", "CE- Ceará", "DF - Distrito Federal", "ES - Espírito Santo", "GO - Goiás", "MA - Maranhão", "MT - Mato Grosso", "MS - Mato Grosso do Sul", "MG - Minas Gerais", "PA - Par", "PB - Paraíba", "PR- Paraná ", "PE - Pernambuco", "PI - Piauí", "RR - Roraima", "RO - Rondônia", "RJ - Rio de Janeiro", "RN - Rio Grande do Norte", "RS - Rio Grande do Sul ", "SC - Santa Catarina", "SP - São Paulo ", "SE - Sergipe", "TO - Tocantins" }));

        jlEstado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlEstado.setForeground(new java.awt.Color(47, 85, 123));
        jlEstado.setText("Estado");

        telefone.setBackground(new java.awt.Color(51, 255, 51));
        telefone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        telefone.setForeground(new java.awt.Color(47, 85, 123));
        telefone.setText("Telefone:");

        jtfTelefone.setBackground(new java.awt.Color(47, 85, 123));
        jtfTelefone.setForeground(new java.awt.Color(255, 255, 255));

        jlSexo1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlSexo1.setForeground(new java.awt.Color(47, 85, 123));
        jlSexo1.setText("Sexo:");

        jtfCpf.setBackground(new java.awt.Color(47, 85, 123));
        jtfCpf.setForeground(new java.awt.Color(255, 255, 255));

        jcbIdade.setBackground(new java.awt.Color(47, 85, 123));
        jcbIdade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbIdade.setForeground(new java.awt.Color(255, 255, 255));
        jcbIdade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Informe sua idade", "1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8", "9 ", "10 ", "11", "12 ", "13 ", "14 ", "15 ", "16 ", "17 ", "18 ", "19 ", "20 ", "21 ", "22 ", "23 ", "24 ", "25 ", "26 ", "27 ", "28 ", "29 ", "30 ", "31", "32", "33 ", "34 ", "35 ", "36 ", "37 ", "38 ", "39 ", "40 ", "41 ", "42 ", "43 ", "44 ", "45 ", "46 ", "47 ", "48", "49 ", "50 ", "51 ", "52 ", "53 ", "54 ", "55 ", "56 ", "57 ", "58 ", "59 ", "60 ", "61 ", "62 ", "63 ", "64 ", "65 ", "66 ", "67 ", "68 ", "69 ", "70", "71", "72 ", "73 ", "74 ", "75 ", "76 ", "77 ", "78 ", "79 ", "80 ", "81 ", "82 ", "83 ", "84 ", "85 ", "86", "87 ", "88 ", "89 ", "90 ", "91 ", "92 ", "93 ", "94 ", "95 ", "96 ", "97 ", "98 ", "99 ", "100" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jlAlergias))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlNome)
                                .addComponent(jlCpf)
                                .addComponent(jlSexo1)
                                .addComponent(jlPeso)
                                .addComponent(jlIdade))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlAltura)
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbMacho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbFemea))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrbPrefiroNaoResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(telefone)
                                            .addComponent(jlEmail))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlEndereço)
                                            .addComponent(jlEstado)
                                            .addComponent(jlCidade))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jcbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtfCidade)
                                                .addComponent(jtfEndereco))
                                            .addComponent(jlDoenca)
                                            .addComponent(textAreaDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlSubtitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jlTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(textAreaAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jbRestaurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCadastrar)
                        .addGap(61, 61, 61)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlAltura))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlSubtitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlEmail)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlCpf)
                                        .addGap(18, 18, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(telefone)
                                            .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlSexo1)
                                    .addComponent(jrbMacho, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrbFemea, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jrbPrefiroNaoResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlCidade))
                                .addGap(0, 0, 0)
                                .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPeso)
                    .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdade)
                    .addComponent(jcbIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEndereço)
                    .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDoenca, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlAlergias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textAreaAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAreaDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbRestaurar))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRestaurarActionPerformed
        restaurar();
    }//GEN-LAST:event_jbRestaurarActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        try {
            cadastrar();
        } catch (SQLException ex) {
            Logger.getLogger(GUITelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jrbFemeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFemeaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbFemeaActionPerformed

    private void jtfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailActionPerformed

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbRestaurar;
    private javax.swing.JComboBox<String> jcbEstados;
    private javax.swing.JComboBox<String> jcbIdade;
    private javax.swing.JLabel jlAlergias;
    private javax.swing.JLabel jlAltura;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlDoenca;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEndereço;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlIdade;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlSexo1;
    private javax.swing.JLabel jlSubtitulo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JRadioButton jrbFemea;
    private javax.swing.JRadioButton jrbMacho;
    private javax.swing.JRadioButton jrbPrefiroNaoResponder;
    private javax.swing.JTextField jtfAltura;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfCpf;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JTextField jtfTelefone;
    private javax.swing.JLabel telefone;
    private java.awt.TextArea textAreaAlergia;
    private java.awt.TextArea textAreaDoenca;
    // End of variables declaration//GEN-END:variables
}
