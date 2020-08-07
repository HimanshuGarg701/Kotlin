package DynamicProgramming

import kotlin.math.max

val array = arrayOf(0)
fun main(args : Array<String>){
    val weight = arrayOf(1,2,3,2,1)
    val values = arrayOf(5,6,3,2,11)
    val matrix = Array(weight.size+1){Array(6){-1}}
    val startTime = System.nanoTime()
    println("Max profit is : ${findProfit(weight, values, weight.size, 5, matrix)}")
    println("Time consumed : ${System.nanoTime()-startTime}")
    println("Num Recursions ${array[0]}")
    for(i in 0..matrix.size-1){
        for(j in 0..5){
            print("  ${matrix[i][j]}  ")
        }
        println("")
    }

}

private  fun findProfit(weight:Array<Int>, values : Array<Int>, n:Int, maxWt:Int, matrix:Array<Array<Int>>) : Int{
    if(n==0 || maxWt==0){
        return 0
    }

    if(matrix[n][maxWt]!=-1){
        return matrix[n][maxWt]
    }
    if(weight[n-1]<=maxWt){
        array[0] = array[0] + 1
        matrix[n][maxWt] = max(values[n-1] + findProfit(weight, values, n-1, maxWt-weight[n-1], matrix),
                findProfit(weight, values, n-1, maxWt, matrix))
        return matrix[n][maxWt]
    }else{
        array[0] = array[0] + 1
        matrix[n][maxWt] = findProfit(weight, values, n-1, maxWt, matrix)
        return matrix[n][maxWt]
    }
}