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
        this.first() + interval.first(),
        this.last() + interval.last()
    )

fun Interval.minus(interval: Interval): Interval =
    Interval(
        this.first() - interval.last(),
        this.last() - interval.first()
    )

fun Interval.multiply(interval: Interval): Interval = Interval(
    min(
        this.first() * interval.first(),
        this.first() * interval.last(),
        this.last() * interval.first(),
        this.last() * interval.last()
    ),
    max(
        this.first() * interval.first(),
        this.first() * interval.last(),
        this.last() * interval.first(),
        this.last() * interval.last()
    )
)


fun min(vararg args: Long) = args.toList().min()
fun max(vararg args: Long) = args.toList().max()

