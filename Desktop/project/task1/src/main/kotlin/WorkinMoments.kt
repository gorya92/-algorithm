import java.util.*

class WorkinMoments {
    companion object{
        public fun randomInts(n: Int): Array<Int> {
            val r = Random()
            val v = Array<Int>(n){0}
            for (i in 0 until n)
                v[i] = r.nextInt(10 * n)
            return v
        }
        public fun time( action: Runnable) : Double {
            val start = System.currentTimeMillis()
            action.run()
            val finish = System.currentTimeMillis()
            return  (finish - start).toDouble() / 1000.0

        }
    }
}