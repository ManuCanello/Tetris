public class I extends Fichas{
    private final char[][][] posicion = {
        {{'0','1','0'},
         {'0','1','0'},
         {'0','1','0'},
         {'0','1','0'}},
        //---------
        {{'1','1','1','1'},},
};

    private final int [] matriz = {1};    

    public I(){
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
