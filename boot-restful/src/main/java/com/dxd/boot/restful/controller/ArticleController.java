package com.dxd.boot.restful.controller;


import com.dxd.boot.restful.common.AjaxResponse;
import com.dxd.boot.restful.model.Article;
import com.dxd.boot.restful.model.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ArticleController {
    @GetMapping("id")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        Reader[] readers={
                Reader.builder().name("dxd").age(12).build(),Reader.builder().name("hjj").age(12).build()
        };
        List<Reader> readerList = List.of(Reader.builder().name("aaa").age(12).build());
        Article article = Article.builder()
                .id(id)
                .author("dxd")
                .title("Spring")
                .content("rum")
                .createTime(new Date())
                .build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }

    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article, @RequestHeader String aaa) {
        log.info("请求头aaa" +aaa);
        return AjaxResponse.success(article);
    }
//
//    @PostMapping("/articles")
//    public AjaxResponse saveArticle(@RequestParam String author,
//                                    @RequestParam String title,
//                                    @RequestParam String content,
//                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//                                        @RequestParam Date createTime) {
//        log.info("saveArticle" +author);
//        log.info("saveArticle" +title);
//        log.info("saveArticle" +content);
//        log.info("saveArticle" +createTime);
//        return AjaxResponse.success();
//    }
    @PutMapping ("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article) {
        if (article.getId()== null) {
            log.error("没有id" );
            //article.id是必传参数，因为通常根据id去修改数据
        }
        log.info("updateArticle:" +article);
        return AjaxResponse.success();

    }
    @DeleteMapping ("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle:" +id);
        return AjaxResponse.success();
    }

}
