# ElasticSearch_Notes

## Commands

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
  
  - 

- 

## References

[1] [Elasticsearch 快速开始](https://www.e-learn.cn/content/java/1078247)

[2] [Elasticsearch PUT 插入数据](https://www.cnblogs.com/wjm956/p/9925353.html)

[3] [window下elasticsearch使用curl出现unmatched brace/bracket in column1](https://blog.csdn.net/johline/article/details/78794224)
