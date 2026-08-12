package jp.co.kokou.basicwebapp.features.home.viewmodel

import jp.co.kokou.basicwebapp.shared.viewmodel.IPage

data class MessagePage(
    val message: String,
    private val page: IPage,
) : IPage by page
