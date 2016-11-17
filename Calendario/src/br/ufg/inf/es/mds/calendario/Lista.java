package br.ufg.inf.es.mds.calendario;

import java.util.ArrayList;

public class Lista {
    
    private ArrayList<String> eventos = new ArrayList();
    
    public void setEvento(String data, String evento, int regional) {
        StringBuilder frase = new StringBuilder();
        frase.append(data).append(";").append(evento).append(";")
                .append(regional);
        eventos.add(frase.toString()); 
    }
    
    public String getDataEvento(String palavra) {
        ArrayList<String> dataPesquisada = new ArrayList();
        String s,todosEventos = "";
        s = palavra;
        s = s.toUpperCase();
        String[] dadosComSplit;
        int i;
        for (i = 0; i < getTamanhoLista(eventos); i++) {
            dadosComSplit = eventos.get(i).split(";");
            if (dadosComSplit[1].toUpperCase().contains(s)) {
                dataPesquisada.add(dadosComSplit[0]);
            }
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
    
    public String getStringEvento (String data) {
        ArrayList<String> eventoPesquisado = new ArrayList();
        String todosEventos = "";
        String[] dadosComSplit;
        int i;
        for (i = 0; i < getTamanhoLista(eventos); i++) {
            dadosComSplit = eventos.get(i).split(";");
            if (dadosComSplit[0].equals(data)) {
                eventoPesquisado.add(dadosComSplit[1]);
            }
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
