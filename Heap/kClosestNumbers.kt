package Heap

import java.util.*
import kotlin.collections.HashMap

fun main(args : Array<String>){
    //Finding 3 numbers closest to 12
    val result = Array(3){0}
    val array = arrayOf(2,4,5,7,8,10,12,14,16)
    findClosest(12, 3, array, result)
    for(i in result){
        print("  $i  ")
    }
}

private fun findClosest(num : Int, k : Int, array: Array<Int>, result:Array<Int>){
    val map = HashMap<Int, Int>()
    for(i in array){
        map.put(i, Math.abs(i-num))
    }
    val maxHeap = PriorityQueue<Int>{a,b -> map.get(b)!!-map.get(a)!!}

    for((key, value) in map){
        maxHeap.add(key)
        if(maxHeap.size>k){
            maxHeap.poll()
        }
    }

    var count = 0
    for(i in 0..maxHeap.size-1){
        result[count] = maxHeap.poll()
        count++
    }

}