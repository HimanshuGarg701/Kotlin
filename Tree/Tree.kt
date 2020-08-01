package Tree

class Tree {

    var root : Node? = null;

    fun addNode(data : Int){
        if(root==null){
            root = Node(data);
        }else{
            addHelper(root!!, data);
        }
    }

    private fun addHelper(node : Node?, data: Int) : Node{
        if(node==null){
            return Node(data);
        }else if(data < node.data){
            node.left = addHelper(node.left, data);
        }
        else{
            node.right = addHelper(node.right, data);
        }
        return node;
    }

    fun print(){
        if(root!=null){
            printHelper(root!!);
        }
    }

    private fun printHelper(node : Node?){
        if(node!=null){
            printHelper(node.left);
            print("${node.data}  ");
            printHelper(node.right);
        }
    }
}