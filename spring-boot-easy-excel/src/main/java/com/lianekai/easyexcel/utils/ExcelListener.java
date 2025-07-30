package com.lianekai.easyexcel.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * excel监听器
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/04 20:34
 */
@Getter
@Slf4j
public class ExcelListener extends AnalysisEventListener<Object> {
    /**
     * 可以通过实例获取该值
     */
    private  List<Object> dataList = new ArrayList<>();

    /**
     * 可以通过获取到表头
     * -- GETTER --
     *  读取excle除了表头的数据

     */
    private List<String> headList = new ArrayList<>();

    @Override
    public void invoke(Object object, AnalysisContext analysisContext) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        //去掉空值
        Map<String,String> map = JSON.parseObject(JSON.toJSONString(object), Map.class);
        if(map.size()==0||(map.size()==1&&map.containsKey("matMap"))){
            return;
        }
        dataList.add(object);
    }

    /**
     * 读取表头
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("表头"+headMap);
        //遍历获取表头
        for (Map.Entry<Integer, String> map : headMap.entrySet()) {
            String value = map.getValue().replace(" ","");
            headList.add(value);
        }
    }
    /**
     * 调用完监听器之后做的事情，比如可以做校验
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //非必要语句，查看导入的数据
        log.info("导入的数据"+dataList.toString());
        log.info("处理空格后的表头"+headList);
        //导入数据的集合
        //解析结束销毁不用的资源
    }

}