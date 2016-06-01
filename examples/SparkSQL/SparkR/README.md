##SparkR
以上皆為 SparkR 範例，分別是

- 利用本地端 DataFrame 建立的資料 [DFTest.R](https://github.com/imac-cloud/NFU-spark-training/blob/master/examples/SparkSQL/SparkR/DFTest.R)
- 載入外部 JSON 資料轉換為 DataFrame [JSONTest.R](https://github.com/imac-cloud/NFU-spark-training/blob/master/examples/SparkSQL/SparkR/JsonTest.R)
- 載入外部 CSV 資料轉換為 DataFrame [CSVTest.R](https://github.com/imac-cloud/NFU-spark-training/blob/master/examples/SparkSQL/SparkR/CSVTest.R)

### 利用 SparkR 執行

```sh
$ sparkR 'R檔名稱'.R
```

>備註:若是要載入 CSV 檔，需要外部 package 協助讀取 CSV 檔，執行語法如下

```sh
$ sparkR CSVTest.R --packages com.databricks:spark-csv_2.10:1.4.0 --master local
```