package com.example.lab1.logic

const val SAMPLE_TEXT = "Хочу предложить забаву парням с Рыбинска."

private val VOWELS =
    setOf('a', 'e', 'i', 'o', 'u', 'y', 'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я')

fun sortWordsByVowels(text: String): String =
    text.split(Regex("\\s+"))
        .filter { it.isNotEmpty() }
        .sortedBy { word -> word.count { it.lowercaseChar() in VOWELS } }
        .joinToString(" ")
