public class Puntos {
    private int puntos;
    private int lineas;

    public Puntos(){
        setPuntos();
        setLineas();
    }
    
    
    public int getPuntos() {
        return puntos;
    }

    private void setPuntos() {
        this.puntos = 0;
    }

    public void sumarPiezaColocada(){
        this.puntos+=10;
    }

    public void sumarLineas(int l){
        this.puntos+=l*100;
        this.lineas+=l;
            
    }

    public int getLineas() {
        return lineas;
    }

    private void setLineas() {
        this.lineas = 0;
    }
}
