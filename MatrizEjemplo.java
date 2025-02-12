
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;



public class MatrizEjemplo implements KeyListener {
    
    public static void main(String[] args) {
        new MatrizEjemplo();
    }
    
    private int x=0;
    private int y=0;
    private final int matriz[][] = new int[18][10];
    private int[] unos={1,1,1,1,1,1,1,1,1,1,1};
    

    public MatrizEjemplo(){
        JFrame pantalla = new JFrame();
        pantalla.setSize(0,0);
        pantalla.addKeyListener(this);
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMatiz();
        mover1();
    }
    
    private void setMatiz(){
        for(int i=0;i<18;i++){
            for(int j=0;j<10;j++){
                matriz[i][j]=0;
            }
        }
    }

    private void dibujarMatriz(){
        for(int i=0;i<18;i++){
            for(int j=0;j<10;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void mover1(){
        for(int a : unos){
            for(int i=0;i<18;i++){
                if(y>0)
                    matriz[y-1][x]=0;
                
                matriz[y][x]=a;
                
                if(colision())
                    i=17;
                
                if(y==17 || i==17){
                    y=0;
                    x=0; 
                }else
                    y++;
                
                

                dibujarMatriz();
                esperar();
                borrarPantalla();
            }
            verLinea();
        }
        
        
    }
    

    private boolean colision(){
        if(y!=17){
            return matriz[y+1][x] == 1;
        }else{
            return false;
        }


    }

    private void verLinea(){
        int cont = 0;
        for(int i=0;i<18;i++){
            for(int j=0;j<10;j++){
                if(matriz[i][j]==0)
                    break;
                else
                    cont++;
            }
            if(cont == 10){
                System.out.println("Linea "+(i+1)+" llena");
                limpiarLinea(i);
            }
            cont=0;
            
        }
    }

    private void limpiarLinea(int linea){
        for(int i=0;i<10;i++){
            matriz[linea][i]=0;
        }
    }


    private void esperar(){
        try {
            Thread.sleep(500);  
        } catch (InterruptedException e) {
            
        }
    }

    private void borrarPantalla(){
        System.out.print("\033[H\033[2J");
    }

    private void borrarPosicionX(int by, int bx){
        matriz[by][bx] = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'd' && x<9){
            int bx,by;
            bx = x;
            by = y-1;
            System.out.println("y:"+by+"x: "+bx);
            borrarPosicionX(by,bx);
            x++;
        }
            
        if(e.getKeyChar()=='a' && x>0){
            int bx,by;
            bx = x;
            by = y-1;
            System.out.println("y:"+by+"x: "+bx);
            borrarPosicionX(by,bx);
            x--;
        }
            
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    

}
