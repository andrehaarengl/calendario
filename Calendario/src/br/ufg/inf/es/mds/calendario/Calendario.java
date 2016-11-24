/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.inf.es.mds.calendario;

/**
 * @author Paulo Sales
 * @since Novembro de 2016
 * @version 1.2
 */
public class Calendario {
    
    /**
     * @return Retorna o ano do calendário criado.
     */
    public int getAnoCalendario() {
        return anoCalendario;
    }

    /**
     * @return Retorna o número da regional do calendário criado.
     */
    public int getNumRegional() {
        return numRegional;
    }
    
    public String getNomeRegional() {
        int regional = 0;
        String nome = "";
        switch(regional) {
            case 0:
                nome = "Goiânia";
                break;
            case 1:
                nome = "Goiás";
                break;
            case 2:
                nome = "Jataí";
                break;
            case 3:
                nome = "Catalão";
                break;
        }
        
        return nome;
    }
    
    private int anoCalendario;
    
    private int numRegional;

    /**
     * Este construtor é necessário para criar um calendário de um ano
     * específico.
     *
     * @param ano Escolhe um ano específico pro calendário.
     *
     * @param regional Transforma uma String em um inteiro que será usado para
     * diferenciar os calendários por regionais.
     *
     * @throws Exception Se o ano para este calendário já existe ou o nome
     * da regional foi digitado de forma errada ocorre a exceção.
     */
    public Calendario(int ano, String regional) throws Exception {
        Controle control = new Controle();
        numRegional = 99;
        String a = "goiania";
        String b = "goias";
        String c = "jatai";
        String d = "catalao";
        String a2 = "goiânia";
        String b2 = "goiás";
        String c2 = "jataí";
        String d2 = "catalão";
        //usar toLowerCase//
        String comparaRegional = regional.toLowerCase();
        if ((comparaRegional.equals(a)) || (comparaRegional.equals(a2))){
            numRegional = 0; // Goiania
        }
        
        if ((comparaRegional.equals(b)) || (comparaRegional.equals(b2))){
            numRegional = 1; // Cidade de Goias
        }
        
        if ((comparaRegional.equals(c)) || (comparaRegional.equals(c2))){
            numRegional = 2; // Jataí
        }
        
        if ((comparaRegional.equals(d)) || (comparaRegional.equals(d2))){
            numRegional = 3; // Catalão
        }
        
        if (numRegional == 99){
            throw new Exception("O nome da regional digitado é inválido.");
        }
        
        try {
            control.adicionaAno(ano,numRegional);
            anoCalendario = ano;
        } catch(Exception e) {
            System.out.println("Escolha um ano diferente.");
        }
    }
}