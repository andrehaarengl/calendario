/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.inf.es.mds.calendario;

import java.util.Scanner;

/**
 * @author Paulo Sales, Murillo Nunes
 * @since Novembro de 2016
 * @version 1.2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("## CALENDÁRIO ACADÊMICO - UFG ##\n");
        System.out.println(" Para entrar como usuário, digite 1 ");
        System.out.println(" Para entrar como administrador, digite 2 ");
        System.out.println(" Para encerrar o programa, digite 5");
        Scanner ler = new Scanner(System.in);
        int opcaoDeEntrada;
        Administrador admin = new Administrador();
        opcaoDeEntrada = Integer.parseInt(ler.nextLine());
        while(opcaoDeEntrada != 5){
            if (opcaoDeEntrada == 1) {
                //código do administrador vai aqui
            }
        
            if (opcaoDeEntrada == 2) {
                int resultado;
                resultado = admin.login();
                while (resultado != 0 ) {    
                    System.out.println(" Usuário e senha não conferem, digite"
                        + "novamente: ");
                resultado = admin.login();        
                }
            }
        
            if(opcaoDeEntrada != 1 && opcaoDeEntrada != 2 &&
                    opcaoDeEntrada != 5){
                throw new IllegalArgumentException(" Você digitou uma opção "
                + "inválida ");
            }
            System.out.println("\n Para entrar como usuário, digite 1 ");
            System.out.println(" Para entrar como administrador, digite 2 ");
            System.out.println(" Para encerrar o programa, digite 5");
            opcaoDeEntrada = Integer.parseInt(ler.nextLine());
        }
    }
    
}
