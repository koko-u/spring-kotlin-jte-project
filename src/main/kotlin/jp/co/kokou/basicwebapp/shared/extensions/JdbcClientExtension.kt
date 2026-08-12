package jp.co.kokou.basicwebapp.shared.extensions

import org.springframework.jdbc.core.SimplePropertyRowMapper
import org.springframework.jdbc.core.simple.JdbcClient

inline fun <reified T : Any> JdbcClient.StatementSpec.queryRows(): JdbcClient.MappedQuerySpec<T> =
    query(SimplePropertyRowMapper(T::class.java))

inline fun <reified T : Any> JdbcClient.StatementSpec.queryScalarOrNull(): T? =
    query(T::class.java).optional().orElse(null)

inline fun <reified T : Any> JdbcClient.StatementSpec.queryScalar(): T =
    query(T::class.java).single()
