package com.example.lab1.logic

class WordSorter {
    fun countVowels(word: String): Int = word.count { isVowel(it) }

    private val vowels = setOf('a', 'e', 'i', 'o', 'u', 'y', 'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я')
    fun isVowel(character : Char): Boolean{
        return character.lowercaseChar() in vowels
    }

    fun sortWordsByVowels(text: String) : String{
        val words = text.split(Regex("\\s+")).filter { it.isNotEmpty() }
        val sortedWordList = words.sortedBy {word -> countVowels(word)}
        return sortedWordList.joinToString (" ")
    }
    companion object {
        const val SAMPLE_TEXT =
            "Я собака - ты собака, я собака - ты собака"
    }
}