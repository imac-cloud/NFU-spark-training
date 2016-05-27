package com.imac;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;

public class Hive {

	public static void main(String[] args) {
		SparkConf sc = new SparkConf().setAppName("Hive");
		JavaSparkContext ctx = new JavaSparkContext(sc);
		HiveContext sqlContext = new HiveContext(ctx.sc());
		
		//若要載入本地端資料，需要再 INPATH 前加上 LOCAL
		sqlContext.sql("CREATE TABLE if not exists "+ args[0]+"(Name STRING ,Age INT) row format delimited  fields terminated by ' ' lines terminated by '\n'");
		sqlContext.sql("LOAD DATA INPATH '"+ args[1] +"' INTO TABLE "+ args[0]);
		
		DataFrame result = sqlContext.sql("SELECT * from " + args[0]);
		result.show();
	}

}
