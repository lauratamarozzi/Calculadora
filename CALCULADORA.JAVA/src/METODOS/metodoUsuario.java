/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METODOS;

import DAO.ConexaoDAO;
import TABELAS.*;
import VIEW.*;
//import static VIEW.Login.nome_usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Senai
 */
public class metodoUsuario {
    Connection conn;
    
  
    //MÈTODO LOGIN
    public void loginBasico(){
        try {
            conn = new ConexaoDAO().conectaBD();
            tbUsuario objUsuario = new tbUsuario();
            objUsuario.setNome(Login.user);
            objUsuario.setSenha(Login.senha);
            
            String sql = "select * from usuario where db_usuario = ? and db_senha = ?";
            PreparedStatement pstm = conn.prepareStatement (sql);
            pstm.setString(1,objUsuario.getNome());
            pstm.setString(2,objUsuario.getSenha());
            ResultSet rs = pstm.executeQuery();
            
            ResultSet consulta = rs;
            
             if (consulta.next()){
               //CHAMAR TELA QUE EU QUERO ABRIR 
               Principal objprincipal = new Principal();
               
               objprincipal.setVisible(true);
               
              
            }else{
               //ENVIAR MENSAGEM DIZENDO INCORRETO
               JOptionPane.showMessageDialog(null, "USUÁRIO OU SENHA INCORRETOS");
                
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "METODO USUÁRIO "+erro);
        }
      
    }//FIM MÉTODO LOGIN
    
    public void selectBasico(){
        
        
        
    }
}
