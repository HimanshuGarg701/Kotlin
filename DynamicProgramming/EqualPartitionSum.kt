package DynamicProgramming

fun main(args:Array<String>){
    val array = arrayOf(2,4,6,9,3)
    var sum = 0
    for(i in array){
        sum += i
    }

    if(sum%2!==0){
        println("Array cannot be divided into 2 equal partitions")
    }else{
        println("Array with sum $sum can be divided into 2 equal partitions? : ${checkPartition(sum/2, array)}")
    }
}

private fun checkPartition(sum : Int, array:Array<Int>):Boolean{
    val matrix = Array(array.size+1){Array(sum+1){false}}

    for(i in 0..array.size){
        matrix[i][0] = true
    }

    for(i in 1..array.size){
        for(j in 1..sum){
            if(array[i-1] <= j){
                matrix[i][j] = (matrix[i-1][j-array[i-1]]) || (matrix[i-1][j])
            }
            else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }
    return matrix[array.size][sum]
}