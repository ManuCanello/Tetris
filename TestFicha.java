import java.util.ArrayList;

public class TestFicha {
    

    public static void main(String[] args) {
        new TestFicha();
    }

    private ArrayList<Ficha> lista = new ArrayList<>();
    private final int[][] fondo = new int[6][6];
    private int startY=0;
    private int startX=0;


    public TestFicha(){
        setArray();
        setMatriz();
        setFichas();
    }

    public void setArray(){
        for(int i=1;i<4;i++){
            lista.add(new Ficha(i));
        }
    }

    public void setFichas(){
        int y,x;
        for(Ficha f: lista){
            y=f.getFicha().length;
            x=f.getFicha()[0].length;
            for(int p =0;p<5;p++){
                for(int i=0;i<y;i++){
                    for(int j=0;j<x;j++){
                        fondo[startX+i][startY+j] = f.getFicha()[i][j];
                    }
                }
                imprimir();
                setMatriz();
                startX++;
                System.out.println("--------------");
                
            }
            startX=0;
            startY=0;
        }
    }

    private void imprimir(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(fondo[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public void setMatriz(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                fondo[i][j]=0;
            }
        }
    }

}
