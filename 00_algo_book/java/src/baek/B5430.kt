package baek

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * AC
 */
fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))

    val tc = bf.readLine().toInt()

    val answer = StringBuffer()

    for (i in 0 until tc) {

        val cmds = bf.readLine()
        val numCnt = bf.readLine().toInt()
        var numsOrigin = bf.readLine()
        numsOrigin = numsOrigin.substring(1, numsOrigin.length - 1)

        val nums = if (numCnt > 1) {
            numsOrigin.split(",")
        } else if (numCnt == 0){
            ArrayList()
        } else {
            val arr = ArrayList<String>()
            arr.add(numsOrigin)
            arr
        }

        round(nums, cmds, answer)
    }
    println(answer)
}

fun round(nums: List<String>, cmds: String, answer: StringBuffer) {
    var reversed = false
    var p1 = 0
    var p2 = nums.size - 1

    for (i in cmds.indices) {
        if (cmds[i] == 'R') {
            reversed = !reversed
            val tmp = p1
            p1 = p2
            p2 = tmp
        } else {
            if (reversed) {
                val nextP1 = p1 - 1

                if (nextP1 < -1) {
                    answer.append("error").append("\n")
                    return
                }
                p1 = nextP1
            } else {
                val nextP1 = p1 +1

                if (nextP1 > nums.size) {
                    answer.append("error").append("\n")
                    return
                }
                p1 = nextP1
            }
        }
    }
    answer.append("[")
    if (reversed) {
        for (i in p1 downTo p2) {
            if (i != p2)
                answer.append(nums[i]).append(",")
            else answer.append(nums[i])
        }
    } else {
        for (i in p1..p2) {
            if (i != p2)
                answer.append(nums[i]).append(",")
            else answer.append(nums[i])
        }
    }
    answer.append("]").append("\n")

}