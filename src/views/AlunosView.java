/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.AlunoController;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import ferramentas.Formatacao;
import ferramentas.Global;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.text.MaskFormatter;
import model.Aluno;
import ferramentas.*;

/**
 *
 * @author Windows
 */
public class AlunosView extends javax.swing.JFrame {

    /**
     * Creates new form AlunosView
     */
    
    Combos cbCurso;
    Aluno objAluno;
    String wData;
    
    public AlunosView() {
        initComponents();
        
        this.getContentPane().setBackground(Color.WHITE);

        
        try{
            
            //carregar os alunos existentes
            atualizarTabela();
            
            //carregar a quantidade de alunos
            atualizarQtdeAlunos();
            
            //carregar os cursos existentes
            cbCurso = new Combos(jcbCursos);
            cbCurso.PreencheCombo("SELECT cod_curso, nom_curso FROM cursos ORDER BY nom_curso");
            
            limparTela();
               
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbCursos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbAlunos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblAlunos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnIncluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnLimparTela = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Alunos");

        lblMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMatricula.setText("Matrícula");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("E-mail");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Curso");

        jcbCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtbAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3"
            }
        ));
        jtbAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbAlunosMouseClicked(evt);
            }
        });
        jtbAlunos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbAlunosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtbAlunos);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lista dos alunos cadastrados");

        lblAlunos.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblAlunos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlunos.setText("Alunos");

        btnIncluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sign-add.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Data de Nascimento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total:");

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sign-delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pencil.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnLimparTela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimparTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/device-computer.png"))); // NOI18N
        btnLimparTela.setText("Limpar Tela");
        btnLimparTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMatricula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparTela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbCursos, javax.swing.GroupLayout.Alignment.LEADING, 0, 159, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtData, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnLimparTela, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbAlunosMouseClicked
        // TODO add your handling code here:
         //pega a linha selecionada
        int linhaSelecionada = jtbAlunos.getSelectedRow();
        // Primeira coluna da linha
        String coluna1 = jtbAlunos.getModel().getValueAt(linhaSelecionada, 0).toString();

        //basta agora chamar o método buscar, passando o COLUNA1 como parâmetro de consulta
        AlunoController objAlunoCon = new AlunoController(null, null);
        objAluno = objAlunoCon.buscar(coluna1);
        
        preencheCampos();
    }//GEN-LAST:event_jtbAlunosMouseClicked

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
       try{
          if(validarDados() == true){
            //PREENCHE O OBJETO ALUNO
            guardarDados();  
            
            AlunoController objAlunoCon = new AlunoController(objAluno, null);
            if(objAlunoCon.incluir() == true){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Aluno incluído com Sucesso!");
                atualizarTabela();
                atualizarQtdeAlunos(); 
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir aluno!");
                return;
            }
            
             limparTela();
             
            }  

       }catch (Exception ex) {
          CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
       }

    }//GEN-LAST:event_btnIncluirActionPerformed

    private void jtbAlunosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbAlunosKeyReleased
        // TODO add your handling code here:
          //pega a linha selecionada
        int linhaSelecionada = jtbAlunos.getSelectedRow();
        // Primeira coluna da linha
        String coluna1 = jtbAlunos.getModel().getValueAt(linhaSelecionada, 0).toString();

        //basta agora chamar o método buscar, passando o COLUNA1 como parâmetro de consulta
        AlunoController objAlunoCon = new AlunoController(null, null);
        objAluno = objAlunoCon.buscar(coluna1);
        
        preencheCampos();
        
    }//GEN-LAST:event_jtbAlunosKeyReleased

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
          try{
            if (validarLinha()== true && validarDados()== true){
                guardarDados();
                
                AlunoController objAlunoCon = new AlunoController(objAluno, null);
                if(objAlunoCon.alterar() == true){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Aluno alterado com Sucesso!");
                    atualizarTabela();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar aluno!");
                }

                limparTela();

            }
            
         }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }                      
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        if (validarLinha() == true) {
        boolean resposta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Você realmente deseja remover este aluno?","Remover", 'p');
            if (resposta == true) {
                 String matricula = txtMatricula.getText();
                 AlunoController objAlunoCon = new AlunoController(null, null);
                 try {
                    if(objAlunoCon.excluir(matricula) == true){
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Aluno removido com Sucesso!");
                        atualizarTabela();
                        atualizarQtdeAlunos();   
                    }else{
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao remover aluno!");
                        return;
                     }

                    limparTela();

                } catch (Exception ex) {
                     CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                  }

               } else {
                return;
           }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTelaActionPerformed
        // TODO add your handling code here:
        limparTela();
    }//GEN-LAST:event_btnLimparTelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlunosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlunosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlunosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlunosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlunosView().setVisible(true);
            }
        });
    }
    
    private boolean validarDados(){
        try {
            
           wData = txtData.getText().toString(); 
           
           if (
           (!txtMatricula.getText().trim().equals("")) && 
           (!txtNome.getText().trim().equals("")) &&  
           (!txtEmail.getText().trim().equals("")) && 
           (!txtData.getText().trim().equals("")) &&
           (jcbCursos.getSelectedIndex() != 0) &&
           (Global.dataValida(wData) == true)) {         
           return true;
           
          } else{
            CaixaDeDialogo.obterinstancia().exibirMensagem("Preencha os dados corretamemte!", "Erro", 'e');
           return false;
           }
           
        } catch (Exception ex) {
         CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
         return false;
        } 
    }
            
     private void limparTela() {
         try{
          //LIMPAR OS CAMPOS DA TELA
          
          txtMatricula.setText("");
          txtNome.setText("");
          txtEmail.setText("");
          txtData.setText("");
          cbCurso.SetaComboBox("");
          
          //LIBERAR O CAMPO MATRICULA
          txtMatricula.setEditable(true);
          
          //DESELECIONAR LINHA DA TABELA
          jtbAlunos.getSelectionModel().clearSelection();
          
          //COLOCAR FOCO NO CAMPO MATRÍCULA
          txtMatricula.grabFocus();
          
          //Formata o campo data de nascimento
          Formatacao.colocaMascara(txtData, "##/##/####");
          
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
      
     private void atualizarQtdeAlunos () {
        try{ 
            AlunoController alunoCon = new AlunoController(null, jtbAlunos);
            txtTotal.setText(String.valueOf(alunoCon.QuantidadeAlunos()));
            txtTotal.setEditable(false);
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
     private void atualizarTabela(){
        try{   
            AlunoController alunoCon = new AlunoController(null, jtbAlunos);
            alunoCon.PreencheAlunos();
                       
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro:" + ex.getMessage());   
        }
    }
    
      private void guardarDados(){     
        objAluno.setMat_aluno(Integer.parseInt(txtMatricula.getText()));
        objAluno.setNom_aluno(txtNome.getText());
        objAluno.setEmail(txtEmail.getText());
        
        //AJUSTA A DATA PARA ANO-MES-DIA
        String dataFormatada = Formatacao.ajustaDataAMD(txtData.getText());
        objAluno.setDat_nasc(dataFormatada);
        
       Combos c = new Combos();
       c = (Combos) jcbCursos.getSelectedItem();
       objAluno.setCod_curso(Integer.parseInt(c.getCodigo()));   
    }
     
      private void preencheCampos(){
        try{
            txtMatricula.setEditable(false);
            txtMatricula.setText(String.valueOf(objAluno.getMat_aluno()));
            txtNome.setText(objAluno.getNom_aluno());
            txtEmail.setText(objAluno.getEmail());
            cbCurso.SetaComboBox(String.valueOf(objAluno.getCod_curso()));  
            
            //Ajusta a data para DIA/MES/ANO
            String dataFormatada = Formatacao.ajustaDataDMA(objAluno.getDat_nasc());
            txtData.setText(dataFormatada);
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
      
      private boolean validarLinha () {
      int linha = jtbAlunos.getSelectedRow();
      try {
            if (linha<0) {
               CaixaDeDialogo.obterinstancia().exibirMensagem("Selecione uma linha");
               return false;
                }
      } catch (Exception ex) {
          CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
      }
      return true;
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimparTela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcbCursos;
    private javax.swing.JTable jtbAlunos;
    private javax.swing.JLabel lblAlunos;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
