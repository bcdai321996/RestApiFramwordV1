package com.example.RestApiFramwordV1.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "PassWord")
    private String PassWord;
    @Column(name = "LoginDate")
    private Date LoginDate;
    @Column(name = "IsChangeFirst")
    private int IsChangeFirst;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "BirthDay")
    private Date BirthDay;
    @Column(name = "email")
    private String email;
    @Column(name = "MobilePhone")
    private String MobilePhone;
    @Column(name = "InfoDetail")
    private String InfoDetail;
    @Column(name = "IsDelete")
    private int IsDelete;
    @Column(name = "status")
    private Integer status;
}

