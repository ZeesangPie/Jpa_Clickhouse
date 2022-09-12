package com.example.jpatest.Repository.Clickhouse;

import com.example.jpatest.Base.BaseRepository;
import com.example.jpatest.Entity.Clickhouse.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends BaseRepository<Article, String>, JpaSpecificationExecutor<Article> {

}
