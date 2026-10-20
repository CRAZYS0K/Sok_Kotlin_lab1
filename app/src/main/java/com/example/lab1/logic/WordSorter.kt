package com.example.lab1.logic

class WordSorter {

    private val vowels =
        setOf('a', 'e', 'i', 'o', 'u', 'y', 'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я')

    private fun isVowel(character: Char): Boolean {
        return character.lowercaseChar() in vowels
    }

    fun countVowels(word: String): Int = word.count { isVowel(it) }
    fun sortWordsByVowels(text: String): String {
        val words = text.split(Regex("\\s+")).filter { it.isNotEmpty() }
        val sortedWordList = words.sortedBy { word -> countVowels(word) }
        return sortedWordList.joinToString(" ")
    }

    companion object {
        const val SAMPLE_TEXT =
            "Хочу предложить забаву парням с Рыбинска."
    }
}