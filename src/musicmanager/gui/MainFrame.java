package musicmanager.gui;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import musicmanager.musicsource.AbstractSong;
import musicmanager.musicsource.MusicSource;

public class MainFrame extends javax.swing.JFrame {

    private final ArrayList<MusicSource> sources;

    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);

        sources = new ArrayList();
        listMusic.setModel(new DefaultListModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        listMusicScrollPane = new javax.swing.JScrollPane();
        listMusic = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        sourceTreeScrollPane = new javax.swing.JScrollPane();
        sourceTree = new musicmanager.gui.SourceTree();
        removeSourceTreeButton = new javax.swing.JButton();
        addSourceTreeButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        mediaMenu = new javax.swing.JMenu();
        addMediaSourceMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listMusic.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listMusicScrollPane.setViewportView(listMusic);

        splitPane.setRightComponent(listMusicScrollPane);

        sourceTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                sourceTreeValueChanged(evt);
            }
        });
        sourceTreeScrollPane.setViewportView(sourceTree);

        removeSourceTreeButton.setLabel("-");
        removeSourceTreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSourceTreeButtonActionPerformed(evt);
            }
        });

        addSourceTreeButton.setLabel("+");
        addSourceTreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSourceTreeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sourceTreeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(removeSourceTreeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addSourceTreeButton)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sourceTreeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeSourceTreeButton)
                    .addComponent(addSourceTreeButton))
                .addGap(5, 5, 5))
        );

        splitPane.setLeftComponent(jPanel1);

        mediaMenu.setText("Media");

        addMediaSourceMenuItem.setText("Add media source");
        addMediaSourceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMediaSourceMenuItemActionPerformed(evt);
            }
        });
        mediaMenu.add(addMediaSourceMenuItem);

        menuBar.add(mediaMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMediaSourceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMediaSourceMenuItemActionPerformed
        addMediaSource();
    }//GEN-LAST:event_addMediaSourceMenuItemActionPerformed

    private void sourceTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_sourceTreeValueChanged
        sourceTree.getSourcesSelected()
                .ifPresent((ArrayList<MusicSource> e) -> e.stream()
                        .forEach((MusicSource ms) -> ms.songs.stream()
                                .forEach(s -> addSongToList(s))));
    }//GEN-LAST:event_sourceTreeValueChanged

    private void addSourceTreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSourceTreeButtonActionPerformed
        addMediaSource();
    }//GEN-LAST:event_addSourceTreeButtonActionPerformed

    private void removeSourceTreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSourceTreeButtonActionPerformed
        removeSelectedMediaSource();
    }//GEN-LAST:event_removeSourceTreeButtonActionPerformed

    public void addMediaSource(MusicSource source) {
        sources.add(source);
        source.initializeContent();

        sourceTree.addSource(source);
    }

    private void addSongToList(AbstractSong title) {
        ((DefaultListModel) listMusic.getModel()).addElement(title);
    }

    private void addMediaSource() {
        new AddMediaDialog(this, true).setVisible(true);
    }

    private void removeSelectedMediaSource() {
        sourceTree.getSourcesSelected()
                .ifPresent((ArrayList<MusicSource> e) -> e.stream()
                        .forEach((MusicSource ms) -> sources.stream()
                                .filter(s -> s.equals(ms))
                                .forEach(s -> sources.remove(s))));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addMediaSourceMenuItem;
    private javax.swing.JButton addSourceTreeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList listMusic;
    private javax.swing.JScrollPane listMusicScrollPane;
    private javax.swing.JMenu mediaMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton removeSourceTreeButton;
    private musicmanager.gui.SourceTree sourceTree;
    private javax.swing.JScrollPane sourceTreeScrollPane;
    private javax.swing.JSplitPane splitPane;
    // End of variables declaration//GEN-END:variables
}
