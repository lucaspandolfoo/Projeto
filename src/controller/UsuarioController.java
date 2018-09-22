/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Connection.*;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Usuario;

/**
 *
 * @author lucas.pandolfo
 */
public class UsuarioController {
    
    Usuario objUsuario;
    JTable jtbUsuarios = null;
    
    public UsuarioController (Usuario objUsuario, JTable jtbUsuarios) {
        this.objUsuario = objUsuario;
        this.jtbUsuarios = jtbUsuarios;
    }
    
    public Usuario Login(String usuario, String senha){
        
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        ConnectionFactory.abreConexao();
        
        //Criando um usuario
        Usuario user = null;
        //Resultado do banco.
        ResultSet rs = null;

           StringBuilder sql = new StringBuilder();
           sql.append(" SELECT login, nome, tipo");
           sql.append(" FROM usuarios");
           sql.append(" WHERE login = '" + usuario + "' ");
           sql.append(" AND senha = '" + senha + "'");
     
        try {
            System.out.println("Vai Executar Conexão em buscar area (Consulta no banco)");
            rs = ConnectionFactory.stmt.executeQuery(sql.toString());
            System.out.println("Executou Conexão em buscar area");
            
            //IF porque so tem 1 registro se fosse mais seria WHILE
            if (rs.next() == true) {
             user = new Usuario();
             user.setLogin(rs.getString("login"));
             user.setNome(rs.getString("nome"));
             user.setTipo(rs.getString("tipo").charAt(0));
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage().toString());
            return user;
            
        }finally{
            Connection con = ConnectionFactory.getConnection();
            System.out.println("Vai fechar a conexão com o banco de dados");
            ConnectionFactory.closeConnection(con);
        }
        
        return user;
        
    }
    
    public boolean incluir(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuarios (login, senha, nome) VALUES (?,?,?)");
            stmt.setString(1, objUsuario.getLogin());
            stmt.setString(2, objUsuario.getSenha());
            stmt.setString(3, objUsuario.getNome());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void preencheUsuarios() {
        
        if (objUsuario.getTipo() == 'A')  {
        try{
            
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Nome");
        cabecalhos.add("Login");
        cabecalhos.add("Senha");
        cabecalhos.add("Tipo");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT nome, login, senha, tipo ";
            SQL += " FROM usuarios ";

            result = ConnectionFactory.stmt.executeQuery(SQL);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getString(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString("tipo").charAt(0));
                dadosTabela.add(linha);
            }
            
        } catch (SQLException e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }
        

        jtbUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            //Não deixa editar as linhas da tabela
            public boolean isCellEditable(int row, int column) {
              return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        jtbUsuarios.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = jtbUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(150);
                    break;
                case 1:
                    column.setPreferredWidth(80);
                    break;
                case 2:
                    column.setPreferredWidth(80);
                    break;
               case 3:
                    column.setPreferredWidth(80);
                    break;
            }
        }
        
           
        jtbUsuarios.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {     
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                
              //  String coluna1 = table.getModel().getValueAt(row, 3).toString();
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
        
    } else {
      try{
            
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Nome");
        cabecalhos.add("Login");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT nome, login ";
            SQL += " FROM usuarios ";

            result = ConnectionFactory.stmt.executeQuery(SQL);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getString(1));
                linha.add(result.getString(2));
                dadosTabela.add(linha);
            }
            
        } catch (SQLException e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }
        

        jtbUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            //Não deixa editar as linhas da tabela
            public boolean isCellEditable(int row, int column) {
              return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        jtbUsuarios.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = jtbUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(150);
                    break;
                case 1:
                    column.setPreferredWidth(80);
                    break;
            }
        }
        
           
        jtbUsuarios.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
 }
}
