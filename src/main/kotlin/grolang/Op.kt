package grolang

sealed class Op : (World) -> Unit {

    abstract class Simple(private val code: (World) -> Unit) : Op() {
        override fun invoke(world: World) {
            code(world)
        }
    }

    object MoveRight : Simple({ it.dp++ })
    object MoveLeft : Simple({ it.dp-- })
    object Inc : Simple({ it.value = (it.value + 1) % 256 })
    object Dec : Simple({ it.value = (if (it.value != 0) it.value - 1 else 255) })
    object Print : Simple({ print(it.value.toChar()) })

    class While(private val ops: List<Op>) : Op() {

        override fun invoke(world: World) {
            while (world.data[world.dp] != 0)
                for (op in ops)
                    op(world)
        }
    }
}
