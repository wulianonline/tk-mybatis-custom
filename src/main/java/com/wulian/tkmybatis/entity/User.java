package com.wulian.tkmybatis.entity;

import com.wulian.tkmybatis.annotation.DevActive;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "user")
public class User {

    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    // 该注解表示，testInfo仅仅在dev环境生效，非dev环境的表中没有该字段，对应的实体映射也不应该出行该字段
    @DevActive
    @Column(name = "test_info")
    private String testInfo;

}
