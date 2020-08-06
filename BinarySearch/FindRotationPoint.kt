package BinarySearch

fun main(args : Array<String>){
    val array = arrayOf(5,6,7,8,9,1,2,3,4)
    findRotation(array)
}

private fun findRotation(array : Array<Int>){
    var start = 0
    var end = array.size-1
    var mid = -1
    var left = -1
    var right = -1
    while(start<=end){
        mid = start + (end-start)/2
        left = (mid-1+array.size)%array.size
        right = (mid+1)%array.size

        if(array[mid]<array[left] && array[mid]<array[right]){
            println("Rotation at index : $mid")
            break
        }else if(array[end]<array[mid]){
            start = mid+1
        }
        else{
            end = mid-1
        }
    }

}