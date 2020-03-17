import kotlin.reflect.typeOf

fun main() {
    var s = "Hello world";
    val str2 :String = "Hello world";
    var intArr: Array<Int> = arrayOf(1,2,3,4,5,6,7,8,9,0);
    var boolEan: Boolean = true;

    var ifVar = if (boolEan) "true" else "false";

    println(s);
    println(str2);
    println(intArr);
    println(boolEan);
    println(ifVar);

    var person = Person("Hello", "World",16);
    println(person.getFullName());
    println(person.getCurrentAge());
    println(person.elapseYear(3));

//    println(checkIsBool("Hello"));

    var gen = Gen("Hello");
}

//generic
//fun checkIsBool (param:? super T) {
//    return (typeof param == Boolean);
//}

//interface
interface Foo {
    val bar: Int;
    fun baz(qux: String) :String;
}

class OverrideFoo(override val bar: Int) : Foo {
    override fun baz(qux: String): String {
        println(qux);
        return qux;
    }
}

//overriding
open class Person(private val firstName: String, private val lastName: String, private var age: Int) {
    open val newName: String // open 작성
        get() = "$firstName $lastName"

    fun getFullName(): String {
        return "$firstName $lastName";
    }

    fun elapseYear(years: Int = 1): Int {
        age += years;
        return age;
    }

    fun getCurrentAge():Int = age;
}

class Child(private val firstName: String, private val lastName: String, private var age: Int) : Person(firstName,lastName, age) {
    override val newName: String
        get() = "$lastName $firstName"
}

//generic
class Gen<T>(var value: T){
    fun checkIsBoolean(){
        return value is Boolean;
    }
}
