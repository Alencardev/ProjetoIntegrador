/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nextlevel.dao;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import nextlevel.jdbc.ConnectionFactory;
import nextlevel.model.Enderecos;

/**
 *
 * @author Leonardo Drews Montibeller at ldmontibeller@gmail.com
 */
public class EnderecosDAO {
    //Atributos
    private Connection conexao;
    
    //Construtor
    public EnderecosDAO(){
        //1º passo: disponibilizar uma conexão com o BD
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void cadastrarEndereco(Enderecos obj){
        try {
            //2º passo: criar uma string de comando SQL
            String sql = "insert into tb_enderecos(cep, rua, numero, complemento, bairro, cidade, uf)"
                    + "values (?,?,?,?,?,?,?)";
            
            //3º passo: preparar o comando SQL para o driver
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getCep());
            comando.setString(2, obj.getRua());
            comando.setInt(3, obj.getNumero());
            comando.setString(4, obj.getComplemento());
            comando.setString(5, obj.getBairro());
            comando.setString(6, obj.getCidade());
            comando.setString(7, obj.getUF());
            
            //4º passo: executar o comando sql e fechar a conexão
            comando.execute();
            comando.close();
            
            //Se chegar aqui o cadastro foi efetuado com sucesso
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
