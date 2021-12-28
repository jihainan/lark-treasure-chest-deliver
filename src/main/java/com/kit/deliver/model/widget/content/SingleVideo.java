package com.kit.deliver.model.widget.content;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @ClassName SingleVideo
 * @Description notice with a single video
 * @Author jihainan
 * @Date 2021/12/28 3:25 下午
 * @Version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SingleVideo {
    /**
     * video source address
     */
    private String videoSrc;
    /**
     * video description
     */
    private String videoAlt;
    /**
     * video poster image source address
     */
    private String videoPoster;
}
