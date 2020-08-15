package Recursion

fun main(args:Array<String>){
    val input = "abc"
    val output = ""
    findSubsets(input, output)
}

private fun findSubsets(input:String, output:String){
    if(input.length==0){
        println("\"$output\"")
        return
    }else{
        val output1 = output
        var output2 = output
        output2 += input[0]
        val newInput = input.substring(1,input.length)
        findSubsets(newInput, output1)
        findSubsets(newInput, output2)
        return
    }
}