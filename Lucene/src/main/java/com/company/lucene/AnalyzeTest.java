package com.company.lucene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * Created by dell on 2017/7/12.
 */
public class AnalyzeTest {
    String en = "oh my lady gaga";
    String cn = "迅雷不及掩耳盗铃当仁不让";
    String msg = "小码哥教育的课程";

    public void testAnalyze(Analyzer analyzer,String content) throws IOException {
        TokenStream tokenStream = analyzer.tokenStream("content", content);
        tokenStream.reset();
        while (tokenStream.incrementToken()){
            System.out.println(tokenStream);
        }
    }

    /*
        en:按照空格进行分词
        cn:按照空格进行分词
     */
    @Test
    public void testSimpleAnalyzer() throws IOException {
        testAnalyze(new SimpleAnalyzer(),cn);
    }

    /*
        en:按照空格进行分词
        cn:按照单字分词
     */
    @Test
    public void testStandardAnalyzer() throws IOException {
        testAnalyze(new StandardAnalyzer(),cn);
    }

    @Test
    public void testPerFieldAnalyerWrapper() throws IOException {
        Map<String, Analyzer> fieldAnalyzers = new HashMap<>();
        fieldAnalyzers.put("title",new SimpleAnalyzer());
        fieldAnalyzers.put("content",new StandardAnalyzer());
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new SimpleAnalyzer(), fieldAnalyzers);
        //TokenStream tokenStream = wrapper.tokenStream("title",cn);
        TokenStream tokenStream = wrapper.tokenStream("content",cn);
        //TokenStream tokenStream = wrapper.tokenStream("xxxx",cn);
        tokenStream.reset();
        while (tokenStream.incrementToken()){
            System.out.println(tokenStream);
        }
    }

    /*
        cn:按照两个字来分词
     */
    @Test
    public void testCJKAnalyzer() throws IOException {
        testAnalyze(new CJKAnalyzer(),cn);
    }

    @Test
    public void testSmartChineseAnalyzer() throws IOException {
        testAnalyze(new SmartChineseAnalyzer(),cn);
    }

    @Test
    public void testIKAnalyzer() throws IOException {
        testAnalyze(new IKAnalyzer(true),msg);
    }

}
