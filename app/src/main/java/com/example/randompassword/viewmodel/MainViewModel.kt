package com.example.randompassword.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random


class MainViewModel : ViewModel() {

    var generatedPassword: String by mutableStateOf("Passwords")
    var passwordStatus: String by mutableStateOf("")
    var visiblePassword: Boolean by mutableStateOf(true)

    var passwords: String by mutableStateOf("")
    var allowedPass: String by mutableStateOf("")

    var digit: Boolean by mutableStateOf(true)
    var letterUpper: Boolean by mutableStateOf(true)
    var letterLower: Boolean by mutableStateOf(true)
    var symbol: Boolean by mutableStateOf(true)
    var length: Float by mutableStateOf(6f)


    val upperChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowerChar = "abcdefghijklmnopqrstuvwxyz"
    val digitChar = "0123456789"
    val symbolChar = "~@#$%^&*()!"

    fun generatePasswords() {
        passwords = ""

        // Determine password strength based on length
        when (length.toInt()) {
            in 6..7 -> passwordStatus = "is a weak password"
            in 8..9 -> passwordStatus = "is a good password"
            in 10..11 -> passwordStatus = "is a hard password"
            in 12..Int.MAX_VALUE -> passwordStatus = "is a very strong password"
        }

        // Build the password
        if (digit) {
            val randomIndex = Random.nextInt(digitChar.length)
            passwords += digitChar[randomIndex]
            allowedPass += digitChar
        }

        if (letterUpper) {
            val randomIndex = Random.nextInt(upperChar.length)
            passwords += upperChar[randomIndex]
            allowedPass += upperChar
        }

        if (letterLower) {
            val randomIndex = Random.nextInt(lowerChar.length)
            passwords += lowerChar[randomIndex]
            allowedPass += lowerChar
        }

        if (symbol) {
            val randomIndex = Random.nextInt(symbolChar.length)
            passwords += symbolChar[randomIndex]
            allowedPass += symbolChar
        }

        val remainingLength = length.toInt() - passwords.length

        // Fill remaining characters
        for (i in 0 until remainingLength) {
            val randomIndex = Random.nextInt(allowedPass.length)
            passwords += allowedPass[randomIndex]
        }

        generatedPassword = passwords
    }
}
