package Recursion

fun main(args:Array<String>){
    var input = "abc"
    var output = ""
    if(input.length>0){
        output += input[0]
    }
    solve(input.substring(1,input.length), output)
}

private fun solve(input:String, output:String){
    if(input.length==0){
        print("  $output  ")
    }else{
        val output1 = output + "_${input[0]}"
        val output2 = output + "${input[0]}"
        val updatedInput = input.substring(1, input.length)
        solve(updatedInput, output1)
        solve(updatedInput, output2)

    }
}