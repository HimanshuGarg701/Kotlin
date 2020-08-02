package Heap

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max

fun main(args : Array<String>){
    val matrix = arrayOf(
                        arrayOf(1,2),
                        arrayOf(2,-2),
                        arrayOf(0, 0),
                        arrayOf(-1, -2),
                        arrayOf(-2, 3)
                        )

    findClosest(3, matrix)
}

private fun findClosest(k : Int, matrix : Array<Array<Int>>){
    val map = HashMap<Array<Int>, Int>()
    val maxHeap = PriorityQueue<Array<Int>>{a,b -> map.get(b)!!-map.get(a)!!}

    for(point in matrix){
        map.put(point, point[0]*point[0] + point[1]*point[1])
    }

    for((key, value) in map){
        maxHeap.add(key)
        if(maxHeap.size>k){
            maxHeap.poll()
        }
    }

    for(i in 0..maxHeap.size-1){
        val removed = maxHeap.poll()
        print("  [${removed[0]}, ${removed[1]}]  ")
    }


}