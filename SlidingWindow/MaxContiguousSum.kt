package SlidingWindow

fun main(args : Array<String>){
    val array = arrayOf(2,3,4,5,2,1)
    val k = 3
    findMaxSum(array, k)
}

private fun findMaxSum(array:Array<Int>, k:Int){
    var maxSum = 0
    for(i in 0..array.size-k){
        var windowSum = 0
        for(j in i..(i+k-1)){
            windowSum += array[j]
        }
        maxSum = Math.max(maxSum, windowSum)
    }

    println("The max sum is $maxSum")
}