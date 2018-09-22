/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField;

/**
 *
 * @author Windows
 */
public class Global {
    
    public static boolean AnoBissexto(Integer ano) {
        return ano % 4 == 0 && ano % 100 == 0 && ano % 400 == 0;
    }

    
        public static boolean dataValida(String Dt) {
        try {
            //variaveis que recebem o valor
            Integer Dia, Mes;
            Integer Ano;
            //retorno padrão
            
           //Obtendo as informações da data atual. 
           Calendar cal = Calendar.getInstance();
           int anoAtual = cal.get(Calendar.YEAR);
           int mesAtual = cal.get(Calendar.MONTH) + 1;
           int diaAtual = cal.get(Calendar.DATE);
           
            //Se a data estiver completa
            if (Dt.trim().length() == 10 || Dt.trim().length() == 16) {
                //quebra a string
                Dia = Integer.parseInt(Dt.substring(0, 2));
                Mes = Integer.parseInt(Dt.substring(3, 5));
                Ano = Integer.parseInt(Dt.substring(6, 10));
                //verifica variaveis
                if ((Dia <= diaAtual && Mes <= mesAtual && Ano <= anoAtual) || (Dia >= diaAtual &&  Mes >= mesAtual && Ano < anoAtual)) {
                if (
                        ((Mes.equals(1) || Mes.equals(3) || Mes.equals(5) || Mes.equals(7) || Mes.equals(8) || Mes.equals(10) || Mes.equals(12)) && (Dia >= 1 && Dia <= 31))
                                ||
                                ((Mes.equals(4) || Mes.equals(6) || Mes.equals(9) || Mes.equals(11)) && (Dia >= 1 && Dia <= 30))
                                ||
                                ((Mes.equals(2)) && (AnoBissexto(Ano)) && (Dia >= 1 && Dia <= 29))
                                ||
                                ((Mes.equals(2)) && (!AnoBissexto(Ano)) && (Dia >= 1 && Dia <= 28))
       
                        ) {
                    return true;
                } else {
                    return false;
                } 
                } else{
                return false; 
                }  
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
        
 public static String converterData(String data, String formatoInicial, String formatoDesejado) {
        String wDataConvertida = "";
        try {
            java.text.DateFormat parser = new SimpleDateFormat(formatoInicial);
            java.text.DateFormat formatter = new SimpleDateFormat(formatoDesejado);

            wDataConvertida = formatter.format(parser.parse(data));

        } catch (java.text.ParseException ex) {
            System.out.println(ex.getMessage().toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
        } finally {
            return wDataConvertida;
        }
    }
 
   public static String converteData(java.util.Date dtData){
   SimpleDateFormat formatBra;   
   formatBra = new SimpleDateFormat("dd/MM/yyyy");
   try {
      java.util.Date newData = formatBra.parse(dtData.toString());
      return (formatBra.format(newData));
   } catch (ParseException Ex) {
      return "Erro na conversão da data";
   }
}
}
