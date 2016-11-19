/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.inf.es.mds.calendario;

import java.util.Scanner;

/**
 * @author Murillo Nunes
 * @since Novembro de 2016
 * @version 1.0
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

    public int login() {
        Administrador admin = new Administrador();
        String login;
        String senha;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome de usuário: ");
        login = ler.nextLine();
        System.out.println("Digite a senha: ");
        senha = ler.nextLine();
        
        if (admin.autentica(login, senha)) {
            return 0;
        } else {
            return 1;
        }
    }
}
