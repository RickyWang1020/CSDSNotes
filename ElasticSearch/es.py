"""
Function: Testing the basics of elasticsearch using Python
Author: Xinran Wang
Date: 09/03/2020
"""

from elasticsearch import Elasticsearch
from elasticsearch import helpers


class ElasticSearchClass:

    def __init__(self, host, port, user, password):
        self.host = host
        self.port = port
        self.user = user
        self.password = password
        self.connect()

    def connect(self):
        """
        连接到用户
        :return: None
        """
        self.es = Elasticsearch(hosts=[{'host': self.host, 'port': self.port}], http_auth=(self.user, self.password))

    def create_index(self, index, body):
        """
        创建一个新index
        :param index: 要创建的index名
        :param body: 数据结构体，用dic表示
        :return: 添加后的返回信息
        """
        try:
            return self.es.indices.create(index=index, body=body)
        except Exception as err:
            print(err)

    def create_document(self, index, body, id_name=None):
        """
        新建一条文档到指定的index下;可指定Id,若不指定,ES会自动生成
        :param index: 待插入的index值
        :param body: 待插入的数据 -> dict型
        :param id_name: 自定义Id值
        :return: 添加后的返回信息（成功与否）
        """
        try:
            return self.es.index(index=index, body=body, id=id_name)
        except Exception as err:
            print(err)

    def count(self, index_name):
        """
        统计index中包含的文档总数
        :param index_name:
        :return: 该index中的文档总数
        """
        try:
            return self.es.count(index=index_name)["count"]
        except Exception as err:
            print(err)

    def delete_document(self, index_name, id_name):
        """
        删除index中的一个文档
        :param index_name: index名
        :param id_name: 文档id名
        :return: 被删除的文档的内容
        """
        try:
            return self.es.delete(index=index_name, id=id_name)
        except Exception as err:
            print(err)

    def delete_index(self, index_name):
        """
        删除一条index
        :param index_name: index名
        :return: 删除后的返回信息（如果成功：{'acknowledged': True}）
        """
        try:
            return self.es.indices.delete(index_name)
        except Exception as err:
            print(err)

    def get(self, index_name, id_name):
        """
        获取某一index下的文档的内容
        :param index_name: index名
        :param id_name: 文档id名
        :return: dictionary
        """
        try:
            return self.es.get(index=index_name, id=id_name)
        except Exception as err:
            print(err)

    def search(self, index=None, body=None, size=10, scroll='10s'):
        """
        查找index/id
        :param index: 要查的index
        :param body: 请求体，里面有要搜索的条件
        :param size: 显示的匹配数据数量上限，不能大于10000
        :param scroll: 需要保持搜索的上下文环境时间，默认为10秒（类似于保持当前的索引状态快照的时间）
        :return: 搜索结果dictionary, 其中'hits'键包含搜索到的匹配信息
        """
        try:
            return self.es.search(index=index, body=body, size=size, scroll=scroll)
        except Exception as err:
            print(err)

    def scroll(self, scroll_id, scroll):
        """
        根据上一个查询方法，查询出来剩下所有相关数据
        """
        try:
            return self.es.scroll(scroll_id=scroll_id, scroll=scroll)
        except Exception as err:
            print(err)

    def update(self, index, id_name, body):
        """
        更新文档
        :param index: 要更新的index
        :param id_name: 文档的id
        :param body: 要更新的数据内容 -> dict型
        :return: 更新后的返回信息（成功与否）
        """
        try:
            return self.es.update(index=index, id=id_name, body=body)
        except Exception as err:
            print(err)

    def gen_bulk_data(self, index_name, field_names, data):
        """
        生成需要bulk的文档集合
        :param index_name: 需要将数据文档批量放入的index名
        :param field_names: 需要在文档中添加的字段的名称（list）
        :param data: 数据list（里面嵌套着小list，每个小list的内容对应field_names中的相应变量值）
        :return: generator
        """
        try:
            for d in data:
                d_source_dic = {}
                for v_idx, v in enumerate(field_names):
                    d_source_dic[v] = d[v_idx]
                yield {
                    "_index": index_name,
                    "_source": d_source_dic
                }
        except Exception as err:
            print(err)

    def bulk(self, actions):
        """
        批量数据上传
        :param actions: gen_bulk_data生成的generator
        :return: 数据添加之后的返回结果
        """
        try:
            return helpers.bulk(self.es, actions)
        except Exception as err:
            print(err)


