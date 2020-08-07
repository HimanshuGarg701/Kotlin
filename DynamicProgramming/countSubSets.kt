package DynamicProgramming

fun main(args : Array<String>){
    val array = arrayOf(2,3,5,6,8,10)
    println("Number of subsets with sum 10 : ${countSets(array, 10)}")
}

private fun countSets(array : Array<Int>, sum : Int):Int{
    val matrix = Array(array.size+1){Array(sum+1){0} }
    for(i in 0..array.size){
        matrix[i][0] = 1
    }

    for(i in 1..array.size){
        for(j in 1..sum){
            if(array[i-1] <= j){
                matrix[i][j] = matrix[i-1][j-array[i-1]] + matrix[i-1][j]
            }else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }

    return matrix[array.size][sum]
}