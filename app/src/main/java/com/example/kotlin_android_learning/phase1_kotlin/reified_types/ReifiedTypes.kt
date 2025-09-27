package com.example.kotlin_android_learning.phase1_kotlin.reified_types

inline fun <reified T> isOfType(value: Any) = value is T

inline fun <reified T> safeCast(value: Any) = value as? T

inline fun <reified T> printClassName(value: T? = null) =
    println("Type is : ${T::class.qualifiedName}")

inline fun <reified T> parseJson(json: String): T {
    print("Parsing JSON into type: ${T::class.qualifiedName}")
    return when(T::class) {
        String::class -> json as T
        Int::class -> json.toInt() as T
        else -> throw IllegalArgumentException("Unsupported type")
    }
}

fun main() {
    // Type Checker
    println("Type Checker")
    println(isOfType<String>("Abc")) // true
    println(isOfType<Int>("Abc"))    // false

    // Safe Casting
    println("\nSafe Casting")
    println(safeCast<Int>("123"))   // null
    println(safeCast<String>("Hi")) // Hi

    // Class Logger
    println("\nClass Logger")
    printClassName<String>()
    printClassName(123)

    // JSON Parsing Simulation
    println("\nJSON Parsing Simulation")
    println(parseJson<Int>("123"))
    println(parseJson<String>("Hello"))
}

/**
 * isOfType → Checks if a value is of a certain type at runtime using reified generics.
 *
 * safeCast → Safely casts a value to the specified type at runtime using reified generics.
 *
 * printClassName<T>() → Logs the runtime type of a variable or explicit type.
 *
 * parseJson<T>() → Demonstrates a real-world use case of reified inline functions to parse JSON into the correct type at runtime.
 */
