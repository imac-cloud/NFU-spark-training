package com.imac;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class SparkSQL {

	public static void main(String[] args) {
		//spark �򥻳]�w
		SparkConf sc = new SparkConf().setAppName("SparkSQL");
	    JavaSparkContext ctx = new JavaSparkContext(sc);
	    SQLContext sqlContext = new SQLContext(ctx);
	    
	    //�N�~�� JSON �ഫ�� DateFrame ��ƪ�
	    DataFrame drinks = sqlContext.read().json(args[0]);
	    
	    drinks.printSchema();
	    //�d�ݸ�ƪ��e
	    drinks.show();
	    
	    //�����p���y�k�d��
	    drinks.registerTempTable("drinks");
	    DataFrame choices = sqlContext.sql("SELECT juice FROM drinks");
	    choices.show();
	    
	    //��SparkSQL API �@���p���y�k�d��
	    drinks.select("juice").show();
	    
	    
	}

}
