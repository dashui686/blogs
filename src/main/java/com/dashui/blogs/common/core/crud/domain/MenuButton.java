package com.dashui.blogs.common.core.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuButton {
        private String type;
        private String title;
        private String name;
        private String status;
}