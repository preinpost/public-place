package baek

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val sentence = bf.readLine()

    if ("SONGDO".equals(sentence)) {
        println("HIGHSCHOOL")
    } else if ("CODE".equals(sentence)) {
        println("MASTER")
    } else if ("2023".equals(sentence)) {
        println("0611")
    } else {
        println("CONTEST")
    }
}