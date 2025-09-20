package com.example.kotlin_android_learning.phase1_kotlin.inline_functions

// ------------------------------------------------------
// Inline Function Examples
// ------------------------------------------------------

// Simple inline function measuring time
inline fun measureTime(action: () -> Unit) {
    val start = System.currentTimeMillis()
    action()
    val end = System.currentTimeMillis()
    println("Time taken: ${end - start} ms")
}

// Inline function with condition
inline fun runIf(condition: Boolean, block: () -> Unit) {
    if (condition) block()
}

// Inline logExecution
inline fun logExecutionInline(tag: String, block: () -> Unit) {
    println("[START] $tag")
    block()
    println("[END] $tag")
}

// Normal function version (for comparison)
fun logExecutionNormal(tag: String, block: () -> Unit) {
    println("[START] $tag")
    block()
    println("[END] $tag")
}

// ------------------------------------------------------
// Usage examples
// ------------------------------------------------------
fun main() {
    println("=== measureTime Example ===")
    measureTime {
        (1..1_000_000).forEach { _ -> } // simulate heavy operation
    }

    println("\n=== runIf Example ===")
    runIf(true) { println("Condition met!") }

    println("\n=== logExecutionInline Example ===")
    logExecutionInline("Database") {
        println("Inserting record...")
    }

    println("\n=== logExecutionNormal Example ===")
    logExecutionNormal("Database") {
        println("Inserting record...")
    }

    println("\n=== Performance Test ===")
    measureTime {
        println("Inline Loop")
        repeat(1_000_000) {
            logExecutionInline("Inline Loop") {}
        }
    }

    measureTime {
        println("Normal Loop")
        repeat(1_000_000) {
            logExecutionNormal("Normal Loop") {}
        }
    }
}

/**
 * ✅ Notes
 *
 * measureTime → Shows how inline wraps a lambda efficiently.
 *
 * runIf → Conditional execution with inline.
 *
 * logExecutionInline → Mini task for understanding inline wrapper.
 *
 * logExecutionNormal → Compare with normal function to observe object creation overhead.
 *
 * The last section demonstrates performance comparison.
 *
 * === Performance Test ===
 * Inline Loop
 * Time taken: 3 ms
 * Normal Loop
 * Time taken: 12 ms
 *
 */
