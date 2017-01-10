package grolang

import examples.HelloWorld

fun makeItSo(clazz: Class<*>) {
    val code = codeGen(clazz)
    val world = World()

    for (op in parse(code))
        op(world)
}

val opCodes = "<>+-.[]"

fun codeGen(code: Class<*>) = code.declaredMethods
        .sortedBy { it.name }
        .map { opCodes[it.name.length % opCodes.length] }
        .joinToString("")

fun main(args: Array<String>) {
    makeItSo(HelloWorld::class.java)
}
