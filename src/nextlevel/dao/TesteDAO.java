/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nextlevel.dao;

import nextlevel.model.Enderecos;

/**
 *
 * @author Leonardo Drews Montibeller at ldmontibeller@gmail.com
 */
public class TesteDAO {
    public static void main(String[] args) {
        Enderecos end = new Enderecos();
        
        end.setCep("89812130");
        end.setBairro("Santa Maria");
        end.setComplemento("D");
        end.setCidade("Chapecó");
        end.setNumero(986);
        end.setRua("Rui Barbosa");
        end.setUF("sc");
        
        EnderecosDAO daoObj = new EnderecosDAO();
        daoObj.cadastrarEndereco(end);
    }
   
    
}
