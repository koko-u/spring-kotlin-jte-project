package jp.co.kokou.basicwebapp.features.home.dao

import jp.co.kokou.basicwebapp.shared.extensions.queryScalarOrNull
import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Repository

@Repository
class MessagesDao(
    val client: JdbcClient,
) {
    fun selectLastMessage(): String? =
        client
            .sql(
                """
                SELECT "message"
                FROM "messages"
                ORDER BY "created_at" DESC
                LIMIT 1
                """.trimIndent(),
            ).queryScalarOrNull<String>()

    fun insertMessage(message: String?): Int =
        client
            .sql(
                """
                INSERT INTO "messages" ("message")
                VALUES (:message)
                """.trimIndent(),
            ).param("message", message)
            .update()
}
