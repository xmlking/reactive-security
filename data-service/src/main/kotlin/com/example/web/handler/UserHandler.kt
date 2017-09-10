package com.example.web.handler

import com.example.domain.Role
import com.example.domain.User
import com.example.repository.UserRepository
import com.example.util.json
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.created
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.toMono
import java.net.URI.create
import java.net.URLDecoder


@Component
class UserHandler(val repository: UserRepository) {

    fun principal(req: ServerRequest) =
            ok().json().body(req.principal().cast(Authentication::class.java).map { it.principal })

    fun admin(req: ServerRequest) = ok().json().syncBody(mapOf("isadmin" to "true"))

    fun findOneView(req: ServerRequest) =
        repository.findByLogin(URLDecoder.decode(req.pathVariable("login"), "UTF-8")).flatMap {
            ok().render("user", mapOf(Pair("user", it.toDto())))
        }

    fun findOne(req: ServerRequest) = ok().json().body(repository.findByLogin(req.pathVariable("login")))

    fun findAll(req: ServerRequest) = ok().json().body(repository.findAll())
    fun findAllStaff(req: ServerRequest) = ok().json().body(repository.findAllByRole(Role.STAFF))
    fun findOneStaff(req: ServerRequest) = ok().json().body(repository.findByLoginAndRoleAndCompany(req.pathVariable("login"), Role.STAFF, "Microsoft"))

    fun create0(req: ServerRequest) = repository.save(req.bodyToMono<User>().block()).map {
        created(create("/api/user/${it!!.id}")).json().body(it.toMono().toMono())
    }

    fun create(req: ServerRequest) = created(create("/api/user/xxx")).json().body(repository.save(req.bodyToMono<User>().block()).toMono())
}


class UserDto(
    val login: String,
    val firstname: String,
    val lastname: String,
    val age: Int,
    var email: String,
    var company: String? = null,
    var emailHash: String? = null,
    var photoUrl: String? = null,
    val role: Role,
    val logoType: String?,
    val logoWebpUrl: String? = null
)

fun User.toDto() =
    UserDto(login, firstname, lastname, age, email, company,
        emailHash, photoUrl, role, logoType(photoUrl), logoWebpUrl(photoUrl))

private fun logoWebpUrl(url: String?) =
    when {
        url == null -> null
        url.endsWith("png") -> url.replace("png", "webp")
        url.endsWith("jpg") -> url.replace("jpg", "webp")
        else -> null
    }

private fun logoType(url: String?) =
    when {
        url == null -> null
        url.endsWith("svg") -> "image/svg+xml"
        url.endsWith("png") -> "image/png"
        url.endsWith("jpg") -> "image/jpeg"
        else -> null
    }
