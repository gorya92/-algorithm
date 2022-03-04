import java.math.RoundingMode
import java.text.DecimalFormat

class QuickSort {
    companion object{
        private fun sort(arr: Array<Int>, fromIndex: Int, toIndex: Int){
            if (fromIndex < toIndex){
                var middleIndex = partition(arr, fromIndex, toIndex);
                sort(arr, fromIndex, middleIndex - 1);
                sort(arr, middleIndex + 1, toIndex);
            }
        }

        private fun partition(arr: Array<Int>, fromIndex: Int, toIndex: Int) : Int{
            var lastElementValue = arr[toIndex];
            var i = fromIndex - 1;
            for (j in fromIndex..toIndex - 1){
                if (arr[j] <= lastElementValue){
                    i++;
                    arr[i]=arr[j].also { arr[j]=arr[i] }
                }
            }

            arr[i+1]=arr[toIndex].also { arr[toIndex]=arr[i+1] }
            return i + 1;
        }
        fun main(args: Array<String>,string : Int) {
            val n = if (args.size >= 1) Integer.parseInt(args[0]) else 100000
            var count = 0
            var time1: Double = 0.0

            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.CEILING
            while (count != string) {
                val nums = WorkinMoments.randomInts(n)

                time1 += WorkinMoments.time({ QuickSort.sort(nums,0,n-1) })
                count++

            }
            System.out.println("QuickSort took " + df.format(time1 / string) + " secs ")
        }
    }
}