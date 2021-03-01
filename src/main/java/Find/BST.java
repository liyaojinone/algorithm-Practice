package Find;


class Test01 {
    public static void main(String[] args) {

        Node<Integer, String> node = new Node<>(2, "张三");
        Node<Integer, String> node2 = new Node<>(4, "李四");
        Node<Integer, String> node3 = new Node<>(6, "王五");
        Node<Integer, String> node4 = new Node<>(8, "二麻子");
        Node<Integer, String> node5 = new Node<>(10, "巴安邦");
        Node<Integer, String> node6 = new Node<>(9, "hahh");
//        node.setLeft(node2);
//        node.setRight(node3);
//        node3.setLeft(node4);
//        node3.setRight(node5);
        BST<Integer, String> bst = new BST<>(node);

//        bst.preOrder();
//        bst.del(1);
//        System.out.println("___________del__________");
//        bst.preOrder();
        bst.add(node2);
        bst.add(node3);
        bst.add(node4);
        bst.add(node5);
        bst.add(node6);
        bst.preOrder();

//        Node<Integer, String> integerStringNode = bst.preSearch(3);
//        System.out.println("integerStringNode = " + integerStringNode);

        //前序遍历 根》左》右 12345
//        System.out.println("前序遍历");
//        bst.preOrder();
//        //
//        System.out.println("中序遍历");
//        bst.fixOrder();
//        System.out.println("后序遍历");
//        bst.postOrder();

    }
}
public class BST<Key extends Comparable<Key>,Value> {
    private Node<Key, Value> root;

    public BST(Node<Key, Value> root) {
        this.root = root;
    }

    public void add(Node<Key, Value> node){
        if (root.getKey()!=node.getKey()){
            try {
                root.addNode(node);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {

        }
    }
    public void del(Key key){
        if (this.root.getKey()!=key){
            this.root.delNode(key);
        }else {
            this.root=null;
        }
    }
    public Node<Key, Value> preSearch(Key key){
        if (this.root!=null){
           return  this.root.preSearch(key);
        }else {
            return null;
        }
    }
    public void fixSearch(Key key){}
    public void postSearch(Key key){}
    public void preOrder(){
        if (this.root!=null){
            this.root.preNode();
        }else {
            System.out.println("二叉树 为空 ！");
        }
    }
    public void fixOrder(){
        if (this.root!=null){
            this.root.infixNode();
        }else {
            System.out.println("二叉树 为空 ！");
        }
    }
    public void postOrder(){
        if (this.root!=null){
            this.root.postNode();
        }else {
            System.out.println("二叉树 为空 ！");
        }
    }
}
class Node<Key extends Comparable<Key>,Value>{
    private Key key;
    private Value value;
    private Node left,right;

    public void addNode(Node node) throws Exception {
        Integer key = (Integer)node.key;
        if (key<(Integer) this.getKey()) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.addNode(node);
                }
        }
        if (key>(Integer)this.getKey()){
            if (this.right==null){
                this.right=node;
            }else {
                this.right.addNode(node);
            }
        }
        if (key==(Integer)this.getKey()){
            throw new Exception("key已经添加，请勿重复添加！");
        }

    }

    //二叉树删除
    public void delNode(Key key){
       if (this.left!=null&&this.left.key == key){
           this.left=null;
       }
       if (this.left!=null&&this.right.key==key){
           this.right=null;
       }
       if (this.left!=null){
           this.left.delNode(key);
       }
       if (this.right!=null){
           this.right.delNode(key);
       }


    }
    //二叉树查找
    public Node<Key, Value> preSearch(Key key){
        if (this.key==key){
            return this;
        }
        Node node = null;
        if (this.left!=null){
            node = this.left.preSearch(key);
        }
        if (node!=null){
            return node;
        }
        if (this.right!=null){
            node=this.right.preSearch(key);
        }
        return node;
    }
    public void fixSearch(Key key){}
    public void postSearch(Key key){}

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(Key key, Value value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;

    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
    public void preNode(){
        //前序
        System.out.println(this);
        if (this.left!=null){
            this.left.preNode();
        }
        if (this.right!=null){
            this.right.preNode();
        }
    }
    public void  infixNode(){
        //中序
        if (this.left!=null){
            this.left.infixNode();
        }
        System.out.println(this);

        if (this.right!=null){
            this.right.infixNode();
        }
    }
    public void postNode(){
        //后续
        if (this.left!=null){
            this.left.postNode();
        }
        if (this.right!=null){
            this.right.postNode();
        }
        System.out.println(this);
    }

}


