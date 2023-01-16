public class Controladora {
    public IRadio radio = new Radio();

    public void turn(){
        if(radio.isOn()){
            radio.off();
        }else{
            radio.on();
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
