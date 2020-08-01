package Tree

fun main(args : Array<String>){
    var x = Tree();

    x.addNode(15)
    x.addNode(5)
    x.addNode(20)

    x.print()

    println("\n----------------Iterative add--------------------------")
    var y = Tree()
    y.iterativeAdd(15)
    y.iterativeAdd(5)
    y.iterativeAdd(20)

    y.print()

    println("\n--------------------SIZE OF TREE-----------------------------")
    x.size();

    println("--------------------HEIGHT OF TREE---------------------------")
    x.height()
}