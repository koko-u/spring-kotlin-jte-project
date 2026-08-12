package jp.co.kokou.basicwebapp.features.home.viewmodel

import org.springframework.validation.BindingResult

data class IndexError(
    val propertyName: String,
    val errorMessage: String,
)

fun BindingResult.toIndexErrors(): List<IndexError> =
    this.fieldErrors.map { e -> IndexError(e.field, e.defaultMessage ?: "Invalid ${e.field}") }
