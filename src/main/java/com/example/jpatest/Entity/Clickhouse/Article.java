package com.example.jpatest.Entity.Clickhouse;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@Accessors(chain = true)
public class Article {
    @Id
    Long id;
    String title;
    String content;
    Timestamp createTime;
}
