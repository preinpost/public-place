package baek

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 테트로미노
 */

lateinit var check: Array<IntArray>
var n: Int = 0
var m: Int = 0
var max: Int = Integer.MIN_VALUE

fun main() {

    /**
     * 모양이 5개
     * 지도에는 가중치가 있음
     */

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val read = bf.readLine()

    n = read.split(" ")[0].toInt()
    m = read.split(" ")[1].toInt()

    val map = Array(n) { IntArray(m) }
    check = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val numbers = bf.readLine()
        for (j in 0 until m) {
            map[i][j] = numbers.split(" ")[j].toInt()
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            check[i][j] = 1
            dfs(0, i, j, 0, map)
            check[i][j] = 0
        }
    }

    println(max)
}

val di = listOf(1, 0, -1, 0)
val dj = listOf(0, 1, 0, -1)

val pathA = listOf(intArrayOf(0, -1, 1), intArrayOf(-1, 0, 0)) // ㅓ
val pathB = listOf(intArrayOf(0, 0, -1), intArrayOf(-1, 1, 0)) // ㅗ
val pathC = listOf(intArrayOf(-1, 1, 0), intArrayOf(0, 0, 1)) // ㅏ
val pathD = listOf(intArrayOf(0, 0, 1), intArrayOf(-1, 1, 0)) // ㅜ

fun typeA(i: Int, j: Int, map: Array<IntArray>): Int {
    var sum = map[i][j]
    for (k in 0 until 3) {
        val ni = i + pathA[0][k]
        val nj = j + pathA[1][k]

        if (ni < 0 || nj < 0 || ni >= n || nj >= m) return 0

        sum += map[ni][nj]
    }

    return sum
}

fun typeB(i: Int, j: Int, map: Array<IntArray>): Int {
    var sum = map[i][j]
    for (k in 0 until 3) {
        val ni = i + pathB[0][k]
        val nj = j + pathB[1][k]

        if (ni < 0 || nj < 0 || ni >= n || nj >= m) return 0

        sum += map[ni][nj]
    }

    return sum
}

fun typeC(i: Int, j: Int, map: Array<IntArray>): Int {
    var sum = map[i][j]
    for (k in 0 until 3) {
        val ni = i + pathC[0][k]
        val nj = j + pathC[1][k]

        if (ni < 0 || nj < 0 || ni >= n || nj >= m) return 0

        sum += map[ni][nj]
    }

    return sum
}

fun typeD(i: Int, j: Int, map: Array<IntArray>): Int {
    var sum = map[i][j]
    for (k in 0 until 3) {
        val ni = i + pathD[0][k]
        val nj = j + pathD[1][k]

        if (ni < 0 || nj < 0 || ni >= n || nj >= m) return 0

        sum += map[ni][nj]
    }

    return sum
}

fun dfs(depth: Int, i: Int, j: Int, sum: Int, map: Array<IntArray>) {
    if (depth == 4) {
        if (sum > max) {
            max = sum
        }
        return
    }

    if (i < 0 || j < 0 || i >= n || j >= m) return

    for (k in 0 until 4) {
        val ni = di[k] + i
        val nj = dj[k] + j

        if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue
        if (check[ni][nj] == 1) continue

        val nsum = sum + map[ni][nj]
        check[ni][nj] = 1
        dfs(depth + 1, ni, nj, nsum, map)
        check[ni][nj] = 0
    }

    max = Math.max(max, typeA(i, j, map))
    max = Math.max(max, typeB(i, j, map))
    max = Math.max(max, typeC(i, j, map))
    max = Math.max(max, typeD(i, j, map))
}

