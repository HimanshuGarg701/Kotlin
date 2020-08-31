package Array

fun main(args:Array<String>){
    val arr = arrayOf(1,2,3,2,5,6,6,8,8,10)
    findMissingAndDuplicate(arr)
}

//Original:     1   2   3   2   5
//Index:        0   1   2   3   4
//Actual:       1   2   3   4   5

private fun findMissingAndDuplicate(arr:Array<Int>){
    var start = 0
    val end = arr.size
    while(start<end){
        if(arr[start]!=start+1){
            val res = swap(arr, start, arr[start]-1)
            if(!res){
                println("Missing: ${start+1}")
                println("Duplicate: ${arr[start]}")
                start++
            }
        }else{
            start++
        }
    }

    for(i in arr){
        print("  $i  ")
    }
}

private fun swap(arr:Array<Int>, firstIndex:Int, secondIndex:Int):Boolean{
    if(arr[firstIndex]!=arr[secondIndex]) {
        val temp = arr[firstIndex]
        arr[firstIndex] = arr[secondIndex]
        arr[secondIndex] = temp
        return true
    }else{
        return false
    }
}