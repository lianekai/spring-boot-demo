package com.lianekai.big.data.service;

import com.lianekai.big.data.job.StringProcessingJob;

/**
 * FlinkJobService
 *
 * @author lianyikai
 * @date 2025/3/10 18:40
 */
//@Service
public class FlinkJobService {

//    @Autowired
    private StringProcessingJob stringProcessingJob;

    public void runFlinkJob() throws Exception {
        stringProcessingJob.main(new String[]{});
    }
}
