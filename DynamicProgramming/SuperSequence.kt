package DynamicProgramming

fun main(args:Array<String>){
    val x = "book"
    val y = "okay"
    //Find length of shortest string that can have from which subseq of both x and y can be extracted
    findLen(x, y, x.length, y.length)
}

private fun findLen(x:String, y:String, xLen:Int, yLen:Int){
    val matrix = Array(xLen+1){Array(yLen+1){0} }
    for(i in 1..xLen){
        for(j in 1..yLen){
            if(x[i-1] == y[j-1]){
                matrix[i][j] = 1 + matrix[i-1][j-1]
            }else{
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1])
            }
        }
    }
    println("Shortest lenght that can be formed is: ${xLen+yLen-matrix[xLen][yLen]}")
}