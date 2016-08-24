##MySQL
[MySQL.java](https://github.com/imac-cloud/NFU-spark-training/blob/master/examples/SparkSQL/MySQL/MySQL.java) 主要讓 ```SparkSQL``` 的 DataFrame 與 ```MySQL``` 資料表連結後用 SparkSQL 的 API 做資料表關聯式查詢

### MySQL 基本設定

```java
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_CONNECTION_URL = "jdbc:mysql://url/'database name'";
	private static final String MYSQL_DBtable = "table name";
	private static final String MYSQL_USERNAME = "account";
	private static final String MYSQL_PWD = "password";
```

### MySQL 資料串接並轉換成 DataFrame

```java
	Map<String, String> options = new HashMap<String, String>();
    options.put("url", MYSQL_CONNECTION_URL);
    options.put("driver", MYSQL_DRIVER);
    options.put("dbtable", MYSQL_DBtable);
    options.put("user", MYSQL_USERNAME);
    options.put("password", MYSQL_PWD);
    
    DataFrame DF = sqlContext.read().format("jdbc").options(options).load();
```

### 利用spark-submit 執行

```sh
	$ spark-submit --class com.imac.MySQL --master local[2] --jars mysql-connector-java-5.1.6.jar --driver-class-path mysql-connector-java-5.1.6.jar SparkSQL.jar
```
>MySQL 連接驅動 Jar 檔至 [mysql-connector-java-5.1.6.jar](http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.6/mysql-connector-java-5.1.6.jar)下載
