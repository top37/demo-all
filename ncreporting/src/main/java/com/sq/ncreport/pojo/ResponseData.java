package com.sq.ncreport.pojo;

import lombok.Data;

import java.io.File;

@Data
public class ResponseData {

    private File[] files;

    private String[] Strs;
}
