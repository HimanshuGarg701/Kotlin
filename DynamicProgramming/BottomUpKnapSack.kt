package DynamicProgramming

import java.util.Collections.max

fun main(args : Array<String>){
    val weight = arrayOf(1,2,3,2,1)
    val values = arrayOf(5,6,3,2,11)
    val size = weight.size
    val maxWt = 5

    println("The max profit is ${findProfit(weight, values, size, maxWt)}")
}

private fun findProfit(weight : Array<Int>, values : Array<Int>, n : Int, maxWt:Int) : Int{
    val matrix = Array(n+1){Array(maxWt+1){0}}

    for(i in 1..n){
        for(j in 1..maxWt){
            if(j > weight[i-1]){
                matrix[i][j] = Math.max(values[i-1] + matrix[i-1][j-weight[i-1]], matrix[i-1][j])
            }else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }
    return matrix[n][maxWt]
}