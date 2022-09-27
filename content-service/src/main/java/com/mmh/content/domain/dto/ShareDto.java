package com.mmh.content.domain.dto;

import com.mmh.content.domain.entity.Share;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mingle
 * @date 2022/9/6 20:14
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShareDto {
    private Share share;
    private String nickName;
    private String avatar;
}
