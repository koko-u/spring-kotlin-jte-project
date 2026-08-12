package jp.co.kokou.basicwebapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicWebAppApplication

fun main(args: Array<String>) {
    runApplication<BasicWebAppApplication>(*args)
}
