package com.example.springbootinit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import lombok.extern.slf4j.Slf4j;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

/**
 * @auther: lifq
 * @date: 2020/4/15 12:28
 * @Description:
 */
@Slf4j
public class Test {


    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("1", "2");
//        ReadAndWriteDoc.readwriteWord("f:/123.doc", map);

//        wToPdfChange("f:/123.doc", "f:/test/1234.pdf");
    }

//    @org.junit.jupiter.api.Test
//    public void testCreateImage() {
//        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
//        frequencyAnalyzer.setWordFrequenciesToReturn(600);
//        frequencyAnalyzer.setMinWordLength(2);
//        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//
//        // 可以直接从文件中读取
////        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("d:/test/chinese_language.txt");
//
//        final List<WordFrequency> wordFrequencies = new ArrayList<>();
//        // 用后端技术书籍来随机生成词云
//        String[] books = {"Spring实战", "Spring源码深度解析", "SpringBoot实战",
//                "SpringBoot2精髓", "一步一步学SpringBoot2", "Spring微服务实战",
//                "Head First Java", "Java并发编程实战", "深入理解Java 虚拟机",
//                "Head First Design", "effective java", "J2EE development without EJB",
//                "TCP/IP卷一", " 计算机网络：自顶向下", "图解HTTP和图解TCP/IP",
//                "计算机网络", "深入理解计算机系统", "现代操作系统",
//                "Linux内核设计与实现", "Unix网络编程", "数据结构与算法",
//                "算法导论", "数据结构与算法（Java版）", "算法图解，啊哈算法",
//                "剑指offer", "LeetCode", " Java编程思想",
//                "Java核心技术卷一", "深入理解JVM虚拟机", "Java并发编程实战",
//                " Java并发编程艺术", "Java性能调优指南", "Netty权威指南",
//                "深入JavaWeb技术内幕", "How Tomcat Works", "Tomcat架构解析",
//                "Spring实战", "Spring源码深度解析", "Spring MVC学习指南",
//                "Maven实战", "sql必知必会", "深入浅出MySQL",
//                "Spring cloud微服务实战", "SpringBoot与Docker微服务实战", "深入理解SpringBoot与微服务架构"
//        };
//        //加入分词并随机生成权重，每次生成得图片都不一样
//        for (String book : books) {
//            wordFrequencies.add(new WordFrequency(book, new Random().nextInt(books.length)));
//        }
//
//        //此处不设置会出现中文乱码
//        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 18);
//
//        final Dimension dimension = new Dimension(900, 900);
//        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
//        wordCloud.setPadding(2);
//        wordCloud.setBackground(new CircleBackground(255));
//        wordCloud.setFontScalar(new SqrtFontScalar(12, 42));
//        //设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
//        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
//
//        wordCloud.setKumoFont(new KumoFont(font));
//        wordCloud.setBackgroundColor(new Color(255, 255, 255));
//        //因为我这边是生成一个圆形,这边设置圆的半径
//        wordCloud.setBackground(new CircleBackground(255));
//
//        wordCloud.build(wordFrequencies);
//        wordCloud.writeToFile("d://test/810.png");
//    }

    @org.junit.jupiter.api.Test
    public void testGetComment() {

        try {
            Map<String, Integer> numMap = new LinkedHashMap<>();

            final List<WordFrequency> wordFrequencies = new ArrayList<>();


            for (int page = 0; page < 9; page++) {
                Thread.sleep(new Random().nextInt(5) * 1000);
                String commentUrl = "https://club.jd.com/comment/productPageComments.action?callback=fetchJSON_comment98&productId=65334981412&score=0&sortType=5&page=" +
                        page + "&pageSize=10&isShadowSku=0&fold=1";

                //先获得的是整个页面的html标签页面
                Document doc = Jsoup.connect(commentUrl).get();
//            log.info("doc={}", doc.toString());
                JSONObject jsonObject = JSON.parseObject(doc.body().text().replaceAll("fetchJSON_comment98\\(", "").replaceAll("\\)", "").replace(";", ""));

                JSONArray jsonArray = jsonObject.getJSONArray("comments");

                for (int i = 0; i < jsonArray.size(); i++) {
                    String content = jsonArray.getJSONObject(i).getString("content");
                    log.info("第{}页，第{}条,content={}", page + 1, i + 1, content);
                    List<Word> words = WordSegmenter.segWithStopWords(content);

                    for (Word word : words) {
                        if (numMap.containsKey(word.getText())) {
                            Integer num = numMap.get(word.getText()) + 1;
                            numMap.put(word.getText(), num);
                        } else {
                            numMap.put(word.getText(), 1);
                        }
                    }
                }
            }


            for (Map.Entry<String, Integer> entry : numMap.entrySet()) {
                wordFrequencies.add(new WordFrequency(entry.getKey(), entry.getValue()));
            }


            //此处不设置会出现中文乱码
            java.awt.Font font = new java.awt.Font("STSong-Light", 2, 20);

            final Dimension dimension = new Dimension(900, 900);
            final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
            wordCloud.setPadding(2);
            wordCloud.setBackground(new CircleBackground(500));
            wordCloud.setFontScalar(new SqrtFontScalar(12, 42));
            //设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
//            wordCloud.setColorPalette(new LinearGradientColorPalette(new Color(0, 58, 140), new Color(9, 109, 217), new Color(64, 169, 255), 30, 30));
//            wordCloud.setColorPalette(new LinearGradientColorPalette(new Color(181, 181, 181), new Color(67, 67, 67), new Color(0, 0, 0), 30, 30));
            wordCloud.setColorPalette(new LinearGradientColorPalette(Color.red, Color.yellow, Color.blue, 30, 30));

            wordCloud.setKumoFont(new KumoFont(font));
//            wordCloud.setBackgroundColor(new Color(255, 255, 255));
            wordCloud.setBackgroundColor(Color.black);
            //因为我这边是生成一个圆形,这边设置圆的半径
            wordCloud.setBackground(new CircleBackground(500));

            wordCloud.build(wordFrequencies);
            wordCloud.writeToFile("d://test/860.png");


            log.info("ok");
        } catch (Exception e) {
            log.error("error", e);
        }

    }

    @org.junit.jupiter.api.Test
    public void testSplit() {

        try {
            String input = "d:/test/11.txt";
            String output = "d:/test/22.txt";
            String output1 = "d:/test/33.txt";

            WordSegmenter.seg(new File(input), new File(output), SegmentationAlgorithm.FullSegmentation);
            WordSegmenter.segWithStopWords(new File(input), new File(output1), SegmentationAlgorithm.FullSegmentation);


            List<Word> words = WordSegmenter.segWithStopWords("我爱中国");


            log.info("ok");
        } catch (Exception e) {
            log.error("error", e);
        }

    }

}
