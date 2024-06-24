package az.company.microservice.service

import az.company.microservice.model.User
import az.company.microservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService   (@Autowired private val userRepository : UserRepository) {
    fun getUserById(id: Long) : User? {
        return userRepository.findById(id).orElse(null)
    }
    fun saveUser(user : User) : User {
        return userRepository.save(user)
    }
    fun getUsers(): List<User> {
        return userRepository.findAll();
    }

    fun deleteUser(id: Long) {
        return userRepository.deleteById(id)
    }
}