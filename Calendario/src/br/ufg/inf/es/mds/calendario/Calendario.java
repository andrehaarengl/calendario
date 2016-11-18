/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.mds.calendario;

/**
 *
 * @author Murillo
 */
public class Calendario {
    
    public int getAnoCalendario() {
        return anoCalendario;
    }

    public int getNumRegional() {
        return numRegional;
    }
    
    private int anoCalendario;
    
    private int numRegional;

    /**
     * 
     * @param ano 
     * @param regional
     * @throws Exception
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
        String comparaRegional = (regional.toLowerCase());
        if((comparaRegional.equals(a)) || (comparaRegional.equals(a2))){
            numRegional = 0; // Goiania
        }
        if((comparaRegional.equals(b)) || (comparaRegional.equals(b2))){
            numRegional = 1; // Cidade de Goias
        }
        if((comparaRegional.equals(c)) || (comparaRegional.equals(c2))){
            numRegional = 2; // Jataí
        }
        if((comparaRegional.equals(d)) || (comparaRegional.equals(d2))){
            numRegional = 3; // Catalão
        }
        if(numRegional == 99){
            throw new Exception(" O nome da regional digitado é inválido ");
        }
        try{
        control.adicionaAno(ano,numRegional);
        anoCalendario = ano;
        } catch(Exception e) {
            System.out.println(" Escolha um ano diferente. ");
        }
    }
    
}
