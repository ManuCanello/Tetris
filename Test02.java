
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class Test02 implements KeyListener {
    
    private final Tablero tablero = new Tablero();
    private ArrayList<Fichas> fichas = new ArrayList<>();
    private int posX=4;
    private int posY=0;
    private static final long ms = 250;
    private long lastPressTime = 0;
    
    public static void main(String[] args) {
        new Test02();
    }

    public Test02(){
        JFrame pantalla = new JFrame();
        pantalla.setSize(0,0);
        pantalla.addKeyListener(this);
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setProximaFicha();
        setProximaFicha();
        tablero.setNextFicha(fichas.get(0));
        moverPieza();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'c'){
                
            long currentTime = System.currentTimeMillis();
        
            if (currentTime - lastPressTime <= ms) {
            
            } else {
                if(posY!=0)
                    posY--;
            }

            lastPressTime = currentTime;
            

        
            if(fichas.get(0).cambiarMat()){
                tablero.coiparTableroCopy();
            }
            
            fichas.get(0).rotarFicha();
        }

        if(e.getKeyChar() == 'd'){
            
            if(!colisionDerecha()){
                posX++;
                
                long currentTime = System.currentTimeMillis();
            
                if (currentTime - lastPressTime <= ms) {
                    
                } else {
                    if(posY!=0)
                        posY--;
                }

                lastPressTime = currentTime;
                
    
            }
        }

        if(e.getKeyChar() == 'a'){
            
            
            if(!colisionIzquierda()){
                posX--;
                
                long currentTime = System.currentTimeMillis();
            
                if (currentTime - lastPressTime <= ms) {
                
                } else {
                    if(posY!=0)
                        posY--;
                }

                lastPressTime = currentTime;
                
    
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            caerRapido();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public void imprimirPieza(){
        int y,x;
        y=fichas.get(0).numeroFila();
        x=fichas.get(0).numeroColumna();
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(fichas.get(0).getForma()[i][j]!= '0')
                    tablero.getTablero()[posY+i][posX+j] = fichas.get(0).getForma()[i][j]; 
                else{
                    if(fichas.get(0).getForma()[i][j] == ' ')
                        tablero.getTablero()[posY+i][posX+j] = ' ';
                }
            }
            
        }

        
    }

    public boolean colisionAbajo(){
        for(int i=posY;i<posY+fichas.get(0).numeroFila();i++){
            for(int j=posX;j<posX+fichas.get(0).numeroColumna();j++){
                if(tablero.getTablero()[i][j] == '1'){
                    if(tablero.getTablero()[i+1][j] != ' ' && tablero.getTablero()[i+1][j] != '1'){
                        return true;
                        }
                    }
            }
        }

            return false;
    }
    
    //revisar pq tiene delay
    public boolean colisionDerecha(){
        for(int i=posY;i<posY+fichas.get(0).numeroFila();i++){
            for(int j=posX;j<posX+fichas.get(0).numeroColumna();j++){
                if(tablero.getTablero()[i][j] == '1'){
                    if(tablero.getTablero()[i][j+1] != ' ' && tablero.getTablero()[i][j+1] != '1')
                        return true;
                    }
            }
        }

        return false;
    }

    public boolean colisionIzquierda(){
        
        for(int i=posY;i<posY+fichas.get(0).numeroFila();i++){
            for(int j=posX;j<posX+fichas.get(0).numeroColumna();j++){
                if(tablero.getTablero()[i][j] == '1'){
                    if(tablero.getTablero()[i][j-1] != ' ' && tablero.getTablero()[i][j-1] != '1')
                        return true;
                    }
            }
        }

        return false;
    }


    private void moverPieza(){
        boolean continuar = perdedor();
        while(!continuar){
        
            
            imprimirPieza();
            tablero.dibujarTablero();
            tablero.setNextFicha(fichas.get(1));
            Pantalla.esperar(tablero.getNivel().getVelocidad());
            Pantalla.borrarPantalla();
            
            if(!colisionAbajo()){
                posY++;
                tablero.coiparTableroCopy();
            }else{
                if(perdedor()){
                    continuar=true;
                }else{
                    setProximaFicha();
                    tablero.copiarTablero();
                    tablero.detectarLineas();
                    tablero.getPuntos().sumarPiezaColocada();
                    borrarFicha();
                    setProximaFicha(); 
                    resetearPos(); 
                }
            }
            
        }


        
    }


    

    public void borrarFicha(){
        fichas.remove(0);
    }

    public boolean perdedor(){
        for(int i=0;i<12;i++){
            if(tablero.getTablero()[3][i]=='@')
                return true;
        }

        return false;
    }

    public void resetearPos(){
        posY=0;
        posX=4;
        
    }

    private void setProximaFicha(){
        Random ra = new Random();
        int numero = ra.nextInt(7)+1;
        
        switch (numero) {
            case 1 -> {
                this.fichas.add(new T());
            }
            case 2 -> {
                this.fichas.add(new C());
            }
            case 3 -> {
                this.fichas.add(new L());
            }
            case 4 ->{
                this.fichas.add(new J());
            }
            case 5 ->{
                this.fichas.add(new I());
            }
            case 6 ->{
                this.fichas.add(new Z());
            }
            case 7 ->{
                this.fichas.add(new S());
            }
            default -> throw new AssertionError();
            }
        
    }



    public void setProxima(){
        tablero.setNextFicha(fichas.get(1));
    }

    public void caerRapido(){
        if(!colisionAbajo())
            posY++;
        
    }
    
}
