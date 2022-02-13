package com.lianekai.easyexcel.tool;

import com.lianekai.easyexcel.common.BizException;
import com.lianekai.easyexcel.common.ResultEnum;
import com.lianekai.easyexcel.utils.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/13 20:52
 */
public class ExcelCheckTools {
    /**
     * 检验文件是否为Excel 类型 或者为不为空
     */
    public static void basicCheck(MultipartFile file) {
        /**文件判空*/
        Supplier<BizException> supplierFile = () -> new BizException(ResultEnum.DATA_IS_WRONG.getCode(), "文件不能为空!");
        file = Optional.ofNullable(file).orElseThrow(supplierFile);

        /**判断导入文件是否是excel文件*/
        if (!ExcelUtil.isExcelFormat(Objects.requireNonNull(file.getOriginalFilename()))) {
            throw new BizException(ResultEnum.DATA_IS_WRONG.getCode(), "文件类型非excel!");
        }
    }
}
