package DynamicProgramming

import kotlin.math.max

var arr = arrayOf(0)
fun main(args : Array<String>){
    val weight = arrayOf(1,2,3,2,1)
    val values = arrayOf(5,6,3,2,11)
    val startTime = System.nanoTime()
    println("Max profit is : ${findProfit(weight, values, weight.size, 5)}")
    println("Time consumed : ${System.nanoTime()-startTime}")
    println("Num Recursions ${arr[0]}")
}

private  fun findProfit(weight:Array<Int>, values : Array<Int>, n:Int, maxWt:Int) : Int{
    if(n==0 || maxWt==0){
        return 0
    }

    else if(weight[n-1]<=maxWt){
        arr[0] = arr[0] + 1
        return max(values[n-1] + findProfit(weight, values, n-1, maxWt-weight[n-1]),
                findProfit(weight, values, n-1, maxWt))
    }else{
        arr[0] = arr[0] + 1
        return findProfit(weight, values, n-1, maxWt)
    }
}