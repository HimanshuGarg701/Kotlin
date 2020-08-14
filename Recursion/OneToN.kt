package Recursion

fun main(args:Array<String>){
    printElements(10)
}

private fun printElements(num:Int){
    if(num==1){
        print("  $num  ")
    }else{
        printElements(num-1)
        print("  $num  ")
    }
}