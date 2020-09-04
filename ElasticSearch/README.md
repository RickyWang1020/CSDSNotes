# ElasticSearch Notes

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


## Python (tested in v7.7.1)

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
  
- `Query` 查询：在执行时既要计算文档是否匹配，还要计算文档相对于其他文档的匹配度有多高，匹配度越高，`_score` 分数就越高

  - `term`：查询某个字段为该关键词的文档（它是相等关系而不是包含关系）
  
    ```
    body = {
        "query": {
            "term": { "name": "harry"} # name须严格匹配"harry"
        }
    }
    ```
  
  - `terms`：查询某个字段里含有多个关键词的文档
  
    ```
    body = {
        "query": {
            "terms": {
                "name": ["harry", "ron"] # name匹配"harry"或"ron"
            }
        }
    }
    ```
  
  - `match`：利用分词器对要查询的内容进行分词，然后查询
  
    ```
    body = {
        "query": {
            "match": {
                # 这里，type中有minion或者human或者minion human的都会被搜到
                "type": "minion human"
            }
        }
    }
    ```
  
  - `match_all`：查询所有文档
  
    ```
    body = {
        "query":{
            "match_all": {}
        }
    }
    ```
  
  - `match_phrase`：短语匹配查询，ElasticSearch引擎首先分析查询字符串，从分析后的文本中构建短语查询，这意味着必须匹配短语中的所有分词，并且保证各个分词的相对位置不变
  
    ```
    body = {
        "query":{
            "match_phrase": {
                "name": {
                    # 寻找name中匹配"one"和"three"，并且中间隔一词的文档
                    "query": "one, three",
                    "slop": 1
                }
            }
        }
    }
    ```
  
  - `multi_match`：指定多个字段匹配查询
  
    ```
    body = {
        "query":{
            "multi_match": {
                # 搜索name和address都包含match的文档
                "query": "match",
                "fields":["name","address"]
            }
        }
    }
    ```
  
- `Filter` 查询：在执行时只关心文档是否和查询匹配，不会计算匹配度

  ```
  body = { 
      "post_filter": {
          "terms": {"age": [3, 63]}
      }
  }
  ```

## Kibana

- 添加索引模式：Management -> Index Patterns -> Create Index Pattern

- 可视化（Visualization）：

  - X轴：
  
    - `Date Histogram`：一个 `date histogram` 是由数值字段构成并按照日期进行组合，您可以为日期直方图设置秒、分钟、小时、天、周、月或者年为间隔指定时间范围。同时你也可以选择自定义作为间隔并在文本字段中来指定数字和时间单位来指定自定义间隔帧。自定义间隔时间单位为秒，m 为分钟，h 为小时，d 为天，w 为周，y 为年.不同的时间单位支持不同的精度，精度值可以低至于一秒钟。

    - `Histogram`：标准的 `histogram` 从数值字段构建。为此字段指定整数间隔。您选择 `Show empty buckets` 复选框可以在直方图表中包含空白区域。

    - `Range`：使用 `range` 聚合，您可以为数值字段的值指定范围。点击 `Add Range` 您可以添加一组范围。单击红色的 (X) 符号您可以删除之前设置过的范围。

    - `Date Range`：一个 `date range` 聚合报告在您指定的日期范围内的值。您可以使用日期数学表达式指定日期的范围。

    - `IPv4 Range`：该 `IPv4 range` 聚合可以指定IPv4地址范围。

    - `Terms`：一个 `terms` 聚合使您能够指定要显示的给定字段的顶部或底部 n 个元素，按 `count` 或自定义度量进行排序。

    - `Filters`：您可以为数据指定一组 `filter`（过滤器）。您可以将过滤器指定为 `query string`（查询字符串）或 JSON 格式，就像在我们在 `Discover search bar`（搜索栏）中的过滤是一样的。单击 `Add Filter`（添加过滤器）以添加其他过滤器。单击 `label` 标签按钮图标可以打开标签字段，您可以在其中输入您需要在可视化文件上显示的名称。

    - `Significant Terms`：展示 `significant terms` 聚合实验性的结果。

## References

[1] [Elasticsearch 快速开始](https://www.e-learn.cn/content/java/1078247)

[2] [Elasticsearch PUT 插入数据](https://www.cnblogs.com/wjm956/p/9925353.html)

[3] [window下elasticsearch使用curl出现unmatched brace/bracket in column1](https://blog.csdn.net/johline/article/details/78794224)

[4] [使用ElasticSearch在bulk导入json数据时，The bulk request must be terminated by a newline [\n]](https://blog.csdn.net/qq_36525906/article/details/103180776)

[5] [Python ElasticSearch基础教程](https://blog.csdn.net/liuzemeeting/article/details/80708035)

[6] [Elasticsearch（4）-实现sql的大于小于语法](https://blog.csdn.net/cs1509235061/article/details/89450293?utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~first_rank_v2~rank_v25-4-89450293.nonecase&utm_term=elasticsearch%20%E5%A4%A7%E4%BA%8E%E6%9F%A5%E8%AF%A2)

[7] [Elasticsearch学习系列之term和match查询](https://blog.csdn.net/u014589856/article/details/78135762)

[8] [Python操作Elasticsearch对象](https://www.cnblogs.com/Alexephor/p/11398060.html)

[9] [Elasticsearch(6) --- Query查询和Filter查询](https://www.cnblogs.com/qdhxhz/p/11493677.html)
