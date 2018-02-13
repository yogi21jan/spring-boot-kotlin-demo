package com.wyn.springbootdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootDemoApplication::class.java, *args)
}
