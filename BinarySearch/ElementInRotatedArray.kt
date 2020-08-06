package BinarySearch

fun main(args : Array<String>){
    val array = arrayOf(4,5,6,7,8,1,2,3)
    findElement(5, array)
}

private fun findElement(num : Int, array:Array<Int>){
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
            if(array[mid]==num){
                println("Number present at index $mid")
            }else if(num<=array[array.size-1]){
                findHelper(array, mid, array.size-1, num)
            }else{
                findHelper(array, 0, mid, num)
            }
            break
        }else if(array[end]<array[mid]){
            start = mid+1
        }
        else{
            end = mid-1
        }
    }
}

private fun findHelper(array:Array<Int>, start:Int, end:Int, num : Int){
    var first = start
    var last = end
    var mid = -1
    while(first<=last){
        mid = first + (last-first)/2
        if(array[mid]==num){
            println("Element found at index $mid")
            break
        }else if(num<array[mid]){
            last = mid-1
        }else{
            first = mid+1
        }
    }
}