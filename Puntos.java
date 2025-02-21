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
        switch (l) {
            case 1 -> {
                this.puntos+=100;
                this.lineas++;
                
            }
            case 2 -> {
                this.puntos+=200;
                this.lineas+=2;
                
            }
            case 3 -> {
                this.puntos+=300;
                this.lineas+=3;
                
            }
            case 4 -> {
                this.puntos+=400;
                this.lineas+=4;
                
            }
            default -> {
            }
                
        }
    }

    public int getLineas() {
        return lineas;
    }

    private void setLineas() {
        this.lineas = 0;
    }
}
