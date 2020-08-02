package Heap

import java.util.*


fun main(args : Array<String>){
    val array = arrayOf(1,2,3,4,5,6,7,8)
    val result = findLargestElements(3, array)
    for(i in result){
        print("  $i  ")
    }
}

private fun findLargestElements(k : Int, array : Array<Int>) : Array<Int>{
    val result = Array(k){0}
    val minHeap = PriorityQueue<Int>()

    for(i in 0..array.size-1){
        minHeap.add(array[i])
        if(minHeap.size>k){
            minHeap.poll()
        }
    }
    var count = 0
    for(i in 0..minHeap.size-1){
        result[count] = minHeap.poll()
        count++
    }
    return result
}