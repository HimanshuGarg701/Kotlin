package SlidingWindow

fun main(args : Array<String>){
    val array = arrayOf(2,3,4,5,2,1)
    val k = 3
    findMaxSum(array, k)
}

private fun findMaxSum(array:Array<Int>, k:Int){
    var maxSum = Int.MIN_VALUE
    var start = 0
    var windowSum = 0

    for(end in 0..array.size-1){
        windowSum += array[end]
        if(end>=k-1){
            maxSum = Math.max(maxSum, windowSum)
            windowSum -= array[start]
            start++
        }
    }

    println("The max sum is $maxSum")
}