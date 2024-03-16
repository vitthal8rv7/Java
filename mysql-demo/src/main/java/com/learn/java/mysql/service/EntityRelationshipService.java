package com.learn.java.mysql.service;

public interface EntityRelationshipService {

	public void testManyToOneUnidirection();

	public void testManyToOneBidirection();

	public void testOneToManyUnidirection();

	public void testOneToOneUni();

	public void testOneToOneBi();

	public void testOneToOneUniSharedPk();

	public void testManyToManyUni();

	public void testManyToManyBi();

	public void testManyToManyBiCascade();

	public void testIMSingleTable();

	public void testIMJoinedTable();

}
