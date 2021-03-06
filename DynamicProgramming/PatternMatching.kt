package DynamicProgramming

fun main(args:Array<String>){
    val x = "abc"
    val y = "ancbjdhc"

    checkXinY(x,y,x.length,y.length)
}

private fun checkXinY(x:String, y:String, xLen:Int, yLen:Int){
    val matrix = Array(xLen+1){Array(yLen+1){0} }
    for(i in 1..xLen){
        for(j in 1..yLen){
            if(x[i-1]==y[j-1]){
                matrix[i][j] = 1+matrix[i-1][j-1]
            }else{
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1])
            }
        }
    }
    if(matrix[xLen][yLen]==x.length){
        println("x exits within y as subsequence")
    }
    else{
        println("x does not exit within y as subsequence")
    }
}