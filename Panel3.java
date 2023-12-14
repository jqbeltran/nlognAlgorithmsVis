import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Panel3 extends JPanel {
    static int vancho= 1300;
    static int valto= 130;
    
    int A[];
    int colorBarras[];
    
    Inicio obj= new Inicio();
    int numbar= obj.obtenerNum();
    int anchbar= vancho/numbar;
    
    
    public Panel3(){
        setBackground(Color.magenta);
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
            graf.setColor(new Color(255, 255-val, 255-val));
            graf.fillRect(xini, yini, anchbar, alt);
            if (colorBarras[j] > 0) {
                colorBarras[j]-= 10;
            }
        }
    }
    
    
    public void Merge(int[] Array, int p, int q, int r){
        int n1= q-p+1;
        int n2= r-q;
        
        int[] L= new int[n1];
        int[] R= new int[n2];
        
        for(int i=0; i<n1; ++i){
            L[i]= Array[p+i];
        }
        for(int j=0; j<n2; ++j){
            R[j]= Array[q+1+j];
        }
        
        int i=0;
        int j=0;
        
        int k=p;
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                Array[k] = L[i];
                colorBarras[k]= 100;
                repaint();
                
                try { 
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                }
                
                i++;
                
            } 
            else { 
                Array[k] = R[j]; 
                colorBarras[k]= 100;
                repaint();
                
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                }
                
                j++; 
            } 
            k++; 
        } 
        
        while (i < n1) { 
            Array[k] = L[i]; 
            colorBarras[k]= 100;
            repaint();
            
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
            
            i++; 
            k++; 
        } 
        
        while(j<n2){
            Array[k]= R[j];
            colorBarras[k]= 100;
            repaint();
            
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
            
            j++;
            k++;
        }
    }
    
    public void mergeSort(int Array[], int p, int r){
        if(p<r){
            int q= (p+r)/2;
            mergeSort(Array,p,q);
            mergeSort(Array,q+1,r);
            Merge(Array,p,q,r);
        }
    }
    
}
