package com.example.bootwithdocker;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@EnableSwagger2
@Api(value = "swagger test")
public class BootWithDockerApplication {

	private AtomicInteger atomicInteger = new AtomicInteger(0);
	private Map<Integer, User> userMap = new ConcurrentHashMap<>();

	@GetMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	@ApiOperation(value = "hello", notes = "just say hello")
	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name") String name) {
		return "hello " + name;
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		Integer userId = atomicInteger.addAndGet(1);
		user.setId(userId);
		userMap.put(userId, user);
		return user;
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") Integer userId) {
		return userMap.get(userId);
	}

	@GetMapping("/users")
	public List<User> getUsers(UserParams params) {
		List<Integer> userIds = params.getUserIds();
		String nameLike = params.getNameLike();
		return userIds.stream()
				.map(userId -> userMap.get(userId))
				.filter(user -> user.getName().contains(nameLike))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(BootWithDockerApplication.class, args);
	}

}
