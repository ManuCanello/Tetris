public abstract class Fichas {
    
    private char[][] forma;
    private char[][][] posicion;
    private int posFicha;
    private int[] cambiarMatriz;

    public abstract void rotarFicha();

    public char[][] getPosicion(int p){
        return posicion[p];
    }

    public int getPosFicha() {
        return posFicha;
    }


    public boolean cambiarMat(){
        for(int i=0;i<cambiarMatriz.length;i++){
            if(cambiarMatriz[i] == getPosFicha())
                return true;
        }

        return false;
    }
    

    public void setCambiarMatriz(int[] array){
        this.cambiarMatriz = array;
    }

    public void setPosFicha(int posFicha) {
        this.posFicha = posFicha;
    }

    public char[][] getForma() {
        return forma;
    }

    public void setForma(char[][] forma) {
        this.forma = forma;
    }

    public int numeroFila(){
        return this.forma.length;
    }

    public int numeroColumna(){
        return this.forma[0].length;
    }

}
