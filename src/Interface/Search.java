/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Catalin
 */
public class Search extends javax.swing.JFrame {

    /**
     * Creates new form Search
     */
    public Search() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchField = new javax.swing.JTextField();
        ByReaderCNP = new javax.swing.JCheckBox();
        ByReaderName = new javax.swing.JCheckBox();
        ByBookTytle = new javax.swing.JCheckBox();
        ByBookAuthor = new javax.swing.JCheckBox();
        SearchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        SearchField.setText("Insert what you search...");
        SearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchFieldMouseClicked(evt);
            }
        });
        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        ByReaderCNP.setText("By Reader CNP");
        ByReaderCNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ByReaderCNPActionPerformed(evt);
            }
        });

        ByReaderName.setText("By Readear Name");
        ByReaderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ByReaderNameActionPerformed(evt);
            }
        });

        ByBookTytle.setSelected(true);
        ByBookTytle.setText("By Book Tytle");
        ByBookTytle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ByBookTytleActionPerformed(evt);
            }
        });

        ByBookAuthor.setText("By Book Author");
        ByBookAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ByBookAuthorActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(ResultTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ByBookTytle)
                    .addComponent(ByBookAuthor)
                    .addComponent(ByReaderCNP)
                    .addComponent(ByReaderName))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ByBookTytle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ByBookAuthor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ByReaderCNP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ByReaderName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void SearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchFieldMouseClicked
        SearchField.setText("");
    }//GEN-LAST:event_SearchFieldMouseClicked

    private void ByBookTytleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ByBookTytleActionPerformed
        if(ByBookTytle.isSelected()==true)
        {
            ByBookAuthor.setSelected(false);
            ByReaderCNP.setSelected(false);
            ByReaderName.setSelected(false);
        }
        
    }//GEN-LAST:event_ByBookTytleActionPerformed

    private void ByBookAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ByBookAuthorActionPerformed
        if(ByBookAuthor.isSelected()==true)
        {
            ByBookTytle.setSelected(false);
            ByReaderCNP.setSelected(false);
            ByReaderName.setSelected(false);
        }
    }//GEN-LAST:event_ByBookAuthorActionPerformed

    private void ByReaderCNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ByReaderCNPActionPerformed
        if(ByReaderCNP.isSelected()==true)
        {
            ByBookTytle.setSelected(false);
            ByBookAuthor.setSelected(false);
            ByReaderName.setSelected(false);
        }
    }//GEN-LAST:event_ByReaderCNPActionPerformed

    private void ByReaderNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ByReaderNameActionPerformed
        if(ByReaderName.isSelected()==true)
        {
            ByBookTytle.setSelected(false);
            ByBookAuthor.setSelected(false);
            ByReaderCNP.setSelected(false);
        }
    }//GEN-LAST:event_ByReaderNameActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        
        /*String colNames[] = {"Name", "Age"};
        Object[][] data = {{"joe","21"},{"fred","31"},{"mary","22"}};
        DefaultTableModel dtm = new DefaultTableModel(data,colNames);*/
        
        
    }//GEN-LAST:event_SearchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ByBookAuthor;
    private javax.swing.JCheckBox ByBookTytle;
    private javax.swing.JCheckBox ByReaderCNP;
    private javax.swing.JCheckBox ByReaderName;
    private javax.swing.JTable ResultTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
