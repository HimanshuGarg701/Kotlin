package DynamicProgramming

fun main(args:Array<String>){
    val x = "abcbea"
    //Find length of longest palindromic subsequence
    findLen(x, x.length)
}

private fun findLen(x:String, xLen:Int){
    val y = x.reversed()
    findLenHelper(x,y,xLen,y.length)
}

private fun findLenHelper(x:String, y:String, xLen:Int, yLen:Int){
    val matrix = Array(xLen+1){Array(yLen+1){0} }
    for(i in 1..xLen){
        for(j in 1..yLen){
            if(x[i-1]==y[j-1]){
                matrix[i][j] = 1+ matrix[i-1][j-1]
            }else{
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1])
            }
        }
    }
    println("Longest palindromic subsequence is: ${matrix[xLen][yLen]}")
}
