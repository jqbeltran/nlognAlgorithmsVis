import java.awt.*;
import javax.swing.*;

public class Grafica extends JFrame implements Runnable {
    Panel1 jpanel1;
    Panel2 jpanel2;
    Panel3 jpanel3;
    Panel4 jpanel4;
    
    public Grafica(){
        this.setVisible(true);
        this.setSize(1366, 768);
        this.setLocationRelativeTo(null);
        iniciarComponentes();
        
    }
    
    
    private void BotonregActionPerformed(java.awt.event.ActionEvent evt) {
        Inicio inicio= new Inicio();
        inicio.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }     
    
    
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JButton Botonreg;
    
    
    public void iniciarComponentes(){
        
        Botonreg= new JButton();
        jpanel1= new Panel1();
        jpanel2= new Panel2();
        jpanel3= new Panel3();
        jpanel4= new Panel4();
        jLabel1= new JLabel("Gráficas");
        jLabel1.setForeground(Color.white);
        jLabel1.setFont(new Font("Serif", Font.BOLD, 16));
        jLabel2= new JLabel("QuickSort");
        jLabel2.setForeground(Color.white);
        jLabel3= new JLabel("HeapSort");
        jLabel3.setForeground(Color.white);
        jLabel4= new JLabel("MergeSort sin listas");
        jLabel4.setForeground(Color.white);
        jLabel5= new JLabel("MergeSort con listas");
        jLabel5.setForeground(Color.white);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        
        
        Botonreg.setText("Regresar");
        Botonreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonregActionPerformed(evt);
            }
        });
        
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(1300, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                    .addComponent(jLabel1).addGap(1300)
                    .addComponent(jLabel2).addGap(1300)
                    .addComponent(jLabel3).addGap(1300)
                    .addComponent(jLabel4).addGap(1300)
                    .addComponent(jLabel5).addGap(1300)))
                    
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Botonreg)
                        .addContainerGap())
                            
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                        .addComponent(jpanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)    
                .addComponent(jpanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jpanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jpanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jpanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(Botonreg)));
        
        pack();
    }
    
    
    @Override
    public void run(){
        String com= Thread.currentThread().getName();
        if("quicksort".equals(com)){
            try {
                jpanel1.desordenar();
                Thread.sleep(20);
                jpanel1.reiniciarColores();
                Thread.sleep(20);
                jpanel1.quickSort(jpanel1.A, 0, jpanel1.A.length-1);
                jpanel1.reiniciarColores();
                jpanel1.realzar();
                jpanel1.reiniciarColores();
            } catch (InterruptedException ex){}
        }
         
        else if("heapsort".equals(com)){
            try {
                jpanel2.desordenar();
                Thread.sleep(20);
                jpanel2.reiniciarColores();
                Thread.sleep(20);
                jpanel2.heapSort(jpanel2.A);
                jpanel2.reiniciarColores();
                jpanel2.realzar();
                jpanel2.reiniciarColores();
            } catch (InterruptedException ex){}
        }
        
        else if("mergesortsl".equals(com)){
            try {
                jpanel3.desordenar();
                Thread.sleep(20);
                jpanel3.reiniciarColores();
                Thread.sleep(20);
                jpanel3.mergeSort(jpanel3.A, 0, jpanel3.A.length-1);
                jpanel3.reiniciarColores();
                jpanel3.realzar();
                jpanel3.reiniciarColores();
            } catch (InterruptedException ex){}
        }
        
        else if("mergesortcl".equals(com)){
            try {
                jpanel4.desordenar();
                Thread.sleep(20);
                jpanel4.reiniciarColores();
                Thread.sleep(20);
                jpanel4.mergeSort(jpanel4.lista, 0, jpanel4.lista.size());
                jpanel4.reiniciarColores();
                jpanel4.realzar();
                jpanel4.reiniciarColores();
            } catch (InterruptedException ex){}
        }
    }
    
    
    public void Correr(){
        this.dispose();
        Runnable runnable= new Grafica();
        Thread t1= new Thread(runnable);
        Thread t2= new Thread(runnable);
        Thread t3= new Thread(runnable);
        Thread t4= new Thread(runnable);
        t1.setName("quicksort");
        t2.setName("heapsort");
        t3.setName("mergesortsl");
        t4.setName("mergesortcl");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
    
    public static void main(String args[]){
    }

}
