package GUI;

import Computations.InverseDocFrequency;
import Computations.WebserviceSimilararity;
import DocOperations.ReadDataset;
import WebOperation.ReadFile;
import com.easynth.lookandfeel.EaSynthLookAndFeel;
import com.seaglasslookandfeel.SeaGlassLookAndFeel;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_Dataset = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jButton_DisplayDataset = new javax.swing.JButton();
        jButton_Extractdata = new javax.swing.JButton();
        jButton_Process = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_TF = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea_IDF = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_textSimilarity = new javax.swing.JTextArea();
        jButtonTextSimilarity = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_OperationSimilarity = new javax.swing.JTextArea();
        jButton_OperationSimilarity = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea_wsSimilarity = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jTextArea_Dataset.setEditable(false);
        jTextArea_Dataset.setColumns(20);
        jTextArea_Dataset.setRows(5);
        jScrollPane4.setViewportView(jTextArea_Dataset);

        jPanel8.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jButton_DisplayDataset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_DisplayDataset.setText("Display Dataset");
        jButton_DisplayDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DisplayDatasetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 18, 0);
        jPanel9.add(jButton_DisplayDataset, gridBagConstraints);

        jButton_Extractdata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Extractdata.setText("Extract data");
        jButton_Extractdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExtractdataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 219, 18, 0);
        jPanel9.add(jButton_Extractdata, gridBagConstraints);

        jButton_Process.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Process.setText("Process");
        jButton_Process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ProcessActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 18, 232);
        jPanel9.add(jButton_Process, gridBagConstraints);

        jPanel3.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Dataset Operrations", jPanel3);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jPanel11.setLayout(new java.awt.BorderLayout());

        jTextArea_TF.setColumns(20);
        jTextArea_TF.setRows(5);
        jScrollPane1.setViewportView(jTextArea_TF);

        jPanel11.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton2.setText("Term Frequency");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton2, java.awt.BorderLayout.PAGE_START);

        jPanel10.add(jPanel11);

        jPanel12.setLayout(new java.awt.BorderLayout());

        jTextArea_IDF.setColumns(20);
        jTextArea_IDF.setRows(5);
        jScrollPane6.setViewportView(jTextArea_IDF);

        jPanel12.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jButton3.setText("Inverse Document Frequency");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton3, java.awt.BorderLayout.PAGE_START);

        jPanel10.add(jPanel12);

        jTabbedPane1.addTab("Text Processing", jPanel10);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setLayout(new java.awt.BorderLayout());

        jTextArea_textSimilarity.setEditable(false);
        jTextArea_textSimilarity.setColumns(20);
        jTextArea_textSimilarity.setRows(5);
        jScrollPane2.setViewportView(jTextArea_textSimilarity);

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButtonTextSimilarity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTextSimilarity.setText("Text Similarity");
        jButtonTextSimilarity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTextSimilarityActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonTextSimilarity, java.awt.BorderLayout.PAGE_START);

        jPanel4.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jTextArea_OperationSimilarity.setEditable(false);
        jTextArea_OperationSimilarity.setColumns(20);
        jTextArea_OperationSimilarity.setRows(5);
        jScrollPane3.setViewportView(jTextArea_OperationSimilarity);

        jPanel6.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jButton_OperationSimilarity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_OperationSimilarity.setText("Operation Similarity");
        jButton_OperationSimilarity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OperationSimilarityActionPerformed(evt);
            }
        });
        jPanel6.add(jButton_OperationSimilarity, java.awt.BorderLayout.PAGE_START);

        jPanel4.add(jPanel6);

        jTabbedPane1.addTab("Similarities", jPanel4);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jTextArea_wsSimilarity.setEditable(false);
        jTextArea_wsSimilarity.setColumns(20);
        jTextArea_wsSimilarity.setRows(5);
        jScrollPane5.setViewportView(jTextArea_wsSimilarity);

        jPanel7.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Display Similarity");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Web Service Similarity", jPanel7);

        jPanel1.add(jTabbedPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Web Service Recommentdation");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Console"));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane7.setViewportView(jTextArea1);

        jPanel13.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel13, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DisplayDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DisplayDatasetActionPerformed
        // TODO add your handling code here:
        ReadDataset rd = new ReadDataset();
        jTextArea_Dataset.setText(rd.read().toString());

    }//GEN-LAST:event_jButton_DisplayDatasetActionPerformed

    private void jButton_ProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ProcessActionPerformed
        // TODO add your handling code here:
        WebserviceSimilararity wss = new WebserviceSimilararity();
        wss.wsSim();
        JOptionPane.showMessageDialog(null, "Done");
    }//GEN-LAST:event_jButton_ProcessActionPerformed

    private void jButton_ExtractdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExtractdataActionPerformed
        // TODO add your handling code here:
        ReadFile rf = new ReadFile();
        rf.read("WSDream-QoSDataset/wslist.txt");
        JOptionPane.showMessageDialog(null, "Done");
//        rf.read("wslist.txt");
    }//GEN-LAST:event_jButton_ExtractdataActionPerformed

    private void jButtonTextSimilarityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTextSimilarityActionPerformed
        // TODO add your handling code here:
        jTextArea_textSimilarity.setText(WebserviceSimilararity.txtsimi.toString());
    }//GEN-LAST:event_jButtonTextSimilarityActionPerformed

    private void jButton_OperationSimilarityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OperationSimilarityActionPerformed
        // TODO add your handling code here:        
        jTextArea_OperationSimilarity.setText(WebserviceSimilararity.opsimi.toString());

    }//GEN-LAST:event_jButton_OperationSimilarityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextArea_wsSimilarity.setText(WebserviceSimilararity.wssimi.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextArea_TF.setText("");
        InverseDocFrequency idf = new InverseDocFrequency();
        Map<String, HashMap<String, Double>> mapIDF = idf.idf();
        Map<String, HashMap<String, Double>> mapTF = idf.getMap();
        for (String doc : mapIDF.keySet()) {
            jTextArea_TF.append("\n----------<< " + doc + " >>----------\n\n");
            for (String word : mapTF.get(doc).keySet()) {
                jTextArea_TF.append(word + "  " + mapTF.get(doc).get(word) + "\n");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextArea_IDF.setText("");
        InverseDocFrequency idf = new InverseDocFrequency();
        Map<String, HashMap<String, Double>> mapIDF = idf.idf();
        Map<String, HashMap<String, Double>> mapTF = idf.getMap();
        for (String doc : mapIDF.keySet()) {
            jTextArea_IDF.append("\n----------<< " + doc + " >>----------\n\n");
            for (String word : mapIDF.get(doc).keySet()) {
                jTextArea_IDF.append(word + "  " + mapIDF.get(doc).get(word) + "\n");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
//                    UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
//                    UIManager.setLookAndFeel(new EaSynthLookAndFeel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonTextSimilarity;
    private javax.swing.JButton jButton_DisplayDataset;
    private javax.swing.JButton jButton_Extractdata;
    private javax.swing.JButton jButton_OperationSimilarity;
    private javax.swing.JButton jButton_Process;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea_Dataset;
    private javax.swing.JTextArea jTextArea_IDF;
    private javax.swing.JTextArea jTextArea_OperationSimilarity;
    private javax.swing.JTextArea jTextArea_TF;
    private javax.swing.JTextArea jTextArea_textSimilarity;
    private javax.swing.JTextArea jTextArea_wsSimilarity;
    // End of variables declaration//GEN-END:variables
}
