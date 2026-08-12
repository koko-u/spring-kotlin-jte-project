package jp.co.kokou.basicwebapp.shared.viewmodel

data class Page(
    override val title: String?,
    override val currentMenu: String?,
) : IPage {
    constructor() : this(null, null)
}
