package musicmanager.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import musicmanager.musicsource.MusicSource;

public class SourceTree extends JTree {

    private final DefaultMutableTreeNode root = new DefaultMutableTreeNode("Media Sources");

    public SourceTree() {
        setModel(new DefaultTreeModel(root));
    }

    public void addSource(MusicSource source) {
        findSourceTypeNode(source.getSourceType())
                .orElseGet(() -> createSourceTypeNode(source.getSourceType()))
                .add(new DefaultMutableTreeNode(source));

        ((DefaultTreeModel) getModel()).reload();
    }

    private Optional<DefaultMutableTreeNode> findSourceTypeNode(String sourceType) {
        return Collections.list(root.children()).stream()
                .filter(e -> ((DefaultMutableTreeNode) e).toString().equals(sourceType))
                .findFirst();
    }

    private DefaultMutableTreeNode createSourceTypeNode(String sourceType) {
        DefaultMutableTreeNode sourceTypeNode = new DefaultMutableTreeNode(sourceType);
        root.add(sourceTypeNode);
        return sourceTypeNode;
    }

    public Optional<ArrayList<MusicSource>> getSourcesSelected() {
        ArrayList<MusicSource> list = new ArrayList<>();

        if (getSelectionPath() == null) {
            return Optional.empty();
        }

        if (getSelectionPath().getLastPathComponent() == root) {
            return Optional.empty();
        }

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) getSelectionPath().getLastPathComponent();
        if (selectedNode.isLeaf()) {
            list.add((MusicSource) selectedNode.getUserObject());
        } else {
            Collections.list(selectedNode.children()).stream()
                    .forEach(e -> list.add((MusicSource) ((DefaultMutableTreeNode) e).getUserObject()));
        }

        return Optional.of(list);
    }
}
