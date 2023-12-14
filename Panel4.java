import java.awt.*;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.*;

public class Panel4 extends JPanel {

    static int vancho = 1300;
    static int valto = 130;

    LinkedList<Integer> lista;
    int colorBarras[];

    Inicio obj= new Inicio();
    int numbar= obj.obtenerNum();
    int anchbar = vancho / numbar;

    public Panel4() {
        setBackground(Color.PINK);
        colorBarras = new int[numbar];
        lista= new LinkedList<>();
        
        for (int i = 0; i < numbar; i++) {
            lista.add(i);
            colorBarras[i] = 0;
        }
    }

    public void intercambiar(int p, int q) {
        try {
            int temp = lista.get(p);
            lista.set(p, lista.get(q));
            lista.set(q, temp);

            colorBarras[p] = 100;
            colorBarras[q] = 100;

            repaint();

            Thread.sleep(20);
        } catch (InterruptedException ex) {
        }
    }

    public void desordenar() {
        Random ran = new Random();
        for (int i = 0; i < numbar; i++) {
            int k= ran.nextInt(numbar - 1);
            intercambiar(i, k);
        }
    }

    public void reiniciarColores() {
        for (int i = 0; i < numbar; i++) {
            colorBarras[i] = 0;
        }
        repaint();
    }

    public void realzar() {
        for (int i = 0; i < numbar; i++) {
            colorBarras[i] = 100;
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(anchbar*numbar, valto);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graf = (Graphics2D) g;
        super.paintComponent(graf);
        graf.setColor(Color.white);

        for (int j = 0; j < numbar; j++) {
            int redon= (int)Math.ceil(numbar/130.0);
            int redon2= (int)Math.floor(130.0/numbar);
            int alt = lista.get(j);
            
            if(numbar<=130 && numbar>65){
                alt= lista.get(j);
            } else if(numbar<65){ 
                alt= lista.get(j)*redon2;
            } else{
                alt= lista.get(j)/redon;
            }

            int xini = (j + (anchbar - 1) * j);
            int yini = valto - alt;

            int val = colorBarras[j] * 2;
            graf.setColor(new Color(255, 255 - val, 255 - val));
            graf.fillRect(xini, yini, anchbar, alt);
            if (colorBarras[j] > 0) {
                colorBarras[j] -= 10;
            }
        }
    }
    
    
    public void mergeSort(LinkedList<Integer> list, int p, int r){
        if(p+1<r){
            //int q= (p+r)/2;
            int q = p+(r-p)/ 2;
            mergeSort(list, p, q);
            mergeSort(list, q, r);
            Merge(list, p, q, r);
        }
    }
    
    
    public void Merge(LinkedList<Integer> list, int p, int q, int r){
        LinkedList<Integer> izq= new LinkedList<>(list.subList(p, q));
        LinkedList<Integer> der= new LinkedList<>(list.subList(q, r));
        
        int i= 0;
        int j= 0;
        int k= p;
            
        while (i < izq.size() && j < der.size()) {
            if (izq.get(i) <= der.get(j)) {
                try {
                    list.set(k, izq.get(i));
                    colorBarras[k]= 100;
                    repaint();
                    
                    Thread.sleep(20);
                    i++;
                } catch (InterruptedException ex) {
                }
                
            } else {
                try {
                    list.set(k, der.get(j));
                    colorBarras[k]= 100;
                    repaint();
                    
                    Thread.sleep(20);
                    j++;
                } catch (InterruptedException ex) {
                }
            }
            
            k++;
        }
        
        while (i < izq.size()) {
            try {
            list.set(k, izq.get(i));
            colorBarras[k]= 100;
            repaint();
                 
            Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
             
            i++;
            k++;
            
        }
        while (j < der.size()) {
            try {
            list.set(k, der.get(j));
            colorBarras[k]= 100;
            repaint();
             
            Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
                
            j++;
            k++;
        }
    }
    
}
