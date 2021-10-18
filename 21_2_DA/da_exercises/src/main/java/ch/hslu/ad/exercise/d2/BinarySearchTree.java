package ch.hslu.ad.exercise.d2;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, V> implements BinarySearchable<K, V> {
    private BinarySearchNode<K, V> root;

    private List<BinarySearchNode<K, V>> searchPath(K key){
        var path = new ArrayList<BinarySearchNode<K,V>>();
        path.add(root);

        int comparison = 1;
        var current = root;
        while(comparison != 0 && current != null){
            comparison = current.getKey().compareTo(key);
            current = comparison > 0 ? current.getRightNode() : comparison < 0 ? current.getLeftNode() : current;
            if(comparison != 0){
                path.add(current);
            }
        }

        if(current == null){
            throw new IllegalArgumentException("Key" + key.toString() + " doesn't exist in collection");
        }

        return path;
    }

    @Override
    public V search(K key) {
        var path = searchPath(key);

        return path.get(path.size() - 1).getValue();
    }

    private BinarySearchNode<K, V> getLeftMostItem(BinarySearchNode<K, V> node){
        var previous = node;
        while(node.getLeftNode() != null){
            node = node.getLeftNode();
        }

        return previous;
    }

    private void removeRoot(){
        if(root.getLeftNode() != null && root.getRightNode() != null){
            root = getLeftMostItem(root.getRightNode());
        } else if(root.getLeftNode() != null){
            root = root.getLeftNode();
        } else if(root.getRightNode() != null){
            root = root.getRightNode();
        }
    }

    @Override
    public void remove(K key) {
        var path = searchPath(key);
        var target = path.get(path.size() - 1);
        if(path.size() == 1){
            removeRoot();
        } else {
            //removeChildN
        }

        throw new IllegalArgumentException("Hasn't been implemented.");
    }

    private void add(K key, V value, boolean overwriteIfExist){
        var newElement = new BinarySearchNode<>(key, value);

        if(root == null){
            root = newElement;
            return;
        }

        var current = root;

        while(true){
            var comparison = current.getKey().compareTo(key);

            if(comparison == 0){
                if(overwriteIfExist){
                    current.setValue(value);
                } else {
                    throw new KeyAlreadyExistsException();
                }
            }

            if(comparison > 0){
                var rightNode = current.getRightNode();
                if(rightNode == null){
                    current.setRightNode(newElement);
                    return;
                } else{
                    current = rightNode;
                }
            } else {
                var leftNode = current.getLeftNode();
                if(leftNode == null){
                    current.setLeftNode(newElement);
                    return;
                } else{
                    current = leftNode;
                }
            }
        }
    }
    @Override
    public void add(K key, V value) {
        add(key, value, false);
    }

    @Override
    public boolean hasKey(K key) {
        try{
            search(key);
        } catch(IllegalArgumentException e){
            return false;
        }

        return true;
    }

    @Override
    public void addOrUpdate(K key, V value) {
        add(key, value, true);
    }
}
