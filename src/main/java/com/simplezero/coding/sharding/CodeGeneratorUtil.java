package com.simplezero.coding.sharding;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * mp生成器
 * 生成的代码在src目录下,需要手动挪到对应目录
 * 使用教程 https://mp.baomidou.com/guide/wrapper.html
 */
class CodeGeneratorUtil {

    public static void main(String[] args) {

        //todo 需要生成的表
        String[] tables = new String[]{"operation_log"};

        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        String srcPath = projectPath + "/src/main/java";
        gc.setOutputDir(srcPath);
        gc.setAuthor("simplezero");
        gc.setFileOverride(true);
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        //数据源配置 //jdbc:mysql://192.168.122.4:3306/ypsx_ofc
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/simplezero_0?nullCatalogMeansCurrent=true&serverTimezone=UTC" +
                "&useUnicode" +
                "=true&characterEncoding=UTF-8")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("");
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        // 需要去除parent, 否则包名前还会添加默认包路径 com.baomidou
        pc.setParent("");
        pc.setEntity("com.simplezero.coding.sharding.repository.bean")
                .setMapper("com.simplezero.coding.sharding.repository.dao")
                .setService("com.simplezero.coding.sharding.service")
                .setServiceImpl("com.simplezero.coding.sharding.service.impl")
        ;
        Map<String, String> packageInfo = new HashMap<>();
        packageInfo.put(ConstVal.ENTITY, "com.simplezero.coding.sharding.repository.bean");
        packageInfo.put(ConstVal.MAPPER, "com.simplezero.coding.sharding.repository.dao");
        packageInfo.put(ConstVal.SERVICE, "com.simplezero.coding.sharding.service");
        packageInfo.put(ConstVal.SERVICE_IMPL, "com.simplezero.coding.sharding.service.impl");

        /*
         * pathInfo配置controller、service、serviceImpl、entity、mapper、mapper.xml等文件的生成路径
         * srcPath也可以更具实际情况灵活配置
         * 后面部分的路径是和上面packageInfo包路径对应的源码文件夹路径
         * 这里你可以选择注释其中某些路径，可忽略生成该类型的文件，例如:注释掉下面pathInfo中Controller的路径，就不会生成Controller文件
         */
        Map<String, String> pathInfo = new HashMap<>(8);
        pathInfo.put(ConstVal.ENTITY_PATH, srcPath + "/" + packageInfo.get(ConstVal.ENTITY).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.MAPPER_PATH, srcPath + "/" + packageInfo.get(ConstVal.MAPPER).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_PATH, srcPath + "/" + packageInfo.get(ConstVal.SERVICE).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, srcPath + "/" + packageInfo.get(ConstVal.SERVICE_IMPL).replaceAll("\\.", StringPool.BACK_SLASH + File.separator));
        pc.setPathInfo(pathInfo);
        mpg.setPackageInfo(pc);


        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        //set("")表示不生成相应模块代码
        templateConfig.setController(null);
        // 配置自定义输出模板
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


        //配置策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // @version注解的字段名
//        strategy.setVersionFieldName("version");
        //默认是false
        strategy.setEntityLombokModel(true);

        strategy.setInclude(tables);

        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }

}


