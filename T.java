public class T extends Fichas {

    private final char[][][] posicion = {
                                    {{'0','1','0'},
                                     {'1','1','1'}},
                                    
                                    {{'0','1','0'},
                                     {'0','1','1'},
                                     {'0','1','0'}},
                                    
                                    {{'1','1','1'},
                                     {'0','1','0'}},
                                    
                                    {{'0','1','0'},
                                     {'1','1','0'},
                                     {'0','1','0'}}
    };
    
    private final int [] matriz = {1,3};    
    
    public T(){
        setForma(posicion[0]);
        setPosFicha(0);
        setCambiarMatriz(matriz);
    }

    

    @Override
    public void rotarFicha() {
        if(getPosFicha() != 3){
            setPosFicha(getPosFicha()+1);
            setForma(posicion[getPosFicha()]);
        }else{
            setPosFicha(0);
            setForma(posicion[getPosFicha()]);
        }
    }

   
    
}
