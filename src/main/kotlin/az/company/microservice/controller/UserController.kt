package az.company.microservice.controller

import az.company.microservice.model.User
import az.company.microservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.getUserById(id)
        return if (user!=null){
            ResponseEntity.ok(user)
        }else{
            ResponseEntity.notFound().build()
        }
    }
    @PostMapping("/adduser")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val savedUser = userService.saveUser(user)
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }
    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<User>> {
        val users = userService.getUsers()
        return ResponseEntity(users, HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        val existingUser=userService.getUserById(id)
            return if (existingUser!=null){
                userService.deleteUser(id)
                ResponseEntity.noContent().build()
            }else{
                ResponseEntity.notFound().build()
            }
    }
    @PutMapping("/add/{id}")
    fun updateUserById(@PathVariable id: Long, @RequestBody updateUser: User): ResponseEntity<User> {
         val existingUser=userService.getUserById(id)
        return if (existingUser == null){
            ResponseEntity.notFound().build()

        }else{
            updateUser.id=id
            return  ResponseEntity.ok(userService.saveUser(updateUser))
        }
    }
}