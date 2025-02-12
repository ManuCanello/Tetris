public class Z extends Fichas {
    private final char[][][] posicion = {
        {{'1','1','0'},
         {'0','1','1'}},
        
        {{'0','1'},
         {'1','1'},
         {'1','0'}},
        
};

    private final int [] matriz = {1};    

    public Z(){
        setForma(posicion[0]);
        setPosFicha(0);
        setCambiarMatriz(matriz);
    }



    @Override
    public void rotarFicha() {
        if(getPosFicha() != 1){
            setPosFicha(getPosFicha()+1);
            setForma(posicion[getPosFicha()]);
        }else{
            setPosFicha(0);
            setForma(posicion[getPosFicha()]);
        }
    }
}
