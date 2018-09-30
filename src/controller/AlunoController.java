/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Aluno;
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author jonasdhein
 */
public class AlunoController {
    
    Aluno objAluno;
    JTable jtbAlunos = null;
    
    public AlunoController(Aluno objAluno, JTable jtbAlunos) {
        this.objAluno = objAluno;
        this.jtbAlunos = jtbAlunos;
    }
    
    public Aluno buscar(String id)
    {
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT mat_alu, nom_alu, email, cod_curso, dat_nasc";
            SQL += " FROM alunos";
            SQL += " WHERE mat_alu = '" + id + "'";
            //stm.executeQuery(SQL);

            try{
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar aluno");
                
               objAluno = new Aluno();
               
                if(rs.next() == true)
                {
                    objAluno.setMat_aluno(rs.getInt(1));
                    objAluno.setNom_aluno(rs.getString(2));
                    objAluno.setEmail(rs.getString(3));
                    objAluno.setCod_curso(rs.getInt(4));
                    objAluno.setDat_nasc(rs.getString(5));
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar aluno com sucesso");
        return objAluno;
    }
    
     public boolean incluir(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO alunos (mat_alu, cod_curso, nom_alu, email, dat_nasc) VALUES (?,?,?,?,?)");
            stmt.setInt(1, objAluno.getMat_aluno());
            stmt.setInt(2, objAluno.getCod_curso());
            stmt.setString(3, objAluno.getNom_aluno());
            stmt.setString(4, objAluno.getEmail());
            stmt.setDate(5, Date.valueOf(objAluno.getDat_nasc()));
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
       public boolean alterar(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE alunos SET nom_alu=?, cod_curso=?, email=?, dat_nasc=? WHERE mat_alu=?");
            stmt.setString(1, objAluno.getNom_aluno());
            stmt.setInt(2, objAluno.getCod_curso());
            stmt.setString(3, objAluno.getEmail());
            stmt.setDate(4, Date.valueOf(objAluno.getDat_nasc()));
            stmt.setInt(5, objAluno.getMat_aluno());
           
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean excluir(String id){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM alunos WHERE mat_alu='"+ id +"'");
            //stmt = con.prepareStatement("UPDATE aluno SET dataExclusao=? WHERE mat_alu=?");
            //stmt.setString(1, objAluno.getDataExclusao());
            //stmt.setInt(2, objAluno.getMat_aluno());
                        
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
      public void PreencheAlunos() {

        try{
            
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Matricula");
        cabecalhos.add("Curso");
        cabecalhos.add("Nome");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT mat_alu, c.nom_curso, nom_alu ";
            SQL += " FROM alunos a, cursos c ";
            SQL += " WHERE a.cod_curso = c.cod_curso ";
            SQL += " ORDER BY nom_alu ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                dadosTabela.add(linha);
            }
            
        } catch (SQLException e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbAlunos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            //Não deixa editar as linhas da tabela
            public boolean isCellEditable(int row, int column) {
              return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        jtbAlunos.setSelectionMode(0);
        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbAlunos.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(150);
                    break;
                case 2:
                    column.setPreferredWidth(150);
                    break;
            }
        }
        
        jtbAlunos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                 if (isSelected) {
                    setBackground(Color.BLUE);
                } else if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
        
           
        }catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage().toString());
        }
    }
    
     
      public int QuantidadeAlunos(){
        
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        ConnectionFactory.abreConexao();
       
        ResultSet rs = null;
        PreparedStatement ps = null;
        int total = 0;

        StringBuilder sql = new StringBuilder();
           
        sql.append(" SELECT count(mat_alu) AS total");
        sql.append(" FROM alunos");  
     
        try {
            System.out.println("Vai Executar Conexão em buscar area (Consulta no banco)");
            rs = ConnectionFactory.stmt.executeQuery(sql.toString());
            System.out.println("Executou Conexão em buscar area");
            
            if (rs.next() == true) {
             total = rs.getInt("total");
             return total;
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage().toString());
            
        }finally{
            Connection con = ConnectionFactory.getConnection();
            System.out.println("Vai fechar a conexão com o banco de dados");
            ConnectionFactory.closeConnection(con, ps, rs);
        }
        
      return total;  
   }
       
}
