package com.wulian.tkmybatis.conf;

import com.wulian.tkmybatis.annotation.DevActive;
import com.wulian.tkmybatis.annotation.TestActive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.Yaml;
import tk.mybatis.mapper.code.Style;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.entity.EntityField;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.mapperhelper.resolve.DefaultEntityResolve;

import java.io.InputStream;
import java.util.Map;

/**
 * @Description 配置类：部分数据库映射实体的字段在指定的环境下才扫描生效，其它环境不生效
 * @Author xiaolin
 * @Date 2020/2/8 16:01
 **/
@Slf4j
public class MybatisConfig extends DefaultEntityResolve {
    private static final String PROFILE_NAME = "spring.profiles.active";
    private String envName;


    public MybatisConfig(){
        super();
        // 优先从springboot的启动参数中获取激活的环境profile参数
        envName = System.getProperty(PROFILE_NAME);
        // 如果启动参数中无法获取到profile参数，则从yml配置文件中获取profile参数
        if (StringUtils.isEmpty(envName)){
            // 读取yml文件
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.yml");
            Yaml yaml = new Yaml();
            Map<String, Object> load = yaml.load(inputStream);
            // 获取指定的参数
            Map<String, Object> springProperties = (Map<String, Object>) load.get("spring");
            if (null == springProperties){
                return;
            }
            Map<String, Object> profileProperties = (Map<String, Object>) springProperties.get("profiles");
            if (null == profileProperties){
                return;
            }
            envName = (String) profileProperties.get("active");
        }

        log.info("env:{}", envName);
    }

    @Override
    protected void processField(EntityTable entityTable, EntityField field, Config config, Style style) {
        // 获取dev环境激活注解
        DevActive devActive = field.getAnnotation(DevActive.class);
        // 如果当前字段有dev环境注解，但是当前环境又并非dev环境，则不读取该字段直接返回
        if (null != devActive && !"dev".equalsIgnoreCase(envName)){
            log.info("dev_deprecated_field:{}", field.getName());
            return;
        }
        TestActive testActive = field.getAnnotation(TestActive.class);
        if (null != testActive && !"test".equalsIgnoreCase(envName)){
            log.info("test_deprecated_field:{}", field.getName());
            return;
        }
        // 如果没有获取到字段上的特殊注解，则使用父类的默认处理方法
        super.processField(entityTable, field, config, style);
    }

}
