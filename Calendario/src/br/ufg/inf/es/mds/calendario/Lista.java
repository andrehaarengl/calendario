/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.inf.es.mds.calendario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Implementação da Lista de eventos do calendario de MDS.
 * 
 * @author Murilo de Oliveira.
 * @since Nov 2016
 * @version 4.5
 */
public class Lista {
    
    private ArrayList<String> eventosGoiania = new ArrayList();
    private ArrayList<String> eventosGoias = new ArrayList();
    private ArrayList<String> eventosJatai = new ArrayList();
    private ArrayList<String> eventosCatalao = new ArrayList();

    public Lista() throws FileNotFoundException, IOException {
        File file = new File("eventos.txt");
        
        FileReader leituraFile = new FileReader("eventos.txt");
        BufferedReader leituraBr = new BufferedReader(leituraFile);
        String linha = leituraBr.readLine();
        String repeticao = linha;
        if (linha != null){
            do {
                String[] dadosComSplit;
                dadosComSplit = linha.split(";");
                switch (Integer.parseInt(dadosComSplit[2])) {
                    case 0:
                        dadosComSplit[2] = "goiania";
                        break;
                    case 1:
                        dadosComSplit[2] = "goias";
                        break;
                    case 2:
                        dadosComSplit[3] = "jatai";
                        break;
                    case 3:
                        dadosComSplit[2] = "catalao";
                        break;
                    default:
                        break;
                }
                setEvento(dadosComSplit[0], dadosComSplit[1], dadosComSplit[2]);
                linha = leituraBr.readLine();
            }while (!repeticao.equals(linha));
        }
        leituraBr.close();
        leituraFile.close();
    }
    
    /**
     * Adiciona um evento à regional correspondente.
     *
     * @param data String. No formato DDMMAAAA validada anteriormente.
     *
     * @param evento String. String do evento, preferencialmente sem acentos.
     *
     * @param regional String referente ao nome da regional.
     */
    public void setEvento(String data, String evento, String regional)
            throws IOException {
        StringBuilder frase = new StringBuilder();
        FileWriter eventos = new FileWriter("eventos.txt",
                true);
        BufferedWriter gravarEvento = new BufferedWriter(eventos);
        int numRegional = getNumeroRegional(regional);        
        frase.append(data).append(";").append(evento).append(";")
                .append(numRegional);
        switch (numRegional) {
            case 0:
                eventosGoiania.add(frase.toString());
                gravarEvento.write(frase.toString());
                gravarEvento.newLine();
                gravarEvento.close();
                break;
            case 1:
                eventosGoias.add(frase.toString());
                gravarEvento.write(frase.toString());
                gravarEvento.newLine();
                gravarEvento.close();
                break;
            case 2:
                eventosJatai.add(frase.toString());
                gravarEvento.write(frase.toString());
                gravarEvento.newLine();
                gravarEvento.close();
                break;
            case 3:
                eventosCatalao.add(frase.toString());
                gravarEvento.write(frase.toString());
                gravarEvento.newLine();
                gravarEvento.close();
                break;
            default:
                break;
        }
        if (numRegional == 99) {
            System.out.println("Regional Inválida");
        }
    }
    
