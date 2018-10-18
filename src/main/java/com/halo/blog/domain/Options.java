package com.halo.blog.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
/**
 * <pre>
 *     系统设置
 * </pre>
 *
 * @author tangwei
 * @date 2018/10/14 18:49
 */
@Data
@Entity
@Table(name = "options")
public class Options implements Serializable {
    /**
     * 设置项名称
     */
    @Id
    @Column(length = 127)
    private String optionName;

    /**
     * 设置项的值
     */
    @Lob
    private String optionValue;

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
