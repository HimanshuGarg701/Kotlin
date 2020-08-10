package DynamicProgramming

fun main(args : Array<String>){
    val array = arrayOf(2,4,5,3,6,7)
    val values = arrayOf(5,4,3,2,7,10)
    findMax(array, array.size, 18, values)
}

private fun findMax(array : Array<Int>, size:Int, maxWt:Int, values:Array<Int>){
    val matrix = Array(size+1){Array(maxWt+1){0} }

    for(i in 1..size){
        for(j in 1..maxWt){
            if(array[i-1]<=j) {
                matrix[i][j] = Math.max(values[i - 1] + matrix[i][j-array[i-1]], matrix[i-1][j])
            }else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }

    println("Max values is :  ${matrix[size][maxWt]}")
}