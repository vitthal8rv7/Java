package com.learn.java.graphql.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.learn.java.graphql.annotation.ValidateRequest;
import com.learn.java.graphql.annotation.util.RequestValidator;
import com.learn.java.graphql.model.Post;
import com.learn.java.graphql.model.User;

import jakarta.validation.Valid;

@Controller
public class Queries2 {

//	@ValidateRequest(message = "vlaue not 10.")
//	Integer value = 10;
//	
//	@ValidateRequest(message = "Inside test.")
//	public void test() {
//		System.out.println("INSIDE TEST.....");
//	}
	@QueryMapping
	public List<Object> search(@Argument(name = "keyword") String keyword) {
		//test();
		String lowerKeyword = keyword.toLowerCase();
		List<Object> results = new ArrayList<>();
		final List<User> users = Arrays.asList(new User("1", "John Doe"), new User("2", "Jane Doe"));

		final List<Post> posts = Arrays.asList(
				new Post("1", "GraphQL Introduction", "GraphQL is a query language for APIs."),
				new Post("2", "Spring Boot with GraphQL", "How to use GraphQL with Spring Boot."));
		users.stream()
			.filter(user -> user.getName().toLowerCase().contains(lowerKeyword))
			.forEach(results::add);
		posts.stream()
			.filter(post -> post.getTitle().toLowerCase().contains(lowerKeyword)
				|| post.getContent().toLowerCase().contains(lowerKeyword))
			.forEach(results::add);
//		if(!Objects.isNull(results)) {
//			throw new ArithmeticException("TEST123");
//		}
		return results;
	}
	
//	@GraphQlExceptionHandler
//	public GraphQLError handleException(Exception e) {
//		GraphQLError ge = GraphQLError.newError().message("Error123_"+e.getMessage(),"").build();
//		System.out.println("GraphQLError: "+ ge);
//		return ge;
//	    // Return custom GraphQLError
//	}
//	
//	@SchemaMapping(typeName = "resolveType") 
//    public Class<?> resolveType(Object searchResult) {
//        if (searchResult instanceof User) {
//            return User.class;
//        } else if (searchResult instanceof Post) {
//            return Post.class;
//        }
//        return null;
//    }
	
    @SchemaMapping(typeName = "searchResult")   // anything but not "SearchResult", it is type define for union
    public Class<?> resolveType(Object result) {
        if (result instanceof User) {
            return User.class;
        } else if (result instanceof Post) {
            return Post.class;
        }
        return null;
    }
}
