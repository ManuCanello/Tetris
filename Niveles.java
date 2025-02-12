public class Niveles {
    private int nivel;
    private int velocidad;
    private int proximoNivel;

    public Niveles(){
        this.nivel=0;
        this.velocidad=1000;
        this.proximoNivel=20;
    }
    
    
    public int getNivel() {
        return nivel;
    }

    public void nextNivel() {
        if(nivel<=9){
            this.nivel++;
            this.velocidad-=100;
            setProximoNivel();
        }
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getProximoNivel() {
        return proximoNivel;
    }

    public void setProximoNivel() {
        this.proximoNivel+=20;
    }

    
}
