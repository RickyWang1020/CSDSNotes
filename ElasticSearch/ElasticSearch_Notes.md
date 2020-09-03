# ElasticSearch_Notes

## Commands in Cmd

- Rest API

  - 查看集群健康：`curl -X GET "localhost:9200/_cat/health?v"`
  
  - 查看集群节点列表：`curl -X GET "localhost:9200/_cat/nodes?v"`
  
  - 查看集群中的所有索引：`curl -X GET "localhost:9200/_cat/indices?v"`
  
  - 创建一个 `customer` 索引：`curl -X PUT "localhost:9200/customer?pretty"`
  
  - 在 `customer` 索引下创建一个 `id` 为 1 的文档：`curl -H "Content-Type: application/json" -X PUT "localhost:9200/customer/_doc/1?pretty" -d"{"""name""": """john"""}"`
  
  - 检索 `customer` 索引中的文档：`curl -X GET "localhost:9200/customer/_doc/1?pretty"`
  
  - 删除 `customer` 索引：`curl -X DELETE "localhost:9200/customer?pretty"`
  
  - 更新 `customer` 索引中 `id` 为 1 的文档（修改 `name` 字段并添加 `age` 字段）：`curl -H "Content-Type: application/json" -X POST "localhost:9200/customer/_doc/1/_update?pretty" -d"{"""doc""": {"""name""": """jane""", """age""": 20}}"`
  
  - 将 `customer` 的 `age` 增加 5 ：`curl -H "Content-Type: application/json" -X POST "localhost:9200/customer/_doc/1/_update?pretty" -d"{"""script""": """ctx._source.age+=5"""}"`
  
  - 删除 `customer` 索引中 `id` 为 2 的文档：`curl -X DELETE "localhost:9200/customer/_doc/2?pretty"`
  
  - 批处理：
  
    - 在 `customer` 索引下同时创建 `id` 为 1 和 `id` 为 2 的文档（在 `test.json` 中写入以下内容）：
    
      ```json
      {"index":{"_id": "1"}}
      {"name":"John Doe"}
      {"index":{"_id": "2"}}
      {"name":"Jane Doe"}
      // 要有空行！
      
      ```
      
      随后在命令行写入：`curl -H "Content-Type: application/json" -X POST "localhost:9200/customer/_doc/_bulk?pretty" --data-binary "@path/test.json"`
      
      （使用 `-d` 命令会自动忽略换行，导致报错）
    
    - 更新 `customer` 索引中 `id` 为 1 的文档并删除 `id` 为 2 的文档（在 `test.json` 中写入以下内容）：
    
      ```json
      {"update":{"_id": "1"}}
      {"doc": {"name":"John Doe becomes Jane Doe"}}
      {"delete": {"_id": "2"}}
      // 要有空行！
      
      ```
      
      并在命令行写入：`curl -H "Content-Type: application/json" -X POST "localhost:9200/customer/_doc/_bulk?pretty" --data-binary "@path/test.json"`

- Search API


## Python

- Elasticsearch v7及以上创建 `body` （包含 `settings` 和 `mappings` 两个键） 时报错：`Root mapping definition has unsupported parameters`

  修改方法：`mapping` 字典内不可以包含自定义索引类型
  
  ```
  correct_body = {
      "settings": {
          "number_of_shards": 3,
          "number_of_replicas": 1
      },
      "mappings": {     // mapping下不要写自定义类型
          "properties": {
              "name": {
                  "type": "text"
              },
              "country": {
                  "type": "keyword"
              },
              "age": {
                  "type": "integer"
              },
              "date": {
                  "type": "date",
                  "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis"
              }
          }
      }
  }
  ```

## References

[1] [Elasticsearch 快速开始](https://www.e-learn.cn/content/java/1078247)

[2] [Elasticsearch PUT 插入数据](https://www.cnblogs.com/wjm956/p/9925353.html)

[3] [window下elasticsearch使用curl出现unmatched brace/bracket in column1](https://blog.csdn.net/johline/article/details/78794224)

[4] [使用ElasticSearch在bulk导入json数据时，The bulk request must be terminated by a newline [\n]](https://blog.csdn.net/qq_36525906/article/details/103180776)
