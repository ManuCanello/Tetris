
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Test01 implements KeyListener {
    Tablero tablero = new Tablero();
    T l = new T();
    int posX=1;
    int posY=1;
    public static void main(String[] args) {
        new Test01();
        
        
    }

    public Test01(){
        JFrame pantalla = new JFrame();
        pantalla.setSize(0,0);
        pantalla.addKeyListener(this);
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        moverPieza();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'c'){
            if(l.getPosFicha()==1 || l.getPosFicha()==3){
                tablero.coiparTableroCopy();
            }
            l.rotarFicha();
        }

        if(e.getKeyChar() == 'd'){
            posX++;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public void imprimirPieza(){
        int y,x;
        y=l.getForma().length;
        x=l.getForma()[0].length;
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(l.getForma()[i][j]!= '0')
                    tablero.getTablero()[posY+i][posX+j] = l.getForma()[i][j]; 
                else
                    tablero.getTablero()[posY+i][posX+j] = ' '; 
            }
            
        }

        tablero.dibujarTablero();
        
    }

    public boolean colision(){
        for(int i=posX;i<posX+l.getForma()[0].length;i++){
            if(tablero.getTablero()[posY+l.getForma().length-1][i] == '1'){
                if(tablero.getTablero()[posY+l.getForma().length][i] != ' ')
                    return true;
            }
        }

        return false;
    }

    public void moverPieza(){
        boolean continuar;
        do{
            continuar = colision();
            imprimirPieza();
            Pantalla.esperar(1000);
            Pantalla.borrarPantalla();
            
            if(!colision()){
                posY++;
                tablero.coiparTableroCopy();
            }else{
                tablero.copiarTablero();
            }
                
            
        }while(!continuar);
    }
}
