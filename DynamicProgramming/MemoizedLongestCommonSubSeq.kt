package DynamicProgramming

fun main(args:Array<String>){
    val x = "abcdefgh"
    val y = "acdbcdeh"
    val matrix = Array(x.length+1){Array(y.length+1){-1} }

    //Longest common subsequence
    println("Longest subseq : ${longestSubSequence(x, y, x.length, y.length, matrix)}")
}

private fun longestSubSequence(x:String, y:String, xLen:Int, yLen:Int, matrix:Array<Array<Int>>):Int{
    if(xLen==0 || yLen==0){
        return 0
    }

    if(matrix[xLen][yLen]!=-1){
        return matrix[xLen][yLen]
    }

    if(x[xLen-1] == y[yLen-1]){
        matrix[xLen][yLen] = 1+ longestSubSequence(x,y, xLen-1, yLen-1, matrix)
        return matrix[xLen][yLen]
    }else{
        matrix[xLen][yLen] = Math.max(longestSubSequence(x,y,xLen-1, yLen, matrix),
                                        longestSubSequence(x,y,xLen,yLen-1, matrix))
        return matrix[xLen][yLen]
    }
}