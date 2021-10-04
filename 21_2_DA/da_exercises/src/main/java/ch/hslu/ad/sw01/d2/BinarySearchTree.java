package ch.hslu.ad.sw01.d2;

import jdk.jshell.spi.ExecutionControl;

import javax.management.openmbean.KeyAlreadyExistsException;

public class BinarySearchTree<K extends Comparable<K>, V> implements BinarySearchable<K, V> {
    private BinarySearchNode<K, V> root;

    private BinarySearchNode<K, V> searchNode(K key){
        var current = root;
        int comparison = 1;
        while(comparison != 0 && current != null){
            comparison = current.getKey().compareTo(key);
            current = comparison > 0 ? current.getRightNode() : comparison < 0 ? current.getLeftNode() : current;
        }

        if(current == null){
            throw new IllegalArgumentException("Key" + key.toString() + " doesn't exist in collection");
        }

        return current;
    }

    @Override
    public V search(K key) {
        return searchNode(key).getValue();
    }

    @Override
    public void remove(K key) {
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
