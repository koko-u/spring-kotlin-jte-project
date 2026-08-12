package jp.co.kokou.basicwebapp.shared.extensions

import org.springframework.jdbc.core.SimplePropertyRowMapper
import org.springframework.jdbc.core.simple.JdbcClient

inline fun <reified T : Any> JdbcClient.StatementSpec.query(): JdbcClient.MappedQuerySpec<T> =
    query(SimplePropertyRowMapper(T::class.java))
