## Hive

此範例為透過 SparkSQL 跟 Hive 連結，並載入外部資料來建立資料表

###範例資料

```
Michael 29
Andy 30
Justin 19
```
###將資料載入 hdfs 語法

```sh
hadoop fs -put 本地端路徑 hdfs 路徑
```

###利用 Spark-Submit 去執行

```sh
spark-submit --class "Package Name" --master local[2] "Jar 檔路徑" "table name" "外部資料路徑"
```
> 備註:若要載入本地端資料，在 INPATH 前加上 LOCAL

###結果

```
+-------+---+
|   name|age|
+-------+---+
|Michael| 29|
|   Andy| 30|
| Justin| 19|
+-------+---+
```