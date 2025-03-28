package uz.orifjon.intervals

class Interval(a: Long, b: Long) {
    private val a: Long
    private val b: Long

    init {
        if (a > b) {
            this.a = b
            this.b = a
        } else {
            this.a = a
            this.b = b
        }
    }

    fun first(): Long = a

    fun last(): Long = b

    fun contains(value: Long): Boolean {
        return value in a..b
    }

    override fun toString(): String {
        return "[$a, $b]"
    }
}


fun Interval.plus(interval: Interval): Interval =
    Interval(
        if (this.first() > interval.first()) this.first() else interval.first(),
        if (this.last() > interval.last()) this.last() else interval.last()
    )