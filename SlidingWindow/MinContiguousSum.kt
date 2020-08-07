package SlidingWindow

fun main(args : Array<String>){
    val array = arrayOf(1,2,3,4,5,6)
    val k = 3
    findMinSum(array, k)
}

private fun findMinSum(array: Array<Int>, k:Int){
    var start = 0
    var minSum = Int.MAX_VALUE
    var windowSum = 0
    for(end in 0..array.size-1){
        windowSum += array[end]
        if(end>=k-1){
            minSum = Math.min(minSum, windowSum)
            windowSum -= array[start]
            start++
        }
    }

    println("The minimum sum of size k is $minSum")
}