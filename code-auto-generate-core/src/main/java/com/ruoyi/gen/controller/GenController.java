package com.ruoyi.gen.controller;


import com.ruoyi.gen.service.IGenTableColumnService;
import com.ruoyi.gen.service.IGenTableService;
import com.ruoyi.gen.text.Convert;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 代码生成 操作处理
 * 
 */
@RequestMapping("/gen")
@RestController
public class GenController
{
    @Autowired
    private IGenTableService genTableService;

    @Autowired
    private IGenTableColumnService genTableColumnService;

    /**
     * 导入表结构（保存）
   /*  *//*
    @PostMapping("/importTable")
    public AjaxResult importTableSave(String tables)
    {
        String[] tableNames = Convert.toStrArray(tables);
        // 查询表信息
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        genTableService.importGenTable(tableList);
        return AjaxResult.success();
    }*/

    /**
     * 生成代码（下载方式）
     */
    @GetMapping("/download/{tableName}")
    public void download(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException
    {
//        byte[] data = genTableService.downloadCode(tableName);
        byte[] data = genTableService.downloadCodeNew(tableName);
        genCode(response, data);
    }

   /* *//**
     * 批量生成代码
     *//*
    @GetMapping("/batchGenCode")
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException
    {
        String[] tableNames = Convert.toStrArray(tables);
        byte[] data = genTableService.downloadCode(tableNames);
        genCode(response, data);
    }*/

    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException
    {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"ruoyi.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}
