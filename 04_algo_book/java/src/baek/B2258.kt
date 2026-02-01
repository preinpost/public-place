package baek

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val a = bf.readLine().toInt()
    val b = bf.readLine().toInt()

    println(a + b)
}