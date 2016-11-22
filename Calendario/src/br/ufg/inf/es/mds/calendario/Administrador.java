/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.inf.es.mds.calendario;

import java.util.Scanner;

/**
 * @author Paulo Sales, Murillo Nunes
 * @since Novembro de 2016
 * @version 1.0
 */
public class Administrador {

    private final String username = "admin";
    private final String password = "ufg1234";

    /**
     * O método 'autentica' compara as strings entradas pelo usuário para ter
     * acesso com o login e senha do Administrador do programa.
     *
     * @param usuario este deve ser compatível ao 'username' da classe
     * Administrador.
     *
     * @param senha este deve ser compatível com a senha da mesma classe.
     *
     * @return booleano para retornar se a comparação deu certo ou não.
     */
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

    /**
     * O método 'login' confere login e senha para o acesso do Administrador do
     * calendário.
     *
     * @return boolean usado para permitir acesso ou negar.
     */
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