if __name__ == "__main__":

    # 连接Elasticsearch
    obj = ElasticSearchClass('127.0.0.1', '9200', '', '')
    print(0)

    # 创建一个新的index
    # 内容长度如果较多使用text，较少使用keyword，一般使用keyword的比较多，因为text查询极其占用内存
    # 如果添加时间字段建议使用时间戳，类型用keyword
    mapping = {
            "mappings": {
                "properties": {
                    "email_id": {
                        "type": "text",
                        "index": "true"
                    },
                    "company_name": {
                        "type": "keyword",  # keyword不会进行分词,text会分词，integer整数，float浮点数
                        "index": "true"  # 不建索引
                    },
                    "company_id": {
                        "type": "keyword",  # keyword不会进行分词,text会分词
                        "index": "true"  # 不建索引
                    },
                    "result": {
                        "type": "object",
                        "properties": {
                            "client": {"type": "text", "index": "true"},
                        }
                    },
                    "create_time": {
                        "type": "keyword",
                        "index": 'true'
                    }
                }
            }
        }

    # body = {
    #     "settings": {
    #         "number_of_shards": 3,
    #         "number_of_replicas": 1
    #     },
    #     "mappings": {
    #         "properties": {
    #             "name": {
    #                 "type": "text"
    #             },
    #             "country": {
    #                 "type": "keyword"
    #             },
    #             "age": {
    #                 "type": "integer"
    #             },
    #             "date": {
    #                 "type": "date",
    #                 "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis"
    #             }
    #         }
    #     }
    # }
    p = obj.create_index(index="testing", body=mapping)
    print(1)

    # 插入一个文档
    obj.create_document(index='test', id_name=16, body={"name": "ricky", "age": 10000})
    obj.create_document(index='test', id_name=12, body={"name": "rocky", "age": 111})
    obj.create_document(index='testing', id_name=9, body={"name": "jesse", "age": 21323})
    obj.create_document(index="new", id_name=1, body={'name': 'bob', 'age': 15, 'type': 'minion'})
    obj.create_document(index="new", id_name=2, body={'name': 'stewart', 'age': 3, 'type': 'minion'})
    obj.create_document(index="new", id_name=3, body={'name': 'kevin', 'age': 55, 'type': 'minion'})
    obj.create_document(index="new", id_name=4, body={'name': 'gru', 'age': 65, 'type': 'human'})
    obj.create_document(index="new", id_name=5, body={'name': 'kid', 'age': 1, 'type': 'human'})
    obj.create_document(index="new", id_name=6, body={'name': 'vector', 'age': 32, 'type': 'human'})
    print(2)

    # 插入多个测试文档
    for i in range(5):
        obj.create_document(index="multi", id_name=i, body={"name": "test name", "age": i})
    print(3)

    # 更新文档内容
    update_body = {
        "doc": {
            "age": 10,
            "score": "a+"
        }
    }
    updated = obj.update("test", 16, update_body)
    print(4)

    # 查询所有数据
    all_body = {
        "query": {
            "match_all": {}
        }
    }
    all_response = obj.search(index="test", body=all_body)
    print(all_response)
    print(5)

    # match：搜索所有包含要检索的内容的文档（例：搜索所有name中包含test的文档）
    match_body = {
        "query": {
            "match": {
                "name": "test"
            }
        }
    }
    match_response = obj.search(body=match_body)
    print(match_response)
    print(6)

    # bool组合查询
    bool_body = {
        "query": {
            "bool": {
                "should": [
                    {
                        "term": {
                            "name": "gru"
                        }
                    },
                    {
                        "range": {
                            "age": {
                                # gt, lt - 大于小于；gte, lte - 大于等于，小于等于
                                "gt": 0,
                                "lt": 20
                            }
                        }
                    }
                ],
                "must_not": {
                    "match": {
                        "type": "minion"
                    }
                }
            }
        },
        # 字段排序
        "sort": [
            {
                "age": {
                    "order": "asc"
                }
            }
        ]
    }
    bool_response = obj.search(index="new", body=bool_body)
    print(bool_response)
    print(7)

    # scroll

    # bulk
    g = obj.gen_bulk_data("bulked", ["name", "school"], [["jack", "nyu"], ["jane", "thu"], ["lily", "sjtu"]])
    bulked = obj.bulk(g)
    print(8)

