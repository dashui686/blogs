package com.dashui.blogs.common.core.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputType {
        private String[] type;
        private String[] suffix;
        private String value;
}