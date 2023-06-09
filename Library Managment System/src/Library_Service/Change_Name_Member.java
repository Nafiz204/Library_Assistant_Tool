
package Library_Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class Change_Name_Member extends javax.swing.JFrame {

    
    public Change_Name_Member() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Mem_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Mem_Name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CHANGE MEMBER NAME");

        jLabel2.setText("ENTER MEMBER ID:");
        jLabel2.setPreferredSize(new java.awt.Dimension(112, 33));

        Mem_ID.setToolTipText("");
        Mem_ID.setPreferredSize(new java.awt.Dimension(155, 33));

        jLabel3.setText("ENTER NEW MEMBER NAME:");
        jLabel3.setPreferredSize(new java.awt.Dimension(164, 33));

        Mem_Name.setPreferredSize(new java.awt.Dimension(155, 33));

        jButton1.setText("CHANGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mem_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mem_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mem_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String id = Mem_ID.getText();
        String name = Mem_Name.getText();
        File f = new File("members.txt");
        if(!f.exists()){
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(Change_Name_Member.this,"There are no members! Please add them before modifying","Member Error!", JOptionPane.ERROR_MESSAGE);
            Mem_ID.setText("");
            Mem_Name.setText("");
        }
        else{
            try {
                BufferedReader reader1 = new BufferedReader(new FileReader(f));
                int k=1;
                String line="";
                while((line=reader1.readLine())!=null){
                    String[] words = line.split(";");
                    if(words[0].equals(id)){
                        k=0;
                    }
                }
                reader1.close();
                if(k==1){
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    JOptionPane.showMessageDialog(Change_Name_Member.this,"ID doesn't exists","ID Error!", JOptionPane.ERROR_MESSAGE);
                    Mem_ID.setText("");
                    Mem_Name.setText("");
                }
                else{
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    int response = JOptionPane.showConfirmDialog(Change_Name_Member.this, "Are you sure you want to change this member's name?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        File tempfile = new File(f.getAbsolutePath() + ".tmp");
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(f));
                            PrintWriter pw = new PrintWriter(new FileWriter(tempfile));
                            String read = "";
                            int z=1;
                            while((read = reader.readLine())!=null){
                                String[] words = read.split(";");
                                if(!words[0].equals(id)){
                                    pw.println(read);
                                    pw.flush();
                                }
                                else{
                                    String lines = words[0] + ";" + name + ";" + words[2] + ";" + words[3] + ";" + words[4] + ";" + words[5] + ";" + words[6]; 
                                    pw.println(lines);
                                    pw.flush();
                                    z=0;
                                }
                            }   
                            pw.close();
                            reader.close();
                            int x=0,y=0;
                            if(z==0){
                                if(!f.delete()){
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Change_Name_Member.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    x=1;
                                }
                                if(!tempfile.renameTo(f)){
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Change_Name_Member.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    y=1;
                                }
                                if(x==0 && y==0) {
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Change_Name_Member.this,"Member Name changed successfully!");    
                                    new AVD_Members().setVisible(true);
                                    this.setVisible(false);
                                }
                                else{
                                    JDialog.setDefaultLookAndFeelDecorated(true);
                                    JOptionPane.showMessageDialog(Change_Name_Member.this, "Sorry, an Unexpected error occurerd","Error 1!", JOptionPane.ERROR_MESSAGE);
                                    new AVD_Members().setVisible(true);
                                    this.setVisible(false);
                                }
                            }
                            else{
                                JDialog.setDefaultLookAndFeelDecorated(true);
                                JOptionPane.showMessageDialog(Change_Name_Member.this,"Unable to rename!","Category Error!", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Change_Name_Member.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Change_Name_Member.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(response==JOptionPane.NO_OPTION){
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        JOptionPane.showMessageDialog(Change_Name_Member.this,"Name Change Operation cancelled!");    
                        new Modify_Members().setVisible(true);
                        this.setVisible(false);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Change_Name_Member.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        new Modify_Members().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_Name_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Mem_ID;
    private javax.swing.JTextField Mem_Name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
