fun main(args: Array<String>) {
    val person = Person("João", 25)
    println("Before title: ${person.getGreeting()}")
    person.addTitle(Title.MISTER)
    println("After title: ${person.getGreeting()}")
}

class Person {

    private val name: String
    private val age: Int
    private var title: Title? = null

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    fun getName(): String {
        return name
    }

    fun getAge(): Int {
        return age
    }

    fun getTitle(): Title? {
        return title
    }

    fun getGreeting(): String {
        return "Hello ${title?.prefix ?: ""} $name!"
    }

    fun addTitle(title: Title) {
        this.title = title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        other as Person
        if (name != other.name) return false
        if (age != other.age) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        result = 31 * result + (title?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Person(name='${getName()}', age=${getAge()}, title=${getTitle()})"
    }
}

enum class Title(val prefix: String) {
    MISTER("Mr."), SIR("Sir"), PRESIDENT("Pr.");
}

