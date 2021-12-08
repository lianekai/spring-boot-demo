package com.lianekai.es.repository;

import com.lianekai.es.pojo.PicOcr;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/05/05 19:10
 */
public interface PicOcrRepository extends ElasticsearchRepository<PicOcr, Long> {
    Long deleteByCaseIdAndNId(Long caseId, String nId);
}
