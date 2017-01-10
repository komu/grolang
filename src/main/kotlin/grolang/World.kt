package grolang

class World {
    var dp = 0
    val data = IntArray(100000)

    var value: Int
        get() = data[dp]
        set(v) { data[dp] = v }
}