    /**
     * Obtém todas as datas que possuem a String "palavra" atribuida, todos os 
     * anos.
     *
     * @param palavra String do evento para a pesquisa.
     *
     * @param regional String com a ser pesquisada.
     *
     * @return String com todas as datas que possuem esse evento, separadas por
     * ponto e vírgula ";".
     */
    public String getDataEvento(String palavra, String regional) {
        ArrayList<String> dataPesquisada = new ArrayList();
        String s,todosEventos = "";
        s = palavra;
        s = s.toUpperCase();
        String[] dadosComSplit;
        int numRegional = getNumeroRegional(regional);
        if (numRegional == 99) {
            System.out.println("Regional inválida");
            return "Nenhuma";
        }
        int i;
        switch (numRegional) {
            case 0: 
                for (i = 0; i < getTamanhoLista(eventosGoiania); i++) {
                    dadosComSplit = eventosGoiania.get(i).split(";");
                    if (dadosComSplit[1].toUpperCase().contains(s)) {
                    dataPesquisada.add(dadosComSplit[0]);
                    }
                }
                break;
            case 1:
                for (i = 0; i < getTamanhoLista(eventosGoias); i++) {
                    dadosComSplit = eventosGoias.get(i).split(";");
                    if (dadosComSplit[1].toUpperCase().contains(s)) {
                    dataPesquisada.add(dadosComSplit[0]);
                    }
                }
                break;
            case 2:
                for (i = 0; i < getTamanhoLista(eventosJatai); i++) {
                    dadosComSplit = eventosJatai.get(i).split(";");
                    if (dadosComSplit[1].toUpperCase().contains(s)) {
                    dataPesquisada.add(dadosComSplit[0]);
                    }
                }
            case 3:
                for (i = 0; i < getTamanhoLista(eventosCatalao); i++) {
                    dadosComSplit = eventosCatalao.get(i).split(";");
                    if (dadosComSplit[1].toUpperCase().contains(s)) {
                    dataPesquisada.add(dadosComSplit[0]);
                    }
                }
                break;
            default:
                break;
        }
        
        for (i = 0; i < getTamanhoLista(dataPesquisada); i++) {
            System.out.println(dataPesquisada.get(i));
        }
        StringBuilder frase = new StringBuilder();
        for (i = 0; i < getTamanhoLista(dataPesquisada); i++) {
            todosEventos = frase.append(dataPesquisada.get(i)).append(";")
                    .toString();
        }
        if ("".equals(todosEventos)){
            return "Nenhuma";
        }
        String subString = todosEventos.substring(0,todosEventos.length() - 1);
        return subString;
    }
    
    /**
     * Obtém as todas as datas que possuem o evento em determinado ano.
     *
     * @param palavra String do evento a ser pesquisada.
     *
     * @param regional String com a cidade da regional.
     *
     * @param ano Numero inteiro. Ano a ser pesquisado o evento, formato AAAA.
     *
     * @return String com todas as datas que possuem esse evento em determinado
     * ano, separadas por ponto e vírgula ";".
     */
    public String getDataEvento(String palavra, String regional, int ano) {
        ArrayList<String> dataPesquisada = new ArrayList();
        String s,todosEventos = "";
        s = palavra;
        s = s.toUpperCase();
        String[] dadosComSplit;
        int numRegional = getNumeroRegional(regional);
        if (numRegional == 99) {
            System.out.println("Regional inválida");
            return "Nenhuma";
        }
        int i;
        switch (numRegional) {
            case 0: 
                for (i = 0; i < getTamanhoLista(eventosGoiania); i++) {
                    dadosComSplit = eventosGoiania.get(i).split(";");
                    if (dadosComSplit[1].toUpperCase().contains(s)) {
                    dataPesquisada.add(dadosComSplit[0]);
                    }
                }
                break;
            case 1:
                for (i = 0; i < getTamanhoLista(eventosGoias); i++) {
                    dadosComSplit = eventosGoias.get(i).split(";");
                    if (dadosComSplit[1].toUpperCase().contains(s)) {
                    dataPesquisada.add(dadosComSplit[0]);
                    }
                }
                break;
            case 2:
                for (i = 0; i < getTamanhoLista(eventosJatai); i++) {
                    dadosComSplit = eventosJatai.get(i).split(";");
                    if (dadosComSplit[1].toUpperCase().contains(s)) {
                    dataPesquisada.add(dadosComSplit[0]);
                    }
                }
            case 3:
                for (i = 0; i < getTamanhoLista(eventosCatalao); i++) {
                    dadosComSplit = eventosCatalao.get(i).split(";");
                    if (dadosComSplit[1].toUpperCase().contains(s)) {
                    dataPesquisada.add(dadosComSplit[0]);
                    }
                }
                break;
            default:
                break;
        }
        StringBuilder frase = new StringBuilder();
        for (i = 0; i < getTamanhoLista(dataPesquisada); i++) {
            dadosComSplit = dataPesquisada.get(i).split("/");
            if (dataPesquisada.get(i).length() > 8) {
                if (Integer.parseInt(dadosComSplit[2]) == ano){
                    todosEventos = (frase.append(dataPesquisada.get(i))
                            .append(";").toString());
                }
            }
            else {
                if ((Integer.parseInt(dataPesquisada.get(i)) % 10000) == ano){
                    todosEventos = (frase.append(dataPesquisada.get(i))
                           .append(";").toString());                   
                }
            }
        }
        if ("".equals(todosEventos)){
            return "Nenhuma";
        }
        String subString = todosEventos.substring(0,todosEventos.length() - 1);
        return subString;
    }
    
