package com.example

import com.example.domain.User
import com.example.domain.Role
import com.example.repository.UserRepository
import com.example.repository.RoleRepository
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class DataInitializer(val userRepository: UserRepository,val roleRepository: RoleRepository) {

    @EventListener(ContextRefreshedEvent::class)
    fun init()  {
        // we are using src/resources/schema.sql,data.sql for now.
        // initRoles()
        // initUsers()
    }

    private fun initRoles() {
        // roleRepository.deleteAll()
        if(roleRepository.count()  == 0L) {
            val userRole = Role(Role.ROLE_USER)
            val actuatorRole = Role(Role.ROLE_ACTUATOR)
            val adminRole = Role(Role.ROLE_ADMIN)
            roleRepository.saveAll(mutableSetOf(userRole, adminRole, actuatorRole))
        }
    }
    private fun initUsers() {
        // userRepository.deleteAll()
        if(userRepository.count()  == 0L) {
            val userRole = roleRepository.findOneByName(Role.ROLE_USER)
            val actuatorRole = roleRepository.findOneByName(Role.ROLE_ACTUATOR)
            val adminRole = roleRepository.findOneByName(Role.ROLE_ADMIN)
            val sumo = User("sumo", "demo", "sumo@demo.com", "sumo", "demo", mutableSetOf(userRole!!))
            val actuator = User("actuator", "actuator", "actuator@demo.com", "actuator", "actuator", mutableSetOf(actuatorRole!!))
            val sumo1 = User("sumo1", "demo1", "sumo1@demo.com", "sumo1", "demo1", mutableSetOf(userRole, actuatorRole))
            val admin = User("admin", "admin", "admin@demo.com", "admin", "admin", mutableSetOf(adminRole!!))
            userRepository.saveAll(listOf(sumo, actuator, sumo1, admin))
        }

//        val admin = userRepository.findOneByUsername("admin")
//        admin!!.firstName = "admin1sdfsf44353455"
//        userRepository.save(admin)
    }
}
