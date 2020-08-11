package DynamicProgramming

fun main(args:Array<String>){
    val x = "abce"
    val y = "abde"

    findLongestSubstring(x,y,x.length, y.length)
}

private fun findLongestSubstring(x:String, y:String, xLen:Int, yLen:Int){
    val matrix = Array(xLen+1){Array(yLen+1){0} }
    for(i in 1..xLen){
        for(j in 1..yLen){
            if(x[i-1]==y[j-1]){
                matrix[i][j] = 1 + matrix[i-1][j-1]
            }else{
                matrix[i][j] = 0
            }
        }
    }
    var maxLen = 0
    for(i in 0..xLen){
        for(j in 0..yLen){
            maxLen = Math.max(maxLen, matrix[i][j])
        }
    }

    println("Max length of substring is: $maxLen")
}