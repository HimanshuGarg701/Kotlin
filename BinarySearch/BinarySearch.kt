package BinarySearch

fun main(args : Array<String>){
    val array = arrayOf(1,2,3,4,5,6,7,8)
    find(6, array)
}

private fun find(num : Int, array : Array<Int>){
    var start = 0;
    var end = array.size-1
    var mid = -1;
    while(start<=end){
        mid = start + (end-mid)/2
        if(num < array[mid]){
            end = mid-1
        }
        else if(num > array[mid]){
            start = mid+1
        }
        else{
            println("The number is present at index $mid")
            break
        }
    }
}