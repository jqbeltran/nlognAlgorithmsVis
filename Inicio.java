import java.awt.*;
import javax.swing.*;

public class Inicio extends javax.swing.JFrame{
    public static int num= 0;
    
    public Inicio() {
        iniciarComponentes();
        this.setLocationRelativeTo(null);
    }

    
    private void iniciarComponentes() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        Num = new JTextField();
        Continuar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú de inicio");
        jLabel1.setFont(new Font("Serif", Font.BOLD, 14));
        jLabel2.setText("Número de datos:");

        Num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumActionPerformed(evt);
            }
        });

        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumActionPerformed(evt);
                ContinuarActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(Continuar)
                    .addComponent(Num, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Continuar)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(num>1){
            Grafica graf= new Grafica();
            graf.Correr();
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Ingrese un número mayor a uno");
        }
    }                                         

    private void NumActionPerformed(java.awt.event.ActionEvent evt) {                                    
        String n= Num.getText();
        if(!n.isEmpty()){
            int pre_num= Integer.parseInt(n);
            if(pre_num<=1){
                JOptionPane.showMessageDialog(null, "Ingrese un número mayor a uno");
            }
            else{
                num= pre_num;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Ingrese un númeromayor a uno");
        }
        
    }                                   

    public int obtenerNum(){
            return num;
        }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
                
    private javax.swing.JButton Continuar;
    private javax.swing.JTextField Num;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;                  

}
