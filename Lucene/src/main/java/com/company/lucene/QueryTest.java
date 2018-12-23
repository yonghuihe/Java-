package com.company.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by dell on 2017/7/11.
 */
public class QueryTest {
    String content1 = "hello world";
    String content2 = "hello java lucene";
    String content3 = "hello lucene world";

    File indexPath = new File("query");
    Version matchVersion = Version.LUCENE_4_10_4;//lucene版本
    Analyzer analyzer = new StandardAnalyzer();//语言分析器

    @Test
    public void testIndextCreate() throws IOException {
        //存放索引的位置
        Directory directory = FSDirectory.open(indexPath);
        //写入器相关配置
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(matchVersion, analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        //创建索引写入器
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        //字段的配置
        FieldType fieldType = new FieldType();
        fieldType.setIndexed(true);
        fieldType.setStored(true);
        //创建文档对象
        Document document1 = new Document();
        document1.add(new Field("id","1",fieldType));
        document1.add(new Field("title","content1",fieldType));
        document1.add(new Field("content",content1,fieldType));
        document1.add(new Field("inputtime","20170717",fieldType));
        //将文档写入
        indexWriter.addDocument(document1);

        Document document2 = new Document();
        document2.add(new Field("id","2",fieldType));
        document2.add(new Field("title","content2",fieldType));
        document2.add(new Field("content",content2,fieldType));
        document2.add(new Field("inputtime","20170718",fieldType));
        indexWriter.addDocument(document2);

        Document document3 = new Document();
        document3.add(new Field("id","3",fieldType));
        document3.add(new Field("title","content3",fieldType));
        document3.add(new Field("content",content3,fieldType));
        document3.add(new Field("inputtime","20170719",fieldType));
        indexWriter.addDocument(document3);

        //提交
        indexWriter.commit();
        //释放资源
        indexWriter.close();
    }

    public void print(IndexSearcher search,ScoreDoc[] scoreDocs) throws IOException {
        Document doc = null;
        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.print("文档分数:"+scoreDoc.score);
            System.out.println("文档编号:"+scoreDoc.doc);
            doc = search.doc(scoreDoc.doc);
            System.out.println("标题"+doc.get("title"));
            System.out.println("内容"+doc.get("content"));
            System.out.println("输入时间"+doc.get("inputtime"));
            System.out.println("************************");
        }
    }

    public void search(String content) throws IOException, ParseException {

        //读取目录
        Directory directory = FSDirectory.open(indexPath);
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建索引查看器
        IndexSearcher search = new IndexSearcher(indexReader);
        //QueryParser("需要搜索的字段（索引区字段），语言分析对象")
        QueryParser queryParser = new QueryParser("content", analyzer);
        //queryParser.parse("需要查询的内容")
        Query query = queryParser.parse(content);
        System.out.println(query.getClass());
        //search(查询对象，查询符合条件的1000条数据)
        TopDocs topDocs = search.search(query, 1000);
        System.out.println("总共查询到:"+topDocs.totalHits+"条记录");//总命中数
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;//带分数的文档
        print(search,scoreDocs);
    }

    public void search(Query query) throws IOException, ParseException {
        System.out.println(query);
        //读取目录
        Directory directory = FSDirectory.open(indexPath);
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建索引查看器
        IndexSearcher search = new IndexSearcher(indexReader);
        //QueryParser("需要搜索的字段（索引区字段），语言分析对象")
        //search(查询对象，查询符合条件的1000条数据)
        TopDocs topDocs = search.search(query, 1000);
        System.out.println("总共查询到:"+topDocs.totalHits+"条记录");//总命中数
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;//带分数的文档
        print(search,scoreDocs);
    }

    @Test
    public void testQueryAll() throws IOException, ParseException {
        //search("*:*");
        MatchAllDocsQuery query = new MatchAllDocsQuery();
        search(query);
    }

    @Test
    public void testTermQuery() throws IOException, ParseException {
        //search("title:content1");
        TermQuery query = new TermQuery(new Term("title","content1"));
        search(query);
    }

