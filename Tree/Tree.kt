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

    fun iterativeAdd(data : Int){
        if(root!=null){
            iterativeAddHelper(root!!, data)
        }else{
            root = Node(data)
        }
    }

    private fun iterativeAddHelper(node : Node, data: Int){
        var current : Node? = node;
        var parent : Node? = null;

        while(current!=null){
            parent = current;
            if(data < current.data){
                current = current.left;
            }
            else if(current.data<data){
                current  = current.right;
            }
        }

        if(data < parent!!.data){
            parent.left = Node(data);
        }else{
            parent.right = Node(data);
        }
    }

    fun size(){
        if(root==null){
            println("Size is 0");
        }
        else{
            println("size of tree is : ${sizeHelper(root!!)}");
        }
    }

    private fun sizeHelper(node: Node?) : Int{
        if(node==null){
            return 0;
        }else{
            var left = sizeHelper(node.left);
            var right = sizeHelper(node.right)
            return 1 + left + right;
        }
    }

    fun height(){
        if(root==null){
            println("Height of tree is 0");
        }else{
            println("Height of tree is ${heightHelper(root!!)}");
        }
    }

    private fun heightHelper(node : Node?) : Int{
        if(node==null){
            return 0;
        }else{
            var left = heightHelper(node.left)
            var right = heightHelper(node.right)
            return 1 + Math.max(left, right)
        }
    }
}