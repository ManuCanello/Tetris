import java.util.ArrayList;

public class TestBajarLineas{
    
    public static void main(String[] args) {
        new TestBajarLineas();
    }
    
    
    char[][] matriz = new char[7][3];

    public TestBajarLineas(){
        setMatriz();
        imprimirMatriz();
        System.out.println("");
        detectarLineas();
        System.out.println("\n");
        imprimirMatriz();
        System.out.println("");
    }


    private void setMatriz(){
        for(int i=0;i<7;i++){
            for (int j= 0; j < 3; j++) {
                if(i==6 || i==5 || i==4){
                    matriz[i][j] = '@';
                }else{
                    if(i==3 && j==1 || i==3 && j==2 || i==2 && j==0)
                        matriz[i][j] = '@';
                    else
                        matriz[i][j] = ' ';
                }
            }
        }
    }


    private void imprimirMatriz(){
        for(int i=0;i<7;i++){
            for (int j= 0; j < 3; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private void detectarLineas(){
        ArrayList<Integer> lineas = new ArrayList<>();
        int c=0;
        for(int i=0;i<7;i++){
            for (int j= 0; j < 3; j++) {
                if(matriz[i][j]=='@')
                    c++;
                else{
                    c=0;
                    break;
                }
            }
            if(c==3){
                c=0;
                lineas.add(i);
            }
        }

        for(int s : lineas){
            System.out.print(s+" ");
        }

        if(!lineas.isEmpty())
            borrarLineas(lineas);
    }

    private void borrarLineas(ArrayList<Integer> lineas){
        for(int l : lineas){
            for (int j= 0; j < 3; j++) {
                matriz[l][j] = ' ';
            }
        }

        moverHaciaAbajo(lineas);
    }

    private void moverHaciaAbajo(ArrayList<Integer> lineas){
        

        for(int l:lineas){
            for(int i=l;i>0;i--){
                for(int j=0;j<3;j++){
                    matriz[i][j] = matriz[i-1][j];
                }
            }
        }

    }
}