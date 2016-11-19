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
public class Controle {

    public Controle() {
        
    }

    private int[] vetorAno = new int[100];

    private int[] vetorRegional = new int[100];

    private int posicao = 0;

    public void adicionaAno(int ano, int regional) throws Exception {
        int x;
        boolean anoRepetido = false;
        for (x = 0; x <= posicao; x++) {
            if(vetorAno[x] == ano && vetorRegional[x] == regional){
                anoRepetido = true;
            }
        }
        
        if(anoRepetido == false){
            vetorAno[posicao] = ano;
            vetorRegional[posicao] = regional;
            posicao++;    
        } else {
            throw new Exception(" O calendário deste ano"
                    + " para esta regional já foi criado ");
        }
    }
}
