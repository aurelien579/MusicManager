package musicmanager.gui;

import musicmanager.musicsource.MusicSource;
import musicmanager.musicsource.FolderMusicSource;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddMediaDialog extends javax.swing.JDialog {

    private final MainFrame mainFrame;

    public AddMediaDialog(MainFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

        this.mainFrame = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        folderPane = new javax.swing.JPanel();
        pathTextField = new javax.swing.JTextField();
        pathLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pathLabel.setText("Path :");

        browseButton.setText("...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout folderPaneLayout = new javax.swing.GroupLayout(folderPane);
        folderPane.setLayout(folderPaneLayout);
        folderPaneLayout.setHorizontalGroup(
            folderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(folderPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(browseButton)
                .addContainerGap())
        );
        folderPaneLayout.setVerticalGroup(
            folderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(folderPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(folderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathLabel)
                    .addComponent(browseButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Add folder", folderPane);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(addButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (pathIsValid()) {
            registerMediaSource(createMediaSource());
            dispose();
        } else {
            showErrorPane();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private boolean pathIsValid() {
        return new File(pathTextField.getText()).exists();
    }

    private void showErrorPane() {
        JOptionPane.showMessageDialog(this,
                "This path is invalid, please verify that the specified directory or file exists.",
                "Invalid path",
                JOptionPane.ERROR_MESSAGE);
    }

    private void registerMediaSource(MusicSource source) {
        mainFrame.addMediaSource(source);
    }

    private MusicSource createMediaSource() {
        return new FolderMusicSource(pathTextField.getText());
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            pathTextField.setText(fileChooser.getSelectedFile().getPath());
        }

    }//GEN-LAST:event_browseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel folderPane;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
