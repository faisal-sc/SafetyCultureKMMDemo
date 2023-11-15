package utils

object PasswordValidator {
    const val MIN_LENGTH = 8

    fun validate(input: String): Boolean {
        return input.length < MIN_LENGTH
    }
}