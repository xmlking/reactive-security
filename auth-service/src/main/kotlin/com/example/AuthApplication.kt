package com.example

import com.example.util.run
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
//@EnableJpaAuditing
class AuthApplication


fun main(args: Array<String>) {
    run(AuthApplication::class, *args)
}
