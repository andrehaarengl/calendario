/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.mds.calendario;

import java.util.GregorianCalendar;

/**
 *
 * @author Murillo Nunes
 */
public class Data {

    /**
     * Esse método verifica a validade de datas. Nesse projeto, será utilizado
     * para validar datas no método de pesquisa filtradas por datas, além do
     * método de inserção de eventos ao calendário.
     *
     * @param data Esse parâmetro deve ser uma string. A principio, será
     * no padrão dd/mm/aaaa, porém o método reconhece nos formatos: ddmmaaaa,
     * dd.mm.aaaa, etc.
     *
     * @return Retorna true para uma data válida e false para uma data inválida.
     */
    public static boolean validaData(String data) {
        data = (data == null ? "" : data).replaceAll("[^0-9]*", "");  

        if (data.length() == 8) {  
            Integer dia = Integer.valueOf(data.substring(0, 2));  
            Integer mes = Integer.valueOf(data.substring(2, 4)) - 1;  
            Integer ano = Integer.valueOf(data.substring(4, 8));  

            if (mes < 0 || mes > 11) {  
                return false;  
            }  

            GregorianCalendar calendario = new GregorianCalendar();  
            calendario.set(ano, mes, 1);  

            if (dia <= 0 || dia > calendario.getActualMaximum(
                    calendario.DAY_OF_MONTH)) {  
                return false;  
            }  

            return true;  
        }  

        return false;  
    }
}
