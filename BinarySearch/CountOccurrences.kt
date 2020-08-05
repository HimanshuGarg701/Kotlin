package BinarySearch

fun main(args : Array<String>){
    val array = arrayOf(1,2,3,3,3,4,4,5,5,5,5,6)
    countOccurrences(1, array)
}

private fun countOccurrences(num : Int, array : Array<Int>){
    var first = -1
    var last = -1
    first = findFirstOccurrence(0, array.size-1, array, num)
    if(first!=-1){
        last = findLastOccurrence(0, array.size-1, array, num)
        println("The number is ${last-first+1}")
    }
}

private fun findLastOccurrence(start:Int, end:Int, array:Array<Int>, num : Int) : Int{
    var result = -1
    var first = start
    var last = end
    var mid = -1
    while(first<=last){

        mid = first + (last-first)/2
        if(num < array[mid]){
            last = mid-1
        }
        else if(num > array[mid]){
            first = mid+1
        }else{
            result = mid
            first = mid+1
        }
    }
    return result
}

private fun findFirstOccurrence(start:Int, end:Int, array:Array<Int>, num : Int) : Int{
    var result = -1
    var first = start
    var last = end
    var mid = -1
    while(first<=last){

        mid = first + (last-first)/2
        if(num < array[mid]){

            last = mid-1
        }
        else if(num > array[mid]){
            first = mid+1
        }else if(num==array[mid]){
            result = mid
            last = mid-1

        }
    }
    return result
}

