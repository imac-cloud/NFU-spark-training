##SparkSQL
[SparkSQL.java](https://github.com/imac-cloud/NFU-spark-training/blob/master/examples/SparkSQL/SparkSQL/SparkSQL.java) 是利用 Java 撰寫而成的SparkSQL 範例，請利用SparkSQL API 的 select() 方法，把資料表中所有的 juice 欄位列出

### 首先先建立資料內容如下的 JSON 檔

```
{"juice":"Apple", "price":30}
{"juice":"Orange", "price":25}
{"juice":"Peach", "price":35}
{"juice":"tomato", "price":20}
```

### 利用 Spark-Submit 去執行

```sh
$ spark-submit --class "Package Name" --master local[2] "Jar 檔路徑" "外部資料路徑"
```

### 結果

```sh
+------+
| juice|
+------+
| Apple|
|Orange|
| Peach|
|tomato|
+------+
```


