public class C extends Fichas {

    private final char[][][] posicion = {
                                        {{'1','1'},{'1','1'}},
        
    };

    private final int [] matriz = {1};    

    public C(){
        setForma(posicion[0]);
        setPosFicha(0);
        setCambiarMatriz(matriz);
    }
    
    
    @Override
    public void rotarFicha() {
        
    }
    
}
