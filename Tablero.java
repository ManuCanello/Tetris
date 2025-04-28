import java.util.ArrayList;

public class Tablero {
    
    private final char[][] tablero = new char[24][12];
    private final char[][] tableroCopy = new char[24][12];
    private final Puntos puntos = new Puntos();
    private Niveles nivel = new Niveles();
    private Fichas nextFicha;

    
    


    public Tablero(){
        setTablero();
    }


    private void setTablero(){
        for(int i=0;i<24;i++){
            for(int j=0;j<12;j++){
                
                if(j==0 && i>3 || j==11 && i>3 )
                    tablero[i][j]= '#';
                else
                    tablero[i][j]= ' ';
                
                if(i==23)
                    tablero[i][j]= '#';  
            } 
        }
        copiarTablero();
    }


    public void copiarTablero(){
        cambiarSigno();
        for(int i=0;i<24;i++){
            System.arraycopy(tablero[i], 0, tableroCopy[i], 0, 12); 
        }
    }

    public void coiparTableroCopy(){
        for(int i=0;i<24;i++){
            System.arraycopy(tableroCopy[i], 0, tablero[i], 0, 12); 
        }
    }

    public char[][] getTablero() {
        return tablero;
    }

    public char[][] getTableroCopy() {
        return tableroCopy;
    }

    public void dibujarTablero(){
        for(int i=0;i<24;i++){
            for(int j=0;j<12;j++){
                System.out.print(tablero[i][j]+" ");
                if(i==4 && j==11)
                    System.out.print("Puntaje:"+puntos.getPuntos());
                if(i==5 && j==11)
                    System.out.print("Lineas:"+puntos.getLineas());
                if(i==6 && j==11)
                    System.out.print("Nivel:"+nivel.getNivel());
                if(i==7 && j==11)
                    System.out.print("Proxima");
            }
            if(i>=8 && i<8+nextFicha.numeroFila()){
                System.out.print(" ");
                for(int j=0; j < nextFicha.numeroColumna();j++ ){
                    if(nextFicha.getForma()[i-8][j]!='0')
                        System.out.print(nextFicha.getForma()[i-8][j]+" ");
                    else
                        System.out.print("  ");
                }
            }
            System.out.println("");
        }

            

    }
    

    private void cambiarSigno(){
        for(int i=0;i<24;i++){
            for(int j=0;j<12;j++){
                if(tablero[i][j]=='1'){
                    tablero[i][j]='@';
                }
            } 
        }
    }


    public void detectarLineas(){
        ArrayList<Integer> lineas = new ArrayList<>();
        int c=0;
        for(int i=4;i<23;i++){
            for (int j= 1; j < 11; j++) {
                if(tablero[i][j]=='@')
                    c++;
                else{
                    c=0;
                    break;
                }
            }
            if(c==10){
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
            animacionLineas(l,lineas.size());
            for (int j= 1; j < 11; j++) {
                tablero[l][j] = ' ';
            }
            
        }

        moverHaciaAbajo(lineas);
    }

    private void moverHaciaAbajo(ArrayList<Integer> lineas){
        

        for(int l:lineas){
            for(int i=l;i>1;i--){
                System.arraycopy(tablero[i-1], 1, tablero[i], 1, 10);
            }
        }

        puntos.sumarLineas(lineas.size());
        copiarTablero();
    }

    private void animacionLineas(int linea,int numeroLineas){
        String palabrasLineas[] = {"SINGLE","DOUBLE","TRIPLE","TETRIS"};
        int t = 0;
        for(int j=1;j<11;j++){
            if(t!=palabrasLineas[numeroLineas-1].length()){
                tablero[linea][j] = palabrasLineas[numeroLineas-1].charAt(t);
                t++;
            }
                
            else
                tablero[linea][j] = '-';
            
            dibujarTablero();
            Pantalla.esperar(25);
            Pantalla.borrarPantalla();
            
        }
    }


    public Puntos getPuntos() {
        return puntos;
    }

    public Niveles getNivel() {
        return nivel;
    }

    public Fichas getNextFicha() {
        return nextFicha;
    }

    public void setNextFicha(Fichas nextFicha) {
        this.nextFicha = nextFicha;
        
    }

    public void setNivel(Niveles nivel) {
        this.nivel = nivel;
    }




}
