import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Panel2 extends JPanel{
    static int vancho= 1300;
    static int valto= 130;
    
    int A[];
    int colorBarras[];
    
    Inicio obj= new Inicio();
    int numbar= obj.obtenerNum();
    int anchbar= vancho/numbar;
    
    
    public Panel2(){
        setBackground(Color.ORANGE);
        A= new int[numbar];
        colorBarras= new int[numbar];
        
        for(int i=0; i<numbar; i++){
            A[i]= i;
            colorBarras[i]= 0;
        }
    }
    
    
    public void intercambiar(int p, int q){
        try {
            int temp= A[p];
            A[p]= A[q];
            A[q]= temp;
            
            colorBarras[p]= 100;
            colorBarras[q]= 100;
            
            repaint();
            
            Thread.sleep(20);
        } catch (InterruptedException ex) {
        }
    }
    
    
    public void desordenar(){
        Random ran= new Random();
        for (int i = 0; i < A.length; i++) {
            int k= ran.nextInt(A.length - 1);
            intercambiar(i, k);
        }
    }
    
    
    public void reiniciarColores(){
        for(int i=0; i<numbar; i++){
            colorBarras[i]= 0;
        }
        repaint();
    }
    
    
    public void realzar() {
        for (int i = 0; i < A.length; i++) {
            colorBarras[i]= 100;
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(anchbar*numbar, valto);
    }    
    
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D graf= (Graphics2D)g;
        super.paintComponent(graf);
        graf.setColor(Color.white);
        
        for(int j=0; j<numbar; j++){
            int redon= (int)Math.ceil(numbar/130.0);
            int redon2= (int)Math.floor(130.0/numbar);
            int alt= A[j];
            
            if(numbar<=130 && numbar>65){
                alt= A[j];
            } else if(numbar<65){ 
                alt= A[j]*redon2;
            } else{
                alt= A[j]/redon;
            }
            
            int xini= (j+(anchbar-1)*j);
            int yini= valto-alt;
            
            int val = colorBarras[j] * 2;
            graf.setColor(new Color(255-val, 255, 255-val));
            graf.fillRect(xini, yini, anchbar, alt);
            if (colorBarras[j] > 0) {
                colorBarras[j]-= 10;
            }
        }
    }
    
    
    public void heapify(int Array[], int m, int i){
        int largest=i;
        int l= 2*i+1;
        int r= 2*i+2;
        if(l<m && Array[l]>Array[largest]){
            largest= l;
        }
        if(r<m && Array[r]>Array[largest]){
            largest= r;
        }
        if(largest!=i){
            intercambiar(i, largest);
            
            heapify(Array, m, largest);
        }
    }
    
    public void maxHeap(int Array[]){
        int m= Array.length;
        for(int i=(m/2)-1; i>=0; i--){
            heapify(Array,m,i);
        }
    }
    
    public void heapSort(int Array[]){
        maxHeap(Array);
        for(int i=Array.length-1; i>0; i--){
            intercambiar(0, i);
            
            heapify(Array, i, 0);
        }
    }
}
