
package library_service;


import java.awt.BorderLayout;
import java.io.BufferedReader;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JDialog;
public class View_Librarian extends javax.swing.JFrame {

    
    public View_Librarian() {
        super("View Librarian");
        setSize(700, 415);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        try{
            Scanner reader = new Scanner(new File("librarians.txt"));
            String[] libs = new String[100];
            int i=0;
            while(reader.hasNext()){
                libs[i++] = reader.nextLine();
            }
            String[][] args = new String[i][7];
            int k=0;
            double sum;
            reader.close();
            for(int j=0;j<i;j++){
                args[j] = libs[j].split(";");
                Scanner reader1 = new Scanner(new File("Librarians" + args[j][0] + ".txt"));
                sum=0;
                while(reader1.hasNext()){
                    String line = reader1.nextLine();
                    String[] words = line.split(";");
                    if(!words[2].equals("-"))
                        sum+= Double.parseDouble(words[2]);
                }
                args[j][6] = Double.toString(sum);
                reader1.close();
            }
            JTable jt = new JTable(args, new String[] { "ID Nos.", "NAME", "MAIL ID", "CONTACT Nos.", "PASSWORD", "PIN", "WORK HOURS" });
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
            .addGap(0, 415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Librarian().setVisible(true);
            }
        });
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
