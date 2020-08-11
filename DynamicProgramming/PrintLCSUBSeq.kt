package DynamicProgramming

import javax.swing.BoxLayout

fun main(args:Array<String>){
    val x = "abcdefgh"
    val y = "acdbcdeh"
    println("Longest subseq : ${longestSubSequence(x, y, x.length, y.length)}")
}

private fun longestSubSequence(x:String, y:String, xLen:Int, yLen:Int) : String{
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

    var result = ""
    var i = xLen
    var j = yLen
    while(i>0 && j>0){
        if(x[i-1]==y[j-1]){
            result += x[i-1]
            i--
            j--
        }else{
            if(matrix[i-1][j]>matrix[i][j-1]){
                i--
            }else{
                j--
            }
        }
    }
    return result.reversed()
}