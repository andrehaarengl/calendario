/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.inf.es.mds.calendario;

import java.util.Scanner;

/**
 * @author Murillo Nunes
 * @since Novembro de 2016
 * @version 1.2
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(
                "## SISTEMA GERENCIADOR DE CALENDÁRIO ACADÊMICO ##\n"
                        + "  Para entrar como usuário, digite 1\n"
                        + "  Para entrar como administrador, digite 2\n"
                        + "  Para encerrar o programa, digite 5");
        Lista novaLista = new Lista();
        Controle control = new Controle();
        Scanner ler = new Scanner(System.in);
        int opcaoDeEntrada;
        Administrador admin = new Administrador();
        opcaoDeEntrada = Integer.parseInt(ler.nextLine());
        while(opcaoDeEntrada != 5){
            if (opcaoDeEntrada == 1) {
                System.out.println("\nAgora você está logado como usuário.");
                int opcaoDoMenu;
                Main.menuUsuario();
                opcaoDoMenu = Integer.parseInt(ler.nextLine());
                while (opcaoDoMenu == 1 || opcaoDoMenu == 2 ||
                        opcaoDoMenu == 9) {
                    switch(opcaoDoMenu) {
                        case 1:
                            System.out.println("Digite a data do evento:");
                            String dataDaPesquisa = ler.nextLine();
                            System.out.println("Digite o nome da regional:");
                            String regionalDaPesquisa = ler.nextLine();
                            System.out.println("    Eventos encontrados para"
                                    + " essa data:\n    " +
                                    novaLista.getStringEvento(
                                            dataDaPesquisa,
                                            regionalDaPesquisa));
                            System.out.println("\nO que deseja fazer agora?");
                            break;
                        case 2:
                            String nomeDoEventoDaBusca;
                            String regionalDoEventoDaBusca;
                            int anoDaBusca;
                            System.out.println("\nVocê pode buscar um evento de"
                                    + " duas formas:\n"
                                    + "1 - Em todos os anos de calendários"
                                    + " existentes\n"
                                    + "2 - Em um ano específico\n"
                                    + "Digite o número correspondente à opção"
                                    + " desejada:");
                            int opcaoDaBusca = Integer.parseInt(ler.nextLine());
                            if (opcaoDaBusca == 1) {
                                System.out.println("Digite o nome do evento:");
                                nomeDoEventoDaBusca = ler.nextLine();
                                System.out.println("Digite o nome da regional"
                                        + " do evento:");
                                regionalDoEventoDaBusca = ler.nextLine();
                                System.out.println("Datas encontradas:\n    " +
                                        novaLista.getDataEvento(
                                                nomeDoEventoDaBusca,
                                                regionalDoEventoDaBusca));
                                break;
                            } else {
                                if (opcaoDaBusca == 2) {
                                    System.out.println("Digite o nome do"
                                            + " evento:");
                                    nomeDoEventoDaBusca = ler.nextLine();
                                    System.out.println("Digite o nome da"
                                            + " regional do evento:");
                                    regionalDoEventoDaBusca = ler.nextLine();
                                    System.out.println("Digite o ano do"
                                            + " evento:");
                                    anoDaBusca = Integer.parseInt(
                                            ler.nextLine());
                                    System.out.println(
                                            "Datas encontradas:\n    " +
                                            novaLista.getDataEvento(
                                                    nomeDoEventoDaBusca,
                                                    regionalDoEventoDaBusca,
                                                    anoDaBusca));
                                    break;
                                } else {
                                    System.out.println("Opção inválida!");
                                    break;
                                }
                            }
                        case 9:
                            System.out.println("Você finalizou a aplicação.");
                            System.exit(0);
                    }
                    
                    Main.menuUsuario();
                    opcaoDoMenu = Integer.parseInt(ler.nextLine());
                }
            }
        
            if (opcaoDeEntrada == 2) {
                int resultado;
                int opcaoDoMenu;
                resultado = admin.login();
                while (resultado != 0 ) {    
                    System.out.println(" Usuário e senha não conferem, digite"
                        + "novamente: ");
                    resultado = admin.login();        
                }
                
                System.out.println("\nAgora você está logado como"
                        + " Administrador.");
                Main.menuPrincipal();
                opcaoDoMenu = Integer.parseInt(ler.nextLine());
                while (opcaoDoMenu == 1 || opcaoDoMenu == 2 ||
                        opcaoDoMenu == 3 || opcaoDoMenu == 4 ||
                        opcaoDoMenu == 9) {
                    switch(opcaoDoMenu) {
                        case 1:
                            System.out.println(
                                    "Digite o ano para o calendário:");
                            int ano;
                            ano = Integer.parseInt(ler.nextLine());
                            System.out.println("Digite a regional:");
                            String regional;
                            regional = ler.nextLine();
                            int numeroDaRegional = novaLista.getNumeroRegional(
                                    regional);
                            if (control.verificaAnoExistente(
                                    ano, numeroDaRegional)) {
                                System.out.println(
                                        "Esse calendário já existe!");
                                break;
                            } else {
                                Calendario calendar = new Calendario(
                                        ano, regional);
                                System.out.println("Calendário criado!");
                                System.out.println(
                                        "\nO que deseja fazer agora?");
                                break;
                            }
                        case 2:
                            System.out.println("Digite a data do evento:");
                            String data = ler.nextLine();
                            while (!Data.validaData(data)) {
                                System.out.println("Data inválida. Digite"
                                        + " novamente:");
                                data = ler.nextLine();
                            }
                            System.out.println("Digite o nome do evento:");
                            String evento = ler.nextLine();
                            System.out.println("Digite o nome da regional:");
                            String regionalDoEvento = ler.nextLine();
                            novaLista.setEvento(data, evento, regionalDoEvento);
                            System.out.println("Evento adicionado!");
                            System.out.println("\nO que deseja fazer agora?");
                            break;
                        case 3:
                            System.out.println("Digite a data do evento:");
                            String dataDaPesquisa = ler.nextLine();
                            System.out.println("Digite o nome da regional:");
                            String regionalDaPesquisa = ler.nextLine();
                            System.out.println("    Eventos encontrados para"
                                    + " essa data:\n    " +
                                    novaLista.getStringEvento(
                                            dataDaPesquisa,
                                            regionalDaPesquisa));
                            System.out.println("\nO que deseja fazer agora?");
                            break;
                        case 4:
                            String nomeDoEventoDaBusca;
                            String regionalDoEventoDaBusca;
                            int anoDaBusca;
                            System.out.println("\nVocê pode buscar um evento de"
                                    + " duas formas:\n"
                                    + "1 - Em todos os anos de calendários"
                                    + " existentes\n"
                                    + "2 - Em um ano específico\n"
                                    + "Digite o número correspondente à opção"
                                    + " desejada:");
                            int opcaoDaBusca = Integer.parseInt(ler.nextLine());
                            if (opcaoDaBusca == 1) {
                                System.out.println("Digite o nome do evento:");
                                nomeDoEventoDaBusca = ler.nextLine();
                                System.out.println("Digite o nome da regional"
                                        + " do evento:");
                                regionalDoEventoDaBusca = ler.nextLine();
                                System.out.println("Datas encontradas:\n    " +
                                        novaLista.getDataEvento(
                                                nomeDoEventoDaBusca,
                                                regionalDoEventoDaBusca));
                                break;
                            } else {
                                if (opcaoDaBusca == 2) {
                                    System.out.println("Digite o nome do"
                                            + " evento:");
                                    nomeDoEventoDaBusca = ler.nextLine();
                                    System.out.println("Digite o nome da"
                                            + " regional do evento:");
                                    regionalDoEventoDaBusca = ler.nextLine();
                                    System.out.println("Digite o ano do"
                                            + " evento:");
                                    anoDaBusca = Integer.parseInt(
                                            ler.nextLine());
                                    System.out.println(
                                            "Datas encontradas:\n    " +
                                            novaLista.getDataEvento(
                                                    nomeDoEventoDaBusca,
                                                    regionalDoEventoDaBusca,
                                                    anoDaBusca));
                                    break;
                                } else {
                                    System.out.println("Opção inválida!");
                                    break;
                                }
                            }
                        case 9:
                            System.out.println("Você finalizou a aplicação.");
                            System.exit(0);
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
        
        System.exit(0);
    }
    
    public static void menuPrincipal() {
        System.out.println("\nOpções disponíveis:\n"
                + "1 - Criar um novo calendário\n"
                + "2 - Adicionar um evento a um calendário\n"
                + "3 - Pesquisar data\n"
                + "4 - Pesquisar evento\n"
                + "9 - Sair do programa\n"
                + "Digite o número correspondente à opção desejada:");
    }
    
    public static void menuUsuario() {
        System.out.println("\nOpções disponíveis:\n"
                + "1 - Pesquisar data\n"
                + "2 - Pesquisar evento\n"
                + "9 - Sair do programa\n"
                + "Digite o número correspondente à opção desejada:");
    }
    
}
