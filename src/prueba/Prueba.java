/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.Scanner;

/**
 *
 * @author Alumnos
 */
public class Prueba {

    /**
     * @param origen
     * @return 
     */
    //si es letra minuscula falso *si es v de vaca estrangero sino es nacional caracter extraño falso.
    /*Si es V return false
      -----si es una letra  del ABC en mayusculas Excepto V, return true
      Si es otro simbolo return false
      *si es una letra del abc en minusculas, return false*/
      public static boolean esNacional(char origen){
          boolean resp=true;
        if(origen=='V' || !Character.isAlphabetic(origen) || Character.isLowerCase(origen)){
            resp =false;
        }
        if(resp==true){
            System.out.println("true");
            return true;
        }else{
            System.out.println("false");
            return false;
      }
      }
      
      //Fecha=2018-dic-20
      /*Fecha=2018-feb-29   return "Año no es bisiesto"
        Fecha= 2018-Enero-50 return "No hay dia 50"*/
      private static String FormatearFecha(String fecha){
         int nDia=0;
         boolean bisiesto=true;
         String mSelec="";
          String[][] arrayday={{"Ene","Feb","Mar","Abr","May","Jun","Jul","Agos","Sep","Oct","Nov","Dic"},{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"}};
         //boolean resp=true;
         CharSequence csYear= fecha.subSequence(0, 4);
         CharSequence csMes= fecha.subSequence(5,8);
         CharSequence csDia= fecha.subSequence(9,11);
         String mes=(String) csMes;
         int year=Integer.parseInt((String) csYear);
         int dia=Integer.parseInt((String) csDia);
         for(int i=0;i<arrayday.length;i++){
             for (int j = 0; j < arrayday[i].length; j++) { 
                if(mes.equalsIgnoreCase(arrayday[0][j])){
                  mSelec=arrayday[1][j];
                } 
             }
         }
        //verifico si el anio es bisiesto.
            if(mes.equalsIgnoreCase("ene")||mes.equalsIgnoreCase("mar")||
                    mes.equalsIgnoreCase("may")||mes.equalsIgnoreCase("jul")||
                    mes.equalsIgnoreCase("ago")||mes.equalsIgnoreCase("dic")){

                nDia=31;
                bisiesto=false;
            }else if(mes.equalsIgnoreCase("abr")||mes.equalsIgnoreCase("jun")||
                     mes.equalsIgnoreCase("sep")||mes.equalsIgnoreCase("nov")){
                     nDia=30;
                     bisiesto=false;
            }else if(mes.equalsIgnoreCase("feb")){
                if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))){
                 nDia=29;
                 bisiesto= true;
                }else{
                  bisiesto=false;
                  nDia=28;  
                }
            } 
           if(!bisiesto && "feb".equalsIgnoreCase(mes)){
                if(dia>nDia && dia<30){
                    System.out.println("→El anio " + year +" no es bisiesto.");
                }else if(dia>=30 || dia==0){
                    System.out.println("→No existe el dia " + csDia); 
                }else{
                    System.out.println("→Datos correctos= "+ year+'-'+mSelec+'-'+csDia); 
                }
            }else if(bisiesto || !bisiesto){
                   if(dia>nDia || dia<=0){
                        System.out.println("→No existe el dia " + csDia); 
                    }else{
                       System.out.println("→Datos correctos= "+ year+'-'+mSelec+'-'+csDia); 
                   }
            }
        return "";  
      }
      
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado=new Scanner(System.in);
        int opcion=0;
        String fecha="";
        boolean a=true;
        //String fecha;
        /*
        System.out.println("Ingresa Origen de producto"); 
        char origen=teclado.nextLine().charAt(0);
        esNacional(origen);
        System.out.println("------------------------------------------------------"); 
        System.out.println("Ingrese Fecha        ---2018-MES-DIA  <2018-Mar-01>---");
        fecha=teclado.nextLine();
        FormatearFecha(fecha); */
        //-/*
    try{
        do{
            System.out.println("Menu ");
            System.out.println("1). Productos");
            System.out.println("2). Salir");
            System.out.println("Ingresa Opcion");
            opcion=teclado.nextInt();
            
            char origen;
            switch(opcion){
                case 1:
                     System.out.println("Ingresa Origen de producto"); 
                     origen=teclado.next().charAt(0);
                     teclado.nextLine();
                     if(esNacional(origen)==true){
                        do{
                         System.out.println("Ingrese Fecha        ---AÑO-MES-DIA  <2018-Mar-01 -- -1 for Exit");
                          fecha=teclado.nextLine();
                         a=fecha.matches("\\d{4}-[a-z]{3}-\\d{2}");
                         if(a){
                             System.out.println(FormatearFecha(fecha));
                         }
                        }while(!"-1".equalsIgnoreCase(fecha));
                     }else{
                         System.out.println("Compre la version GOLD");
                         //opcion=2;
                     }
                
                    
            }   
        }while(opcion!=2);
    } 
    catch (Exception e) {
     System.out.println("Warning: Ha introducido un dato incorrecto...");
    }
    }
}
