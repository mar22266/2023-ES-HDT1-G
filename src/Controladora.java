/*
 * Andre marroquin
 * Gabriel Paz
 * Andy Fuentes
 * HT 1 ESTRUCTURA DE DATOS
 *
 * */

public class Controladora {
    public IRadio radio = new Radio();

    public void encender(){
        if(radio.isOn()){
            System.out.println("La radio ya está encendida");
        }else{
            radio.on();
            System.out.println("ENCENDIENDO RADIO...");
        }
    }

    public void apagar(){
        if(radio.isOn()){
            radio.off();
            System.out.println("APAGANDO RADIO...");
        }else{
            System.out.println("La radio ya está apagada");
        }
    }

    public void cambioFrecuencia() throws Exception{
        radio.setFrequence(radio.getFrequence());
    }

    public void adelantar(){
        radio.Forward();
    }

    public void atrasar(){
        radio.Backward();
    }

    public void guardar(int slot){
        if(radio.getFrequence().equals("AM")){
            radio.saveAMStation(radio.getAMActualStation(), slot);
        }else{
            radio.saveFMStation(radio.getFMActualStation(), slot);
        }
    }

    public void seleccionar(int slot){
        if(radio.getFrequence().equals("AM")){
            radio.setAMActualStation(radio.getAMSlot(slot));
        }else{
            radio.setFMActualStation(radio.getFMSlot(slot));
        }
    }
}
