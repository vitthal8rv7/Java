package com.learn.java.graphql.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.learn.java.graphql.model.Animal;
import com.learn.java.graphql.model.Cat;
import com.learn.java.graphql.model.Dog;
import com.learn.java.graphql.model.Post;
import com.learn.java.graphql.model.User;

import graphql.GraphQLError;

@Controller
public class Queries2 {

//	@QueryMapping
//	public List<Object> search(@Argument(name = "keyword") String keyword) {
//		String lowerKeyword = keyword.toLowerCase();
//		List<Object> results = new ArrayList<>();
//		final List<User> users = Arrays.asList(new User("1", "John Doe"), new User("2", "Jane Doe"));
//
//		final List<Post> posts = Arrays.asList(
//				new Post("1", "GraphQL Introduction", "GraphQL is a query language for APIs."),
//				new Post("2", "Spring Boot with GraphQL", "How to use GraphQL with Spring Boot."));
//		users.stream()
//			.filter(user -> user.getName().toLowerCase().contains(lowerKeyword))
//			.forEach(results::add);
//		posts.stream()
//			.filter(post -> post.getTitle().toLowerCase().contains(lowerKeyword)
//				|| post.getContent().toLowerCase().contains(lowerKeyword))
//			.forEach(results::add);
//		if(!Objects.isNull(results)) {
//			throw new ArithmeticException("TEST123");
//		}
//		return results;
//	}
//	
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
