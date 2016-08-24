package com.imac;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class MySQL2 implements Serializable {
	//MySQL �򥻳]�w(�]�t�X�ʡBurl�Btable�B�b���B�K�X)
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost/test";
	private static final String MYSQL_DBtable = "class1";
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PWD = "root";

	public static void main(String[] args) {
		SparkConf sc = new SparkConf().setAppName("MySQL");
	    JavaSparkContext ctx = new JavaSparkContext(sc);
	    SQLContext sqlContext = new SQLContext(ctx);
	    
	    //MySQL ��Ʀ걵���ഫ�� DataFrame
	    Map<String, String> options = new HashMap<String, String>();
	    options.put("url", MYSQL_CONNECTION_URL);
	    options.put("driver", MYSQL_DRIVER);
	    options.put("dbtable", MYSQL_DBtable);
	    options.put("user", MYSQL_USERNAME);
	    options.put("password", MYSQL_PWD);
	    
	    DataFrame DF = sqlContext.read().format("jdbc").options(options).load();
	    
	    //��ܦC�X�e�ⵧ��ƪ� Name �M Age ���
		DF.select("Name", "Age").show(2);
		
		//�����p���y�k�D�X�~���j�� 22 �H�Ψ����j�� 160 �����
		DF.registerTempTable("class");
		DataFrame testDF = sqlContext.sql("SELECT * FROM class WHERE Age > 20 AND Height > 160");
		
		testDF.show();
	}

}
