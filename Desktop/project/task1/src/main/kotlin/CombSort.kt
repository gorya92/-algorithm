import java.math.RoundingMode
import java.text.DecimalFormat

class CombSort {




companion object{
     fun sort(array: Array<Int>) {
         var gap = array.size
         var swaps = false
         while(gap>1 || swaps){
             gap=(gap/1.237331).toInt()
             if (gap<1) gap=1
             var i =0
             swaps = false
             while (i + gap < array.size){
                 if (array[i]>array[i+gap]){
                     val tmp = array[i]
                     array[i]=array[i+gap]
                     array[i+gap]=tmp
                     swaps=true
                 }
                 i++
             }
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

            time1 += WorkinMoments.time( { CombSort.sort(nums) })

            count++

        }
        System.out.println("CombSort took " + df.format(time1 / string) + " secs ")

    }
}
}