package com.imac;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class SparkSQL {

	public static void main(String[] args) {
	    //spark 基本設定
	    SparkConf sc = new SparkConf().setAppName("SparkSQL");
	    JavaSparkContext ctx = new JavaSparkContext(sc);
	    SQLContext sqlContext = new SQLContext(ctx);
	    
	    //將外部 JSON 轉換成 DateFrame 資料表
	    DataFrame drinks = sqlContext.read().json(args[0]);
	    
	    drinks.printSchema();
	    //查看資料表內容
	    drinks.show();
	    
	    //用關聯式語法查詢
	    drinks.registerTempTable("drinks");
	    DataFrame choices = sqlContext.sql("SELECT juice FROM drinks");
	    choices.show();
	    
	    //用SparkSQL API 作關聯式語法查詢
	    drinks.select("juice").show();
	    
	    
	}

}