    @Test
    public void testPhraseQuery() throws IOException, ParseException {
        //search("\"hello world\"");
        PhraseQuery query = new PhraseQuery();
        query.add(new Term("content","hello"));
        query.add(new Term("content","world"));
        search(query);
    }

    @Test
    public void testWillCard() throws IOException, ParseException {
        //search("lucen?");//表示通配单个字符
        //search("luc*e");//表示通配多个字符
        //WildcardQuery query = new WildcardQuery(new Term("content", "lucen?"));
        WildcardQuery query = new WildcardQuery(new Term("content", "luc*e"));
        search(query);
    }

    @Test
    public void testLike() throws IOException, ParseException {
        //search("ladene~2");//支持里面有2个字符是错的
        FuzzyQuery query = new FuzzyQuery(new Term("content", "ladene"),2);
        search(query);
    }

    @Test
    public void testPhraseQuery2() throws IOException, ParseException {
        //search("\"hello world\"~1");//hello 和 world 之间允许出现有1个单词
        PhraseQuery query = new PhraseQuery();
        query.add(new Term("content","hello"));
        query.add(new Term("content","world"));
        query.setSlop(1);
        search(query);
    }

    @Test
    public void testTermQuery2() throws IOException, ParseException {
        /*
            [   左闭区间
            ]   右闭区间
            {   左开区间
            }   右开区间
         */
        //search("inputtime: [20170717 TO 20170719]");
        TermRangeQuery query = new TermRangeQuery("inputtime",new BytesRef("20170717"),
                new BytesRef("20170718"),true,false);
        search(query);
    }

    @Test
    public void testAnd() throws IOException, ParseException {
        search("title:content1 AND content:hello");
        //search("title:content1 && content:hello");
        /*BooleanQuery query = new BooleanQuery();
        query.add(new TermQuery(new Term("title","content1")), BooleanClause.Occur.MUST);
        query.add(new TermQuery(new Term("content","hello")), BooleanClause.Occur.MUST);
        search(query);*/
    }

    @Test
    public void testOR() throws IOException, ParseException {
        search("title:content1 content:lucene");
        search("title:content1 OR content:lucene");
        search("title:content1 || content:lucene");
        /*BooleanQuery query = new BooleanQuery();
        query.add(new TermQuery(new Term("title","content1")), BooleanClause.Occur.SHOULD);
        query.add(new TermQuery(new Term("content","hello")), BooleanClause.Occur.SHOULD);
        search(query);*/
    }

    @Test
    public void testNot() throws IOException, ParseException {
        //search("content:hello NOT title:content1");
        //search("content:hello ! title:content1");
        BooleanQuery query = new BooleanQuery();
        query.add(new TermQuery(new Term("content","hello")), BooleanClause.Occur.SHOULD);
        query.add(new TermQuery(new Term("title","content1")), BooleanClause.Occur.MUST_NOT);
        search(query);
    }

    @Test
    public void testMix() throws IOException, ParseException {
        //search("content:hello +title:content1");
        //search("content:hello -title:content1");
        //search("content:hello ! title:content1");
        BooleanQuery query = new BooleanQuery();
        /*query.add(new TermQuery(new Term("content","hello")), BooleanClause.Occur.SHOULD);
        query.add(new TermQuery(new Term("title","content1")), BooleanClause.Occur.MUST);*/
        query.add(new TermQuery(new Term("content","hello")), BooleanClause.Occur.SHOULD);
        query.add(new TermQuery(new Term("title","content1")), BooleanClause.Occur.MUST_NOT);
        search(query);
    }

    @Test
    public void testWeight() throws IOException, ParseException {
        //search("lucene^10 java ");//给相应的查询添加权重
        BooleanQuery query = new BooleanQuery();
        TermQuery termQuery = new TermQuery(new Term("content", "lucene"));
        termQuery.setBoost(10f);
        query.add(termQuery, BooleanClause.Occur.SHOULD);
        query.add(new TermQuery(new Term("content", "java")), BooleanClause.Occur.SHOULD);
        search(query);
    }
}
