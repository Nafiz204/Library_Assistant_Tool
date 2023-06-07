
package Library_Service;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class View_Members extends javax.swing.JFrame {

    
    public View_Members() {
        super("View Member");
        setSize(1000, 415);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        try{
            Scanner reader = new Scanner(new File("members.txt"));
            String[] mems = new String[100];
            int i=0;
            while(reader.hasNext()){
                mems[i++] = reader.next();
            }
            String[][] args = new String[i][7];
            for(int j=0;j<i;j++){
                args[j] = mems[j].split(";");
            }
            JTable jt = new JTable(args, new String[] { "ID Nos.", "NAME", "MAIL ID", "CONTACT Nos.", "PASSWORD", "DATE CREATED", "CURRENT STATUS" });
            JScrollPane jsp = new JScrollPane(jt);
            getContentPane().add(jsp, BorderLayout.CENTER);
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Members().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
