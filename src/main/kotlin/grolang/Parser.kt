package grolang

import java.util.*

fun parse(code: String): List<Op> =
    parse(CharReader(code))

private fun parse(code: CharReader): List<Op> {
    val ops = ArrayList<Op>()

    while (code.hasMore) {
        when (code.read()) {
            '<' -> ops += Op.MoveLeft
            '>' -> ops += Op.MoveRight
            '+' -> ops += Op.Inc
            '-' -> ops += Op.Dec
            '.' -> ops += Op.Print
            '[' -> ops += Op.While(parse(code))
            ']' -> return ops
        }
    }

    return ops
}

private class CharReader(private val code: String) {
    private var pos = 0

    val hasMore: Boolean
        get() = pos < code.length

    fun read(): Char = code[pos++]
}
