package jp.co.kokou.basicwebapp.features.home.viewmodel

import jp.co.kokou.basicwebapp.shared.viewmodel.IPage

data class IndexPage(
    val errors: List<IndexError>,
    private val page: IPage,
) : IPage by page {
    constructor(page: IPage) : this(emptyList(), page)
}
