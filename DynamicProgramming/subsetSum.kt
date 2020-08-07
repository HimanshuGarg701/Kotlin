package DynamicProgramming

fun main(args:Array<String>){
    val array = arrayOf(1,2,3,4,5,6,7,8)
    val checkFor = 10
    println("The subset of $checkFor is present in array? ${isSubsetPresent(array, checkFor)}")
}

private fun isSubsetPresent(array:Array<Int>, sum : Int) : Boolean{
    val matrix = Array(array.size+1){Array(sum+1){false}}
    for(i in 0..array.size){
        matrix[i][0] = true
    }

    for(i in 1..array.size){
        for(j in 1..sum){
            if(array[i-1] <= j){
                matrix[i][j] = (matrix[i-1][j- array[i-1]]) || (matrix[i-1][j])
            }else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }
    return matrix[array.size][sum]
}