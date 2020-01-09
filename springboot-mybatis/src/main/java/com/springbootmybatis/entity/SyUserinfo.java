package com.springbootmybatis.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SyUserinfo {
    private Integer id;

    private String username;

    private String userbirth;

    private String usersex;

    private String useridtype;

    private String useridno;

    private String supplementflag;

    private String salechnl;

    private String agentcode;

    private String operator;

    private Date maketime;

    private String retainvarchar1;

    private String retainvarchar2;

    private String retainvarchar3;

    private String retainvarchar4;

    private String retainvarchar5;

    private String agentcom;

    private String saleagentcode;

    private String agentcomname;

    private String grpagentcom;

    private String grpagentcomname;

    private String grpagentname;

    private String grpagentidno;
}
