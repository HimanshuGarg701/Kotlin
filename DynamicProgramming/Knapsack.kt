package DynamicProgramming

import kotlin.math.max

fun main(args : Array<String>){
    val weight = arrayOf(1,2,3,2,1)
    val values = arrayOf(5,6,3,2,11)

    println("Max profit is : ${findProfit(weight, values, weight.size, 5)}")

}

private  fun findProfit(weight:Array<Int>, values : Array<Int>, n:Int, maxWt:Int) : Int{
    if(n==0 || maxWt==0){
        return 0
    }

    else if(weight[n-1]<=maxWt){
        return max(values[n-1] + findProfit(weight, values, n-1, maxWt-weight[n-1]),
                findProfit(weight, values, n-1, maxWt))
    }else{
        return findProfit(weight, values, n-1, maxWt)
    }
}