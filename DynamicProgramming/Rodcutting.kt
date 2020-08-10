package DynamicProgramming

fun main(args:Array<String>){
    val values = arrayOf(3,4,2,1,5,6)
    val maxLen = 15
    findMax(values, maxLen, values.size)
}

private fun findMax(values:Array<Int>, maxLen:Int, size:Int){
    val length = Array(size){0}
    var count=0
    for(i in 1..size){
        length[count++] = i
    }

    val matrix = Array(size+1){Array(maxLen+1){0}}

    for(i in 1..size){
        for(j in 1..maxLen){
            if(length[i-1]<=j){
                matrix[i][j] = Math.max(values[i-1] + matrix[i][j-length[i-1]], matrix[i-1][j])
            }else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }
    println("The max value is: ${matrix[size][maxLen]}")
}