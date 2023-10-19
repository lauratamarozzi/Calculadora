/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METODOS;
import DAO.ConexaoDAO;
import TABELAS.*;
import VIEW.*;
import VIEW.Calculadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Senai
 */
public class metodoCalculo {
    Connection conn;
    
    public void Calculo(){
        
       System.out.println(Calculadora.tipo_calculo);
       switch(Calculadora.tipo_calculo){
           
           case "SOMA":
             
             Calculadora.resultado = Calculadora.valor1 + Calculadora.valor2;
             

           break;
           case "SUBTRAIR":
             //System.out.println("SUBTRAÇÃO");  
             Calculadora.resultado = Calculadora.valor1 - Calculadora.valor2;
           break;
           
           case "MULTIPLICAR":
               
             Calculadora.resultado = Calculadora.valor1 * Calculadora.valor2;
           break;
           
           case "DIVIDIR":
               
             Calculadora.resultado = Calculadora.valor1 / Calculadora.valor2;
               break;
       }
        
      
    }
    
    
    public void inserirCalculo(){
        try {
            conn = new ConexaoDAO().conectaBD();
            tbCalculo objCalculo = new tbCalculo();
            
            objCalculo.setValor1(Calculadora.valor1);
            objCalculo.setValor2(Calculadora.valor2);
            objCalculo.setTipo_calculo(Calculadora.tipo_calculo);
            objCalculo.setResultado(Calculadora.resultado);
            
            String sql = "insert into calculo (valor1,valor2,resultado,tipo_calculo)values(?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement (sql);
            pstm.setFloat(1,objCalculo.getValor1());
            pstm.setFloat(2,objCalculo.getValor2());
            pstm.setFloat(3,objCalculo.getResultado());
            pstm.setString(4,objCalculo.getTipo_calculo());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "METODO Calculo "+ex);
        }
        
    }
}

