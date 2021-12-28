package com.kit.deliver.model.widget.content;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @ClassName SingleImg
 * @Description Notice with a single image
 * @Author jihainan
 * @Date 2021/12/28 3:19 下午
 * @Version 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class SingleImg {
    /**
     * image source address
     */
    private String imgSrc;
    /**
     * image description
     */
    private String imgAlt;
}
