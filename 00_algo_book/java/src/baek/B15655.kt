package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val line = bf.readLine().split(" ")

    val n = line[0].toInt()
    val m = line[1].toInt()

    val nums = bf.readLine().split(" ")
    val arr = IntArray(n)

    for (i in 0 until n) {
        arr[i] = nums[i].toInt()
    }

    Arrays.sort(arr)

    backtracking(arr, IntArray(m), 0, 0, n, m)


}

fun backtracking(arr: IntArray, candid: IntArray, startIdx: Int, currentIdx: Int, n: Int, m: Int) {
    if (currentIdx == m) {
        val sb = StringBuilder()
        for (i in candid) {
            sb.append(i).append(" ")
        }
        println(sb)
        return
    }

    for (i in startIdx until n) {
        candid[currentIdx] = arr[i]
        backtracking(arr, candid, i + 1, currentIdx + 1, n, m)
    }
}