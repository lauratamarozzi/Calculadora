/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Senai
 */
public class ConexaoDAO {
        //retorna algo do tipo conenction
   public Connection conectaBD(){
     Connection conn = null;
     
     //Exceção, tratamento de erros. QUalquer erro entra no Catch
       try {
           String url = "jdbc:mysql://localhost:3306/crud?user=root&password=";
           conn = DriverManager.getConnection(url);
           
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null,"CONEXÃO DAO "+ erro);
       }
       return conn;
   }
}
