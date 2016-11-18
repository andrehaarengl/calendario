/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.mds.calendario;

/**
 *
 * @author Murillo Nunes
 */
public class Administrador {
    
    private final String username = "admin";
    private final String password = "ufg1234";
    
    public boolean autentica(String usuario, String senha) {
        if (usuario.equalsIgnoreCase(username)) {
            if (senha.equalsIgnoreCase(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
