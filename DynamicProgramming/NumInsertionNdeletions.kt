package DynamicProgramming

fun main(args:Array<String>){
    val x = "abcd"
    val y = "cde"
    //Num of insertions and deletions required to convert x to y
    findInsertionsDeletions(x,y,x.length,y.length)
}

private fun findInsertionsDeletions(x:String, y:String, xLen:Int, yLen:Int){
    val matrix = Array(xLen+1){Array(yLen+1){0} }
    for(i in 1..xLen){
        for(j in 1..yLen){
            if(x[i-1]==y[j-1]){
                matrix[i][j] = 1 + matrix[i-1][j-1]
            }else{
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1])
            }
        }
    }
    println("Insertions : ${yLen-matrix[xLen][yLen]}")
    println("Deletions : ${xLen-matrix[xLen][yLen]}")
}