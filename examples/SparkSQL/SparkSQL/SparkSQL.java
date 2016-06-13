package com.imac;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class SparkSQL {
	public static void main(String[] args) {
	    SparkConf sc = new SparkConf().setAppName("SparkSQL");
	    JavaSparkContext ctx = new JavaSparkContext(sc);
	    SQLContext sqlContext = new SQLContext(ctx);
	    
	    DataFrame people = sqlContext.read().json(args[0]);
	    people.select("juice").show();
	}

}
