import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

class InsertionSort {

    companion object {

        private fun sort(v : Array<Int>){
            val len = v.size
            var tmp: Int
            var j: Int
            for (i in 1 until len) {
                tmp = v[i]
                j = i
                while (j > 0) {
                    if (v[j - 1] > tmp)
                        v[j] = v[j - 1]
                    else
                        break
                    j--
                }
                v[j] = tmp
            }
        }




        fun main(args: Array<String> , string : Int) {
            val n = if (args.size >= 1) Integer.parseInt(args[0]) else 100000
            var count = 0
            var time1: Double = 0.0

            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.CEILING
            while (count != string) {
                val nums = WorkinMoments.randomInts(n)

                time1 += WorkinMoments.time( { InsertionSort.sort(nums) })

                count++

            }
            System.out.println("InsertionSort took " + df.format(time1 / string) + " secs ")

        }
    }
}