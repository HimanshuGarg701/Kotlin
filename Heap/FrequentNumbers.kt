package Heap

import java.util.*
import kotlin.collections.HashMap

fun main(args : Array<String>){
    val array = arrayOf(1,1,1,2,2,3,3,3,3,4,4,4,4,4,5,5,5,5,5,5,6,6,6,7)
    val result = findMostFrequent(3, array)

    for(i in result){
        print("  $i  ")
    }
}

private fun findMostFrequent(k : Int, array: Array<Int>) : Array<Int>{
    val result = Array(k){0}
    val map = HashMap<Int, Int>()

    for(i in array){
        if(map.containsKey(i)){
            map.put(i, map.get(i)!!.plus(1))
        }else{
            map.put(i, 1)
        }
    }

    val minHeap = PriorityQueue<Int>{a,b -> map.get(a)!!-map.get(b)!!}

    for(key in map.keys){
        minHeap.add(key)
        if(minHeap.size>k){
            minHeap.poll()
        }
    }

    var count=0
    for(i in 0..minHeap.size-1){
        result[count] = minHeap.poll()
        count++
    }
    return result
}