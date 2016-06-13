package com.imac;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class SparkSQL {

//	public static class Person implements Serializable {
//	    private String name;
//	    private int age;
//
//	    public String getName() {
//	      return name;
//	    }
//
//	    public void setName(String name) {
//	      this.name = name;
//	    }
//
//	    public int getAge() {
//	      return age;
//	    }
//
//	    public void setAge(int age) {
//	      this.age = age;
//	    }
//	  }
//	
	public static void main(String[] args) {
		SparkConf sc = new SparkConf().setAppName("SparkSQL");
	    JavaSparkContext ctx = new JavaSparkContext(sc);
	    SQLContext sqlContext = new SQLContext(ctx);
	    
//	    //use RDD
//	    System.out.println("=== Data source: RDD ===");
//	    JavaRDD<Person> people = ctx.textFile("examples/src/main/resources/people.txt").map(
//	    	      new Function<String, Person>() {
//	    	    	  @Override
//	    	          public Person call(String line) {
//	    	            String[] parts = line.split(",");
//
//	    	            Person person = new Person();
//	    	            person.setName(parts[0]);
//	    	            person.setAge(Integer.parseInt(parts[1].trim()));
//
//	    	            return person;
//	    	          }
//	    	      });
//	    
//	    DataFrame schemaPeople = sqlContext.createDataFrame(people, Person.class);
//	    schemaPeople.registerTempTable("people");
//	    
//	    DataFrame teenagers = sqlContext.sql("SELECT name FROM people WHERE age >= 13 AND age <= 19");
//	    List<>
	    
	    //use JSON Datasets
	    DataFrame people = sqlContext.read().json(args[0]);
	    people.printSchema();
	    people.show();
	    people.select("juice").show();
//	    people.registerTempTable("people");
//	    DataFrame teenagers = sqlContext.sql("SELECT name FROM people WHERE age >=13 AND age <= 19");
//	    teenagers.show();
	}

}
