package Recursion

fun main(args:Array<String>){
    val input = "abc"
    val output = ""
    solve(input, output)
}

private fun solve(input:String, output:String){
    if(input.length==0){
        print("  $output  ")
    }else{
        var output1 = output
        var output2 = output
        output1 += (input[0].toLowerCase())
        output2 += (input[0].toUpperCase())
        val updatedInput = input.substring(1, input.length)
        solve(updatedInput, output1)
        solve(updatedInput, output2)
    }
}