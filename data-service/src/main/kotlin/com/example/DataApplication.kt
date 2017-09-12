package com.example

import com.example.util.run
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@SpringBootApplication
class DataApplication


fun main(args: Array<String>) {
    run(DataApplication::class, *args)
}
