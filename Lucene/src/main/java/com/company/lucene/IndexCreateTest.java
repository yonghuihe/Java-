package com.company.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class IndexCreateTest {
	String content1 = "hello world";
    String content2 = "hello java lucene";
    String content3 = "hello lucene world";

    File indexPath = new File("lucene");
    Version matchVersion = Version.LUCENE_4_10_4;//lucene版本
    Analyzer analyzer = new StandardAnalyzer();//语言分析器

    @Test
    public void testIndextCreate() throws IOException {
        //存放索引的位置
    	Directory directory = FSDirectory.open(indexPath);
        //写入器相关配置
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(matchVersion, analyzer);
        //创建索引写入器
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //字段的配置
        FieldType fieldType = new FieldType();
        fieldType.setIndexed(true);
        fieldType.setStored(true);
        //创建文档对象
        Document document1 = new Document();
        document1.add(new Field("title","content1",fieldType));
        document1.add(new Field("content",content1,fieldType));
        //将文档写入
        indexWriter.addDocument(document1);

        Document document2 = new Document();
        document2.add(new Field("title","content2",fieldType));
        document2.add(new Field("content",content2,fieldType));
        indexWriter.addDocument(document2);

        Document document3 = new Document();
        document3.add(new Field("title","content3",fieldType));
        document3.add(new Field("content",content3,fieldType));
        indexWriter.addDocument(document3);

        //提交
        indexWriter.commit();
        //释放资源
        indexWriter.close();
    }

    @Test
    public void testSearch() throws IOException, ParseException {
        //读取目录
        Directory directory = FSDirectory.open(indexPath);
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建索引查看器
        IndexSearcher search = new IndexSearcher(indexReader);
        //QueryParser("需要搜索的字段（索引区字段），语言分析对象")
        QueryParser queryParser = new QueryParser("content", analyzer);
        //queryParser.parse("需要查询的内容")
        Query query = queryParser.parse("hello");
        //search(查询对象，查询符合条件的1000条数据)
        TopDocs topDocs = search.search(query, 1000);
        System.out.println("总共查询到:"+topDocs.totalHits+"条记录");//总命中数
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;//带分数的文档
        Document doc = null;
        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.print("文档分数:"+scoreDoc.score);
            System.out.println("文档编号:"+scoreDoc.doc);
            doc = search.doc(scoreDoc.doc);
            System.out.print("标题"+doc.get("title"));
            System.out.println("内容"+doc.get("content"));
            System.out.println("************************");
        }
    }
}
