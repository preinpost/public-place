package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val line = bf.readLine()

    val split = line.split(" ")
    val a = BigInteger(split[0])
    val b = BigInteger(split[1])

    println(a.add(b))
}