package Heap

import java.util.*

fun main(args : Array<String>){
    val array = arrayOf(7,6,4,3,9,11,10)
    sortArray(3, array)

    for(i in array){
        print("  $i  ")
    }
}

private fun sortArray(default: Int, array:Array<Int>){
    val minHeap = PriorityQueue<Int>()
    var count=0
    for(i in array){
        minHeap.add(i)
        if(minHeap.size>default){
            array[count] = minHeap.poll()
            count++
        }
    }

    while(minHeap.size>0){
        array[count] = minHeap.poll()
        count++
    }
}