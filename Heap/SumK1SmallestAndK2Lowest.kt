package Heap

import java.util.*

fun main(args : Array<String>){
    val array = arrayOf(1,2,3,4,5,6,7,8,9,10)

    //2nd smallest and 5th largest
    sum(2,5, array)
}

private fun sum(smallest : Int, largest:Int, array:Array<Int>){
    val maxHeap = PriorityQueue<Int>{a,b->b-a}
    val minHeap = PriorityQueue<Int>()

    for(i in array){
        maxHeap.add(i)
        minHeap.add(i)

        if(maxHeap.size>smallest){
            maxHeap.poll()
        }

        if(minHeap.size>largest){
            minHeap.poll()
        }
    }

    println("The sum is ${maxHeap.poll() + minHeap.poll()}")
}