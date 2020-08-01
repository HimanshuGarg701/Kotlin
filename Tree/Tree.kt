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

    fun checkSame(node1 : Node?, node2:Node?):Boolean{
        if(node1==null && node2==null){
            return true;
        }
        else if(node1==null || node2==null){
            return false;
        }else{
            return (node1.data==node2.data) && checkSame(node1.right, node2.right) && checkSame(node1.left, node2.left)
        }
    }

    fun rootToLeafSum(sum : Int){
        if(root==null){
            println("Given sum not present")
        }else{
            val list = ArrayList<Int>()
            checkSumHelper(root!!, sum, list)
            println(list.size)
            for(i in list){
                print("$i   ")
            }
        }
    }

    private fun checkSumHelper(node : Node?, sum : Int, list : ArrayList<Int>) : Boolean{
        if(node==null){
            return false;
        }
        if(node.left==null && node.right==null){
            if(node.data==sum){
                list.add(node.data)
                return true
            }else{
                return false
            }
        }

        if(checkSumHelper(node.left, sum-node.data, list)){
            list.add(node.data)
            return true
        }

        if (checkSumHelper(node.right, sum-node.data, list)){
            list.add(node.data)
            return true
        }

        return false;
    }
}