
package Library_Service;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class View_All_Books extends javax.swing.JFrame {

    
    public View_All_Books() {
        super("View Books");
        setSize(1000, 415);
        //setDefaultCloseOperation(new AVMD_Book_Category().setVisible(true));
        try{
            int j=0,k=0,z=0;
            Scanner reader1 = new Scanner(new File("categories.txt"));
            String books;
            String cat[] = new String[20];
            while(reader1.hasNext()){
                cat[j++] = reader1.nextLine();
            }
            reader1.close();
            String[][] args = new String[100][7];
            for(int i=0;i<j;i++){
                BufferedReader readers = new BufferedReader(new FileReader("Categories" + cat[i] + ".txt"));
                    //int x=0,y=0;
                    while((books = readers.readLine())!=null){
                        String[] words = books.split(";");
                        args[k][0] = cat[i];
                        args[k][1] = words[0];
                        args[k][2] = words[1];
                        args[k][3] = words[2];
                        args[k][4] = words[3];
                        args[k][5] = words[4];
                        args[k][6] = words[5];
                        k++;
                    }
                    readers.close();
            }
                //reader1.close();
            String[][] args1 = new String[k][7];
            for(int i=0;i<k;i++)
                for(j=0;j<7;j++)
                    args1[i][j]=args[i][j];
            JTable jt = new JTable(args1, new String[] { "CATEGORY", "BOOK ID", "NAME", "AUTHOR", "AVAILABILTY", "BORROWED MEMBER", "BORROWED DATE" });
            JScrollPane jsp = new JScrollPane(jt);
            getContentPane().add(jsp, BorderLayout.CENTER);
        }catch(IOException e){
            e.printStackTrace();
        }
        //initComponents();
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
                new View_All_Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
