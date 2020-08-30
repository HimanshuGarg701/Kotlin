package GreedyAlgorithm

fun main(args:Array<String>){
    val start = arrayOf(0,5,8,5,1,3)
    val finish = arrayOf(6,7,9,9,2,4)
    findNumActicities(start, finish, start.size)
}

private fun findNumActicities(start:Array<Int>, finish:Array<Int>, size:Int){
    val map = HashMap<Int, Int>()
    for(i in 0..size-1){
        map.put(finish[i], start[i])
    }
    map.toSortedMap()
}