/******************************************************************
* 
* Author: Gabriel Paz.
          Andy Fuentes
          Andre Marroquin  
* Fecha de edicion 16/01/2023
* 
* This is the part of the program where all the menus are called from
* 
******************************************************************/
import java.util.Scanner;

public class Vista {

    /******************************************************************
     * 
     * This menu is the first thing sommeone sees when they start the program
     * 
     ******************************************************************/
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Controladora radioUVG = new Controladora();

        System.out.println("----------------RADIO SIMULATOR MENU--------------");
        System.out.println("1.ENCENDER RADIO \n2.CAMBIAR TIPO DE EMISORA \n3.AVANZAR DE EMISORA \n4.REGRESAR DE EMISORA \n5.GUARDAR EMISORA \n6.SELECCIONAR EMISORA \n7.APAGAR RADIO \n8.SALIR \nEscoja una opcion ");
        int opc = scan.nextInt();


        scan.nextLine();
        while (opc != 8) {
            switch (opc) {
                case 1:
                    radioUVG.encender();
                    
                break;
                case 2:
                    if(radioUVG.radio.isOn()){
                        try {
                            radioUVG.cambioFrecuencia();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("La radio se encuentra apagada");
                    }
                        
                break;
                case 3:

                    if(radioUVG.radio.isOn()){
                        radioUVG.adelantar();
                    }
                    else{
                        System.out.println("La radio se encuentra apagada");
                    }

                break;
                case 4:
                    if(radioUVG.radio.isOn()){
                        radioUVG.atrasar();
                    }
                    else{
                        System.out.println("La radio se encuentra apagada");
                    }

                break;
                case 5:
                    if(radioUVG.radio.isOn()){
                        System.out.println("Porfavor seleccione el slot donde guardara la emisora");
                        int slot = scan.nextInt();
                        radioUVG.guardar(slot);
                    }
                    else{
                        System.out.println("La radio se encuentra apagada");
                    }

                break;
                case 6:
                    if(radioUVG.radio.isOn()){
                        System.out.println("Porfavor seleccione el slot donde se encuentra su emisora");
                        int slot = scan.nextInt();
                        radioUVG.seleccionar(slot);
                    }
                    else{
                        System.out.println("La radio se encuentra apagada");
                    }
                    
                    

                break;
                case 7:
                    radioUVG.apagar();
                    

                break;
                default:
                    System.out.println("ELIJA UNA OPCION QUE ESTE DISPONIBLE EN EL MENÚ");
                break;

            }
            System.out.println("----------------RADIO SIMULATOR MENU--------------");
            System.out.println("1.ENCENDER RADIO \n2.CAMBIAR TIPO DE EMISORA \n3.AVANZAR DE EMISORA \n4.REGRESAR DE EMISORA \n5.GUARDAR EMISORA \n6.SELECCIONAR EMISORA \n7.APAGAR RADIO \n8.SALIR \nEscoja una opcion ");
            opc = scan.nextInt();
            scan.nextLine();
        }
    }
}
     