    /**
     * Obtém o evento em determinada data.
     *
     * @param data String no formato DDMMAAAA.
     *
     * @param regional String com o nome da regional.
     *
     * @return Retorna a String gravada na data específica.
     */
    public String getStringEvento (String data, String regional) {
        ArrayList<String> eventoPesquisado = new ArrayList();
        String todosEventos = "";
        String[] dadosComSplit;
        int numRegional = getNumeroRegional(regional);
        if (numRegional == 99) {
            System.out.println("Regional inválida");
            return "Nenhum";
        }
        int i;
        switch (numRegional) {
            case 0:
                for (i = 0; i < getTamanhoLista(eventosGoiania); i++) {
                    dadosComSplit = eventosGoiania.get(i).split(";");
                    if (dadosComSplit[0].equals(data)) {
                        eventoPesquisado.add(dadosComSplit[1]);
                    }
                }
                break;
            case 1:
                for (i = 0; i < getTamanhoLista(eventosGoias); i++) {
                    dadosComSplit = eventosGoias.get(i).split(";");
                    if (dadosComSplit[0].equals(data)) {
                        eventoPesquisado.add(dadosComSplit[1]);
                    }
                }
                break;
            case 2:
                for (i = 0; i < getTamanhoLista(eventosJatai); i++) {
                    dadosComSplit = eventosJatai.get(i).split(";");
                    if (dadosComSplit[0].equals(data)) {
                        eventoPesquisado.add(dadosComSplit[1]);
                    }
                }
                break;
            case 3:
                for (i = 0; i < getTamanhoLista(eventosCatalao); i++) {
                    dadosComSplit = eventosCatalao.get(i).split(";");
                    if (dadosComSplit[0].equals(data)) {
                        eventoPesquisado.add(dadosComSplit[1]);
                    }
                }
                break;
            default:
                break;
        }
        StringBuilder frase = new StringBuilder();
        for (i = 0; i < getTamanhoLista(eventoPesquisado); i++) {
            todosEventos = (frase.append(eventoPesquisado.get(i)).append(";")
                    .toString());
        }
        if ("".equals(todosEventos)){
            return "Nenhum";
        }
        String subString = todosEventos.substring(0,todosEventos.length() - 1);
        return subString;
    }
    
    /**
     * Método auxiliar que mostra o tamanho de uma ArrayList.
     *
     * @param lista ArrayList para ser retornar o tamanho.
     *
     * @return Inteiro correspondente ao tamanho da ArrayList.
     */
    public int getTamanhoLista(ArrayList lista) {
        int tamanho = lista.size();
        return tamanho;
    }
    
    /**
     * Método auxiliar que transforma uma string da regional em um inteiro.
     * 
     * @param regional String referente à regional.
     * 
     * @return inteiro de 0 à 3 representando a regional ou 99 caso seja
     * inválida.
     */
    public int getNumeroRegional(String regional) {
        int numRegional = 99;
        String a = "goiania", b = "goias", c = "jatai", d = "catalao";
        String a2 = "goiânia", b2 = "goiás", c2 = "jataí", d2 = "catalão";
        
        String comparaRegional = (regional.toLowerCase());
        if ((comparaRegional.equals(a)) || (comparaRegional.equals(a2))) {
            numRegional = 0;
        }
        if ((comparaRegional.equals(b)) || (comparaRegional.equals(b2))) {
            numRegional = 1;
        }
        
        if ((comparaRegional.equals(c)) || (comparaRegional.equals(c2))) {
            numRegional = 2;
        }
        
        if ((comparaRegional.equals(d)) || (comparaRegional.equals(d2))) {
            numRegional = 3;
        }
        return numRegional;
    }
}
