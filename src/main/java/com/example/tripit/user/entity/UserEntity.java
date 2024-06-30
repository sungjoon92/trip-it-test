package com.example.tripit.user.entity;

//import com.nimbusds.openid.connect.sdk.claims.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity(name="user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_Id")
    private Integer userId;

    private String email;
    private String username;
    private String nickname;
    private String password;
    private String birth;
    private String gender;

    private String intro;

    private String role;

    @Temporal(TemporalType.TIMESTAMP) //JPA 엔티티 클래스의 필드가 데이터베이스에 어떤 시간 정보로 매핑되는지를 지정
    @Column(name="regdate")
    private Date regdate;

    @PrePersist //어노테이션은 엔티티가 영속화되기 전에 실행되는 메서드를 지정
    public void prePersist() {
        this.regdate = new Date();
    }
    //영속화란 객체를 데이터베이스가 이해할 수 있는 형태로 변환하고 저장하는 것.

    private String social_type;
    //private String userpic;
    //private int reportCount;
    //private Timestamp endDate;
}