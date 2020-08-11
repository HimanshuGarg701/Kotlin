package DynamicProgramming

fun main(args:Array<String>){
    //Maximum number of ways to form given sum using given number of coins
    val coins = arrayOf(1,2,3)
    val target = 5
    findWays(coins, target)
}

private fun findWays(coins:Array<Int>, target:Int){
    val matrix = Array(coins.size+1){Array(target+1){0} }
    for(i in 0..coins.size){
        matrix[i][0] = 1
    }

    for(i in 1..coins.size){
        for(j in 1..target){
            if(coins[i-1]<=j){
                matrix[i][j] = matrix[i][j-coins[i-1]] + matrix[i-1][j]
            }else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }

    println("The max number of ways: ${matrix[coins.size][target]}")
}

//  0 1   2   3
//0 1 0   0   0
//1 1
//2 1