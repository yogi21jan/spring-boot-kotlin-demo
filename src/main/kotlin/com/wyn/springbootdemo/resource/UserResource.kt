package com.wyn.springbootdemo.resource

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@RestController
@RequestMapping("/")
class UsersResource(val usersRepository: UsersRepository) {

    val counter = AtomicLong();

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

    @GetMapping("/users")
    fun getUsers() = usersRepository.findAll()

    @PostMapping("/users")
    fun insertUsers(@RequestBody user:Users): List<Users> {
        usersRepository.save(user)
        return usersRepository.findAll()
    }
}

@Entity
class Users(val name: String = "",
            val salary: Int = 2000,
            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            val id: Long = 0)

data class Greeting(val id: Long, val content: String)

interface UsersRepository : JpaRepository<Users, Long>
