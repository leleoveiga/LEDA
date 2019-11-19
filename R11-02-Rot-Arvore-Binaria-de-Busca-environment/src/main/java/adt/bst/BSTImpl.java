package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {
    
    protected BSTNode<T> root;
    
    public BSTImpl() {
        root = new BSTNode<T>();
    }
    
    @Override
    public BSTNode<T> getRoot() {
        return this.root;
    }
    
    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }
    
    @Override
    public int height() {
        return height(root);
    }
    
    private int height(BSTNode<T> node) {
        
        int height = -1;
        if (!node.isEmpty()) {
            height = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
            
        }
        return height;
    }
    
    @Override
    public BSTNode<T> search(T element) {
        return search(root, element);
    }
    
    private BSTNode<T> search(BSTNode<T> node, T element) {
        BSTNode<T> aux = new BSTNode<T>();
        
        if (!node.isEmpty() && element != null) {
            if (element.compareTo(node.getData()) < 0 && !node.getLeft().isEmpty()) {
                aux = search((BSTNode<T>) node.getLeft(), element);
            } else if (element.compareTo(node.getData()) > 0 && !node.getRight().isEmpty()) {
                aux = search((BSTNode<T>) node.getRight(), element);
            } else if (element.compareTo(node.getData()) == 0) {
                aux = node;
            }
        }
        
        return aux;
    }
    
    @Override
    public void insert(T element) {
        if (element != null) {
            insert(element, root);
        }
    }
    
    private void insert(T element, BSTNode<T> node) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode<T>());
            node.setRight(new BSTNode<T>());
            node.getLeft().setParent(node);
            node.getRight().setParent(node);
            
        } else {
            if (element.compareTo(node.getData()) > 0) {
                insert(element, (BSTNode<T>) node.getRight());
                
            } else if (element.compareTo(node.getData()) < 0) {
                insert(element, (BSTNode<T>) node.getLeft());
            }
        }
    }
    
    @Override
    public BSTNode<T> maximum() {
        if (root.isEmpty()) {
            return null;
        } else {
            return maximum(root);
        }
    }
    
    private BSTNode<T> maximum(BSTNode<T> node) {
        BSTNode<T> aux = node;
        
        if (!node.getRight().isEmpty()) {
            aux = maximum((BSTNode<T>) node.getRight());
        }
        
        return aux;
    }
    
    @Override
    public BSTNode<T> minimum() {
        if (root.isEmpty()) {
            return null ;
        } else {
            return minimum(root);
        }
    }
    
    private BSTNode<T> minimum(BSTNode<T> node) {
        BSTNode<T> aux = node;
        
        if (!node.getLeft().isEmpty()) {
            aux = minimum((BSTNode<T>) node.getLeft());
        }
        
        return aux;
    }
    
    @Override
    public BSTNode<T> sucessor(T element) {
        BSTNode<T> node = search(element);
        
        if (node.isEmpty()) return null;
        
        if (!node.getRight().isEmpty()) {
            return minimum((BSTNode<T>) node.getRight());
        } else {
            while (node.getParent() != null && (node.getData().compareTo(node.getParent().getData()) > 0)) {
                node = (BSTNode<T>) node.getParent();
            }
            
            return (BSTNode<T>) node.getParent();
        }
    }
    
    @Override
    public BSTNode<T> predecessor(T element) {
        BSTNode<T> node = search(element);
        
        if (node.isEmpty()) return null;
        
        if (!node.getLeft().isEmpty()) {
            return maximum((BSTNode<T>) node.getLeft());
        } else {
            while (node.getParent() != null && (node.getData().compareTo(node.getParent().getData()) < 0)) {
                node = (BSTNode<T>) node.getParent();
            }
            
            return (BSTNode<T>) node.getParent();
        }
    }
    
    @Override
    public void remove(T element) {
        BSTNode<T> node = search(element);
        
        if (node.isEmpty() || element == null) return;
        
        // se o no nao tem folhas
        else if (node.isLeaf()) {
	        node.setData(null);
        }
        
        // se tem 2 folhas
        else if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
            BSTNode<T> sucessor = sucessor(node.getData());
            T data = sucessor.getData();
            remove(sucessor.getData());
            node.setData(data);
        }
        
        // se tem 1 folha
        // tem folha esquerda somente
        else if (node.getParent() != null) {
            if (!node.getLeft().isEmpty()) {
                if (node.equals(node.getParent().getLeft())) {
                    node.getParent().setLeft(node.getLeft());
                    node.getLeft().setParent(node.getParent());
                } else if (node.equals(node.getParent().getRight())) {
                    node.getParent().setRight(node.getLeft());
                    node.getLeft().setParent(node.getParent());
                }
            }
            // tem folha direita somente
            else if (!node.getRight().isEmpty()) {
                if (node.equals(node.getParent().getLeft())) {
                    node.getParent().setLeft(node.getRight());
                    node.getRight().setParent(node.getParent());
                } else if (node.equals(node.getParent().getRight())) {
                    node.getParent().setRight(node.getRight());
                    node.getRight().setParent(node.getParent());
                }
            }
	        // é root
        } else {
            if (!node.getLeft().isEmpty()) {
                root = (BSTNode<T>) root.getLeft();
                root.setParent(null);
            } else {
                root = (BSTNode<T>) root.getRight();
                root.setParent(null);
            }
        }
        
    }
    
    @Override
    public T[] preOrder() {
        ArrayList<T> array = new ArrayList<>();
        preOrder(root, array);
        
        T[] result = (T[]) array.toArray(new Comparable[array.size()]);
        
        return result;
        
    }
    
    private void preOrder(BSTNode<T> node, ArrayList array) {
        if (node.isEmpty()) return;
        
        array.add(node.getData());
        preOrder((BSTNode<T>) node.getLeft(), array);
        preOrder((BSTNode<T>) node.getRight(), array);
        
    }
    
    @Override
    public T[] order() {
        ArrayList<T> array = new ArrayList<>();
        
        order(root, array);
        
        T[] result = (T[]) array.toArray(new Comparable[array.size()]);
        
        return result;
        
    }
    
    private void order(BSTNode<T> node, ArrayList<T> array) {
        if (node.isEmpty()) return;
        
        order((BSTNode<T>) node.getLeft(), array);
        array.add(node.getData());
        order((BSTNode<T>) node.getRight(), array);
        
    }
    
    @Override
    public T[] postOrder() {
        ArrayList<T> array = new ArrayList<>();
        
        postOrder(root, array);
        
        T[] result = (T[]) array.toArray(new Comparable[array.size()]);
        
        return result;
    }
    
    private void postOrder(BSTNode<T> node, ArrayList<T> array) {
        if (node.isEmpty()) return;
        
        postOrder((BSTNode<T>) node.getLeft(), array);
        postOrder((BSTNode<T>) node.getRight(), array);
        array.add(node.getData());
    }
    
    /**
     * This method is already implemented using recursion. You must understand how
     * it work and use similar idea with the other methods.
     */
    @Override
    public int size() {
        return size(root);
    }
    
    private int size(BSTNode<T> node) {
        int result = 0;
        // base case means doing nothing (return 0)
        if (!node.isEmpty()) { // indusctive case
            result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
        }
        return result;
    }
    
}
