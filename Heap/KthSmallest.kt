package Heap

import java.util.*

fun main(args : Array<String>){
    val array = arrayOf(1,2,3,4,5,6,7,8)
    findKthSmallest(4, array)
}

private fun findKthSmallest(k: Int, array:Array<Int>){
    val maxHeap = PriorityQueue<Int>{a,b->b-a}
    for(i in array){
        maxHeap.add(i)
        if(maxHeap.size>k){
            maxHeap.poll()
        }
    }

    print("$k th smallest element is ${maxHeap.poll()}")
}