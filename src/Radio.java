/*
 * Andre Marroquin
 * Gabriel Paz
 * Andy Fuentes
 * HT 1 ESTRUCTURA DE DATOS
 *
 * */

public class Radio implements IRadio{

    //ATRIBUTOS PRIVADOS PARA LA CLASE RADIO
    private String frequence;
    private boolean on;
    private double FMActualStation;
    private int AMActualStation;
    private double[] FMSlot = new double[12];
    private int[] AMSlot = new int[12];

    //CONTRUCTOR
    public Radio(){
        this.frequence = "AM";
        this.on = false;
        this.FMActualStation = 87.9;
        this.AMActualStation = 530;
    }


//IMPLEMENTACION DE LOS METODOS DE LA INTERFAZ IRADIO
    @Override
    public void on() {
        this.on = true;

    }

    @Override
    public void off() {
        this.on = false;

    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void setFrequence(String freq) throws Exception {
        try {
            if(freq.equals("AM")){
                this.frequence = "FM";
                System.out.println("LA RADIO ESTA EN FM");
        }else if(freq.equals("FM")){
                this.frequence = "AM";
                System.out.println("LA RADIO ESTA EN AM");
        }else{
                throw new Exception("Frecuencia no valida");
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }

    @Override
    public String getFrequence() {
        return frequence;
    }

    @Override
    public void Forward() {
        if(this.frequence.equals("AM")){
            if(this.AMActualStation == 1610){
                this.AMActualStation = 530;
                System.out.println(getAMActualStation());
            }else{
                this.AMActualStation += 10;
                System.out.println(getAMActualStation());
            }
        }else{
            if(this.FMActualStation == 107.9){
                this.FMActualStation = 87.9;
                System.out.println(getFMActualStation());
            }else{
                this.FMActualStation += 0.2;
                System.out.println(getFMActualStation());
            }
        }
    }

    @Override
    public void Backward() {
        if(this.frequence.equals("AM")){
            if(this.AMActualStation == 530){
                this.AMActualStation = 1610;
                System.out.println(getAMActualStation());
            }else{
                this.AMActualStation -= 10;
                System.out.println(getAMActualStation());
            }
        }else{
            if(this.FMActualStation == 87.9){
                this.FMActualStation = 107.9;
                System.out.println(getFMActualStation());
            }else{
                this.FMActualStation -= 0.2;
                System.out.println(getFMActualStation());
            }
        }
    }

    @Override
    public double getFMActualStation() {
        return FMActualStation;
    }

    @Override
    public int getAMActualStation() {
        return AMActualStation;
    }

    @Override
    public void setFMActualStation(double actualStation) {
        this.FMActualStation = actualStation;


    }

    @Override
    public void setAMActualStation(int actualStation) {
        this.AMActualStation = actualStation;
    }

    @Override
    public void saveFMStation(double actualStation, int slot) {
        this.FMSlot[slot-1] = actualStation;
        System.out.println("Emisora "+ actualStation +" guardada en el slot "+slot);
    }

    @Override
    public void saveAMStation(int actualStation, int slot) {
        this.AMSlot[slot-1] = actualStation;
        System.out.println("Emisora "+ actualStation +" guardada en el slot "+slot);
    }

    @Override
    public double getFMSlot(int slot) {
        return FMSlot[slot-1];
    }

    @Override
    public int getAMSlot(int slot) {
        return AMSlot[slot-1];
    }

}