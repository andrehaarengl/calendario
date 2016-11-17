package br.ufg.inf.es.mds.calendario;

import java.util.ArrayList;

/**
 *
 * @author Murilo Oliveira
 */
public class Lista {

    private ArrayList<String> eventosGoiania = new ArrayList();
    private ArrayList<String> eventosGoias = new ArrayList();
    private ArrayList<String> eventosJatai = new ArrayList();
    private ArrayList<String> eventosCatalao = new ArrayList();
    
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
            StringBuilder frase = new StringBuilder();
            todosEventos = (frase.append(dataPesquisada.get(i)).append(";")
                    .toString());
        }
        if ("".equals(todosEventos)){
            return "1";
        }
        String subString = todosEventos.substring(0,todosEventos.length() - 1);
        return subString;
    }

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
        for (i = 0; i < getTamanhoLista(eventoPesquisado); i++) {
            StringBuilder frase = new StringBuilder();
            todosEventos = (frase.append(eventoPesquisado.get(i)).append(";")
                    .toString());
        }
        if ("".equals(todosEventos)){
            return "1";
        }
        String subString = todosEventos.substring(0,todosEventos.length() - 1);
        return subString;
    }

    public int getTamanhoLista(ArrayList lista) {
        int tamanho = lista.size();
        return tamanho;
    }
}
