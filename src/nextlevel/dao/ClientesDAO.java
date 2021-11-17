/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nextlevel.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import nextlevel.jdbc.ConnectionFactory;
import nextlevel.model.Clientes;

/**
 *
 * @author Leonardo Drews Montibeller at ldmontibeller@gmail.com
 */
public class ClientesDAO {
     //Atributos
    private Connection conexao;

    //Construtor
    public ClientesDAO() {
        //1º passo: disponibilizar uma conexão com o BD
        this.conexao = ConnectionFactory.getConnection();
    }
    
    //Retorna a ID do cliente cadastrado com sucesso
    public void cadastrarCliente(Clientes obj) {
        try {
             //2º passo: criar uma string de comando SQL
            String sql = "insert into tb_clientes(nome, email, cpf, telefone)"
                    + "values (?,?,?,?)";

            //3º passo: preparar o comando SQL para o driver
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getEmail());
            comando.setString(3, obj.getCpf());
            comando.setString(4, obj.getTelefone());

            //4º passo: executar o comando sql e fechar a conexão
            comando.execute();
            comando.close();
            
            //5º passo: pegar o id gerado pelo banco de dados através do CPF
            sql = "select id from tb_clientes where cpf=?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, obj.getCpf());
            
            //Com o comando preparado, executo o comando
            //Esse comando é de leitura do BD, logo ele retorna um ResultSet
            ResultSet resultado = comando.executeQuery();
            
            //Percorro o resultado até achar o campo "id"
            while(resultado.next()){
                obj.setId(resultado.getInt("id"));
            }
            //Sechegar aqui mostra a janela de cadastro com sucesso;
//            JOptionPane.showMessageDialog(null, "Cadastro de cliente efetuado com sucesso!");
                    
        } catch (SQLException e) {
        }
    }
}
