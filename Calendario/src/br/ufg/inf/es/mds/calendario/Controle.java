/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.mds.calendario;

/**
 *
 * @author Paulo Sales
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
        for(x = 0; x <= posicao; x++){
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
