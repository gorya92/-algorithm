import java.math.RoundingMode
import java.text.DecimalFormat

class HeapSort {
    companion object{
        fun sort(array: Array<Int>){

                var end = array.size-1
                initHeap(array,array.size)
                array[0]=array[end].also { array[end]=array[0] }
                end--
                while (end>0){
                    adjustHeap(array,end,0)
                    array[0]=array[end].also { array[end]=array[0] }
                    end--
                }

        }
        fun initHeap(array: Array<Int>, length: Int):Array<Int>{
            if(length==1) return array
            val m = length/2-1
            for(k in m downTo  0){
                adjustHeap(array,array.size-1,k)
            }
            return array
        }
        fun adjustHeap(array: Array<Int>, end:Int, index:Int){
            var i = index
            var j =2*i +1
            while(j<end+1){
                if(j+1<end+1 && array[j]<array[j+1]) j++
                if (array[j]>array[i]){
                    array[i]=array[j].also { array[j]=array[i] }
                    i=j
                    j=2*i+1
                }else{
                    break
                }
            }
        }
        fun main(args: Array<String>,string: Int) {
            val n = if (args.size >= 1) Integer.parseInt(args[0]) else 100000
            var count = 0
            var time1: Double = 0.0

            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.CEILING
            while (count != string) {
                val nums = WorkinMoments.randomInts(n)

                time1 += WorkinMoments.time( { HeapSort.sort(nums) })

                count++

            }
            System.out.println("HeapSort took " + df.format(time1 / string) + " secs ")

        }
    }
}