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

    /**
     * O método 'adicionaAno' registra todos os anos dos calendários das
     * diferentes regionais e compara o ano à ser criado com esses calendários
     * anteriores.
     *
     * @param ano Ano do calendário a ser criado.
     *
     * @param regional Número da regional a ser criado.
     *
     * @throws Exception Caso já exista um calendário para este ano na mesma
     * regional ocorre uma exceção.
     */

    public void adicionaAno(int ano, int regional) throws Exception {
        int x;
        boolean anoRepetido = false;
        if(posicao == 0){
            vetorAno[posicao] = ano;
            vetorRegional[posicao] = regional;
            posicao++;
        } else {
            for(x = 0; x < posicao; x++){
                if(vetorAno[x] == ano && vetorRegional[x] == regional){
                    anoRepetido = true;
                }
            }
            if (anoRepetido == false) {
                vetorAno[posicao] = ano;
                vetorRegional[posicao] = regional;
                posicao++;
            } else {
                throw new Exception("O calendário deste ano para esta regional"
                        + " já foi criado!");
            }
        }
    }
    
    /**
     * Este método serve para ao adicionar as datas e os eventos, 
     * verificar se o calendário onde está sendo adicionado existe,
     * caso existir o método retorna true
     * caso não existir o método retorna false.
     * @param ano Ano do evento à ser adicionado.
     * @param regional Reginal do evento à ser adicionado.
     */
    public boolean verificaAnoExistente(int ano, int regional) {
        int x;
        for(x = 0; x < posicao; x++){
            if(vetorAno[x] == ano && vetorRegional[x] == regional){
                return true;
            }
        }
        return false;
    }
}