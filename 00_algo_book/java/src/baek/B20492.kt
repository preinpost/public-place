package baek

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()

    val ans1 = (n * (1 - 0.22)).toInt()
    val ans2 = (n * (1 - 0.2 * 0.22)).toInt()

    print("$ans1 $ans2")

}