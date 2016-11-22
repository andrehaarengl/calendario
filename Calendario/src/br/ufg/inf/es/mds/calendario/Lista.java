/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.inf.es.mds.calendario;

import java.util.ArrayList;

/**
 * Implementação da Lista de eventos do calendario de MDS.
 * 
 * @author Murilo de Oliveira.
 * @since Nov 2016
 * @version 3.0
 */
public class Lista {

    private ArrayList<String> eventosGoiania = new ArrayList();
    private ArrayList<String> eventosGoias = new ArrayList();
    private ArrayList<String> eventosJatai = new ArrayList();
    private ArrayList<String> eventosCatalao = new ArrayList();
    
    /**
     * Adiciona um evento à regional correspondente.
     *
     * @param data String. No formato DDMMAAAA validada anteriormente.
     *
     * @param evento String. String do evento, preferencialmente sem acentos.
     *
     * @param regional Numero inteiro. Deve ser um valor de 0 à 3.
     */
    public void setEvento(String data, String evento, int regional) {
        StringBuilder frase = new StringBuilder();
        frase.append(data).append(";").append(evento).append(";")
                .append(regional);
        switch (regional) {
            case 0:
                eventosGoiania.add(frase.toString());
                break;
            case 1:
                eventosGoias.add(frase.toString());
                break;
            case 2:
                eventosJatai.add(frase.toString());
                break;
            case 3:
                eventosCatalao.add(frase.toString());
                break;
            default:
                break;
        }
    }
    
    /**
     * Obtém todas as datas que possuem a String "palavra" atribuida, todos os 
     * anos.
     *
     * @param palavra String do evento para a pesquisa.
     *
     * @param regional Regional a ser pesquisada.
     *
     * @return String com todas as datas que possuem esse evento, separadas por
     * ponto e vírgula ";".
     */
    public String getDataEvento(String palavra, int regional) {
        ArrayList<String> dataPesquisada = new ArrayList();
        String s,todosEventos = "";
        s = palavra;
        s = s.toUpperCase();
        String[] dadosComSplit;
        int i;
        switch (regional) {
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
            return "1";
        }
        String subString = todosEventos.substring(0,todosEventos.length() - 1);
        return subString;
    }
    
    /**
     * Obtém as todas as datas que possuem o evento em determinado ano.
     *
     * @param palavra String do evento a ser pesquisada.
     *
     * @param regional Numero inteiro da regional a ser pesquisado o evento.
     *
     * @param ano Numero inteiro. Ano a ser pesquisado o evento, formato AAAA.
     *
     * @return String com todas as datas que possuem esse evento em determinado
     * ano, separadas por ponto e vírgula ";".
     */
    public String getDataEvento(String palavra, int regional, int ano) {
        ArrayList<String> dataPesquisada = new ArrayList();
        String s,todosEventos = "";
        s = palavra;
        s = s.toUpperCase();
        String[] dadosComSplit;
        int i;
        switch (regional) {
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
            if ((Integer.parseInt(dataPesquisada.get(i)) % 10000) == ano){
            todosEventos = (frase.append(dataPesquisada.get(i)).append(";")
                    .toString());
            }
        }
        if ("".equals(todosEventos)){
            return "1";
        }
        String subString = todosEventos.substring(0,todosEventos.length() - 1);
        return subString;
    }
    
    /**
     * Obtém o evento em determinada data.
     *
     * @param data String no formato DDMMAAAA.
     *
     * @param regional Inteiro de 0 a 3.
     *
     * @return Retorna a String gravada na data específica.
     */
    public String getStringEvento (String data, int regional) {
        ArrayList<String> eventoPesquisado = new ArrayList();
        String todosEventos = "";
        String[] dadosComSplit;
        int i;
        switch (regional) {
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
            return "1";
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
}
