package jp.co.kokou.basicwebapp.features.home.dto

import jakarta.validation.constraints.NotBlank

data class NameDto(
    @field:NotBlank
    val name: String,
)
