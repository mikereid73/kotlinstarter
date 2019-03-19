fun main(args: Array<String>) {
    val p1 = Person.Builder()
            .build()
    val p2 = Person.Builder()
            .firstName("Michael")
            .lastName("Reid")
            .age(31)
            .build();

    println("P1 = $p1")
    println("P2 = $p2")
}

class Person private constructor(builder: Person.Builder) {

    private val firstName: String?
    private val lastName: String?
    private val age: Int?

    init {
        this.firstName = builder.firstName
        this.lastName = builder.lastName
        this.age = builder.age
    }

    override fun toString(): String {
        return "Name: $firstName $lastName, Age: $age"
    }

    class Builder {
        var firstName: String? = null
            private set
        var lastName: String? = null
            private set
        var age: Int? = null
            private set

        fun firstName(firstName: String) = apply {
            this.firstName = firstName
        }

        fun lastName(lastName: String) = apply {
            this.lastName = lastName
        }

        fun age(age: Int) = apply {
            this.age = age
        }

        fun build(): Person {
            return Person(this)
        }
    }
}