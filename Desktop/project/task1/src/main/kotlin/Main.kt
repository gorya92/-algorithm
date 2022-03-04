import java.util.*


fun main() {

        val array = arrayOf<String>("100000")
        alghoritms(array,10)

}


fun alghoritms(array: Array<String>,n:Int){
    InsertionSort.main(array,n)
    SelectionSort.main(array,n)
    CombSort.main(array,n)
    ShellSort.main(array,n)
    TournamentSort.main(array,n)
    QuickSort.main(array,n)
    HeapSort.main(array,n)
}
