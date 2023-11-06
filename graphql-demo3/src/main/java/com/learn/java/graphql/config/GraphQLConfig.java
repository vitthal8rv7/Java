//package com.learn.java.graphql.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.learn.java.graphql.resolver.EmployeeResolver;
//
//import graphql.schema.GraphQLSchema;
//import io.leangen.graphql.GraphQLSchemaGenerator;
//import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
//
//@Configuration
//public class GraphQLConfig {
//
//    @Bean
//    public GraphQLSchema graphQLSchema() {
//        return new GraphQLSchemaGenerator()
//            .withResolverBuilders(new AnnotatedResolverBuilder())
//            .withOperationsFromSingleton(new EmployeeResolver())
//            .generate();
//    }
//}
