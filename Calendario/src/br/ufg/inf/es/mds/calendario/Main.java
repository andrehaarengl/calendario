/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.mds.calendario;

import java.util.Scanner;

/**
 *
 * @author Paulo Sales
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("## CALENDÁRIO ACADÊMICO - UFG ##\n");
        System.out.println(" Para entrar como usuário, digite 1 ");
        System.out.println(" Para entrar como administrador, digite 2 ");
        Scanner ler = new Scanner(System.in);
        int opcaoDeEntrada;
        Administrador admin = new Administrador();
        opcaoDeEntrada = Integer.parseInt(ler.nextLine());
        
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
        
        if(opcaoDeEntrada != 1 && opcaoDeEntrada != 2){
                throw new IllegalArgumentException(" Você digitou uma opção "
                + "inválida ");
        }
    }
    
}
