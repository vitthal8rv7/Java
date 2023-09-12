package com.learn.java.collection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.java.collection.service.ListDemoService;
import com.learn.java.collection.service.MapDemoService;
import com.learn.java.collection.service.QueueDemoService;
import com.learn.java.collection.service.SetDemoService;

@RestController
public class controller {

	@Autowired
	private ListDemoService listDemoService;

	@Autowired
	private SetDemoService setDemoService;

	@Autowired
	private QueueDemoService queueDemoService;

	@Autowired
	private MapDemoService mapDemoService;

	@GetMapping("/collection/demo/arraylist")
	public String arrayListDemo() {
		listDemoService.arrayListDemo();
		return "Array List Demo Completed.";
	}

	@GetMapping("/collection/demo/linked-list")
	public String linkedListDemo() {
		listDemoService.linkedListDemo();
		return "Linked List Demo Completed.";
	}

	@GetMapping("/collection/demo/hash-set")
	public String hashSetDemo() {
		setDemoService.hashSetDemo();
		return "Hash Set Demo Completed.";
	}

	@GetMapping("/collection/demo/linked-hash-set")
	public String linkedHashSetDemo() {
		setDemoService.linkedHashSetDemo();
		return "Linked Hash Set Demo Completed.";
	}

	@GetMapping("/collection/demo/tree-set")
	public String treeSetDemo() {
		setDemoService.treeSetDemo();
		return "Tree Set Demo Completed.";
	}

	@GetMapping("/collection/demo/hash-map")
	public String hashMapDemo() {
		mapDemoService.hashMapDemo();
		return "Hash Map Demo Completed.";
	}

	@GetMapping("/collection/demo/linked-hash-map")
	public String linkedHashMapDemo() {
		mapDemoService.linkedHashMapDemo();
		return "Linked Hash Map Demo Completed.";
	}

	@GetMapping("/collection/demo/identity-hash-map")
	public String identityHashMapDemo() {
		mapDemoService.identityHashMapDemo();
		return "Identity Hash Map Demo Completed.";
	}

	@GetMapping("/collection/demo/weak-hash-map")
	public String weakHashMapDemo() {
		mapDemoService.weakHashMapDemo();
		return "Weak Hash Map Demo Completed.";
	}

	@GetMapping("/collection/demo/tree-map")
	public String treeMapDemo() {
		mapDemoService.treeMapDemo();
		return "Tree Map Demo Completed.";
	}

	@GetMapping("/collection/demo/priority-queue")
	public String priorityQueueDemo() {
		queueDemoService.priorityQueue();
		return "Priority Queue Demo Completed.";
	}

}
