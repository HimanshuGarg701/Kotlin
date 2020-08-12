package DynamicProgramming

fun main(args:Array<String>){
    val x = "aabcecdd"
    //abd and abd are the 2 longest repeating subsequences
    findLen(x, x.reversed(), x.length, x.length)
}

private fun findLen(x:String, y:String, xLen:Int, yLen:Int){
    val matrix = Array(xLen+1){Array(yLen+1){0} }
    for(i in 1..xLen){
        for(j in 1..yLen){
            if(x[i-1]==y[j-1] && i!=j){
                matrix[i][j] = 1 + matrix[i-1][j-1]
            }else{
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1])
            }
        }
    }
    println("Longest repeating subsequence: ${matrix[xLen][yLen]}")
}