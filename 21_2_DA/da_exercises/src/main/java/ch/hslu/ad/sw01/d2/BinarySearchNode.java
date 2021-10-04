package ch.hslu.ad.sw01.d2;

public class BinarySearchNode<K, V> {
    private K key;
    private V value;
    private BinarySearchNode<K, V> leftNode;
    private BinarySearchNode<K, V> rightNode;

    public BinarySearchNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public BinarySearchNode<K, V> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinarySearchNode<K, V> leftNode) {
        this.leftNode = leftNode;
    }

    public BinarySearchNode<K, V> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinarySearchNode<K, V> rightNode) {
        this.rightNode = rightNode;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
