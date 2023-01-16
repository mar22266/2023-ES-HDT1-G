public class Radio implements IRadio{

    private String frequence;
    private boolean on;
    private double FMActualStation;
    private int AMActualStation;
    private double[] FMSlot = new double[12];
    private int[] AMSlot = new int[12];

    public Radio(){
        this.frequence = "AM";
        this.on = false;
        this.FMActualStation = 87.9;
        this.AMActualStation = 530;
    }



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
        try{
            if(freq.equals("AM") || freq.equals("FM")){
                this.frequence = freq;
            }else{
                throw new Exception("Error");
            }}
            catch(Exception e){
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
            }else{
                this.AMActualStation += 10;
            }
        }else{
            if(this.FMActualStation == 107.9){
                this.FMActualStation = 87.9;
            }else{
                this.FMActualStation += 0.2;
            }
        }
    }

    @Override
    public void Backward() {
        if(this.frequence.equals("AM")){
            if(this.AMActualStation == 530){
                this.AMActualStation = 1610;
            }else{
                this.AMActualStation -= 10;
            }
        }else{
            if(this.FMActualStation == 87.9){
                this.FMActualStation = 107.9;
            }else{
                this.FMActualStation -= 0.2;
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
        this.FMSlot[slot] = actualStation;
    }

    @Override
    public void saveAMStation(int actualStation, int slot) {
        this.AMSlot[slot] = actualStation;
    }

    @Override
    public double getFMSlot(int slot) {
        return FMSlot[slot];
    }

    @Override
    public int getAMSlot(int slot) {
        return AMSlot[slot];
    }
}