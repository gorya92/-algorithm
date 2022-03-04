import java.math.RoundingMode
import java.text.DecimalFormat

class SelectionSort {
    companion object{
        private fun sort(v : Array<Int>){
            val len = v.size
            var pos: Int
            var tmp: Int
            for (i in 0 until len) {
                pos = i
                for (j in i + 1 until len) {
                    if (v[j] < v[pos])
                        pos = j
                }
                tmp = v[i]
                v[i] = v[pos]
                v[pos] = tmp
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

                time1 += WorkinMoments.time({ SelectionSort.sort(nums) })
                count++

            }
            System.out.println("SelectionSort took " + df.format(time1 / string) + " secs ")
        }
        }
    }
