
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class Test02 implements KeyListener {
    Tablero tablero = new Tablero();
    ArrayList<Fichas> fichas = new ArrayList<>();
    
    int posX=4;
    int posY=0;
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
        addFicha();
        moverPieza();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        if(e.getKeyChar() == 'c'){
            Pantalla.borrarPantalla();
            tablero.dibujarTablero();
                
            long currentTime = System.currentTimeMillis();
        
            if (currentTime - lastPressTime <= ms) {
            
            } else {
                posY--;
            }

            lastPressTime = currentTime;
            

        
            if(fichas.get(0).cambiarMat()){
                tablero.coiparTableroCopy();
            }
            
            fichas.get(0).rotarFicha();
        }

        if(e.getKeyChar() == 'd'){
            Pantalla.borrarPantalla();
            tablero.dibujarTablero();
            if(!colisionDerecha()){
                posX++;
                
                long currentTime = System.currentTimeMillis();
            
                if (currentTime - lastPressTime <= ms) {
                    
                } else {
                    posY--;
                }

                lastPressTime = currentTime;
                
    
            }
        }

        if(e.getKeyChar() == 'a'){
            Pantalla.borrarPantalla();
            tablero.dibujarTablero();
            if(!colisionIzquierda()){
                posX--;
                
                long currentTime = System.currentTimeMillis();
            
                if (currentTime - lastPressTime <= ms) {
                
                } else {
                    posY--;
                }

                lastPressTime = currentTime;
                
    
            }
                
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

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

        tablero.dibujarTablero();
        
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
            Pantalla.esperar(tablero.getNivel().getVelocidad());
            Pantalla.borrarPantalla();
            
            if(!colisionAbajo()){
                posY++;
                tablero.coiparTableroCopy();
            }else{
                if(perdedor()){
                    continuar=true;
                }else{
                    tablero.copiarTablero();
                    tablero.detectarLineas();
                    tablero.getPuntos().sumarPiezaColocada();
                    borrarFicha();
                    addFicha();
                    resetearPos(); 
                }
            }
            
        }
        
    }


    private void addFicha(){
        fichas.add(getFichaAlAzar());
    }

    public void borrarFicha(){
        fichas.clear();
    }

    public boolean perdedor(){
        for(int i=1;i<11;i++){
            if(tablero.getTablero()[1][i]=='@')
                return true;
        }

        return false;
    }

    public void resetearPos(){
        posY=1;
        posX=4;
        
    }

    private Fichas getFichaAlAzar(){
        Random ra = new Random();
        int numero = ra.nextInt(7)+1;
        
        switch (numero) {
            case 1 -> {
                return new T();
            }
            case 2 -> {
                return new C();
            }
            case 3 -> {
                return new L();
            }
            case 4 ->{
                return new J();
            }
            case 5 ->{
                return new I();
            }
            case 6 ->{
                return new Z();
            }
            case 7 ->{
                return new S();
            }
            default -> throw new AssertionError();
        }
    }
}
