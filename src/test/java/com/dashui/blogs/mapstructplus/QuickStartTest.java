package com.dashui.blogs.mapstructplus;

import io.github.linpeilie.Converter;
import org.junit.jupiter.api.Test;


public class QuickStartTest {

    private Converter converter = new Converter();
    @Test
    public void ueseTest() {
        UserDto userDto = new UserDto();
        userDto.setEducations("1,2,3");

        final User user = converter.convert(userDto, User.class);
        System.out.println(user.getEducationList());    // [1, 2, 3]

        assert user.getEducationList().size() == 3;
    }
}
