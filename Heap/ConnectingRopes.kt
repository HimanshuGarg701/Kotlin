package Heap

import java.util.*

fun main(args:Array<String>){
    val array = arrayOf(1,2,3,4,5)
    findCost(array)
}

private fun findCost(array:Array<Int>){
    val minHeap = PriorityQueue<Int>()
    var cost = 0
    for(i in array){
        minHeap.add(i)
    }

    while(minHeap.size>1){
        val first = minHeap.poll()
        val second = minHeap.poll()
        cost += first+second
        minHeap.add(first+second)
    }

    print("The total cost is $cost")
}