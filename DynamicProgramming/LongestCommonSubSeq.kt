package DynamicProgramming

fun main(args:Array<String>){
    val x = "abcdefgh"
    val y = "acdbcdeh"
    println("Longest subseq : ${longestSubSequence(x, y, x.length, y.length)}")
}

private fun longestSubSequence(x:String, y:String, xSize:Int, ySize:Int) : Int{
    if(xSize==0 || ySize==0){
        return 0
    }else{
        if(x[xSize-1]==y[ySize-1]){
            return 1+ longestSubSequence(x,y,xSize-1, ySize-1)
        }else{
            return Math.max(longestSubSequence(x,y,xSize-1,ySize), longestSubSequence(x,y,xSize,ySize-1))
        }
    }
}