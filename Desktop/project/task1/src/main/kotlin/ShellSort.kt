import java.math.RoundingMode
import java.text.DecimalFormat

class ShellSort {

    companion object{
        fun sort(array: Array<Int>) {
            val size = array.size
            var gap = size/2
            while (gap>0){
                var i = gap
                while (i < size){
                    val temp = array[i]
                    var j = i
                    while (j>=gap && array[j-gap]>temp){
                        array[j]=array[j-gap]
                        j-=gap
                    }
                    array[j]=temp
                    i++
                }
                gap /=2
        }
        }


        fun main(args: Array<String>,string : Int) {
            val n = if (args.size >= 1) Integer.parseInt(args[0]) else 100000
            var count = 0
            var time1: Double = 0.0

            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.CEILING
            while (count != string) {
                val nums = WorkinMoments.randomInts(n)

                time1 += WorkinMoments.time( { ShellSort.sort(nums) })

                count++

            }
            System.out.println("ShellSort took " + df.format(time1 / string) + " secs ")

        }
    }
}