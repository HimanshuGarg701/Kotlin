package Recursion

fun main(args:Array<String>){
    val list = ArrayList<Int>()
    list.add(2)
    list.add(5)
    list.add(6)
    list.add(1)
    list.add(4)
    list.add(3)

    sortList(list)
    for(i in list){
        print("  $i  ")
    }
}

private fun sortList(list:ArrayList<Int>){
    if(list.size==1 || list.size==0){
        return
    }else{
        val rem = list[list.size-1]
        list.removeAt(list.size-1)
        sortList(list)
        insert(rem, list)
    }
}

private fun insert(toAdd:Int, list:ArrayList<Int>){
    if(list.size==0 || list[list.size-1]<=toAdd){
        list.add(toAdd)
        return
    }else{
        val rem = list[list.size-1]
        list.removeAt(list.size-1)
        insert(toAdd, list)
        list.add(rem)
    }
}