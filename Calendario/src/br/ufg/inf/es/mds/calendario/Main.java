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
    public static void main(String[] args) throws Exception {
        System.out.println("## CALENDÁRIO ACADÊMICO - UFG ##\n");
        System.out.println(" Para entrar como usuário, digite 1");
        System.out.println(" Para entrar como administrador, digite 2");
        System.out.println(" Para encerrar o programa, digite 5");
        Scanner ler = new Scanner(System.in);
        int opcaoDeEntrada;
        Administrador admin = new Administrador();
        opcaoDeEntrada = Integer.parseInt(ler.nextLine());
        while(opcaoDeEntrada != 5){
            if (opcaoDeEntrada == 1) {
                //funcionalidades do usuário comum vão aqui.
            }
        
            if (opcaoDeEntrada == 2) {
                int resultado;
                int opcaoDoMenu = 0;
                resultado = admin.login();
                while (resultado != 0 ) {    
                    System.out.println(" Usuário e senha não conferem, digite"
                        + "novamente: ");
                    resultado = admin.login();        
                }
                
                System.out.println("\nAgora você está logado como"
                        + "Administrador.");
                Main.menuPrincipal();
                opcaoDoMenu = Integer.parseInt(ler.nextLine());
                while (opcaoDoMenu == 1 || opcaoDoMenu == 2) {
                    switch(opcaoDoMenu) {
                        case 1:
                            System.out.println(
                                    "Digite o ano para o calendário:");
                            int ano = 0;
                            ano = Integer.parseInt(ler.nextLine());
                            System.out.println("Digite a regional:");
                            String regional = "";
                            regional = ler.nextLine();
                            Calendario calendar = new Calendario(ano, regional);
                            System.out.println("Você criou o calendário " +
                                    calendar.getNomeRegional() + " " +
                                    calendar.getAnoCalendario());
                            System.out.println("\nO que deseja fazer agora?");
                            break;
                        case 2:
                            //continua
                    }
                    
                    Main.menuPrincipal();
                    opcaoDoMenu = Integer.parseInt(ler.nextLine());
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
    
    public static void menuPrincipal() {
        System.out.println("\nOpções disponíveis:\n"
                + "1 - Criar um novo calendário\n"
                + "2 - Adicionar um evento a um calendário\n"
                + "3 - opção 3\n"
                + "Digite o número correspondente à opção desejada:");
    }
    
}
