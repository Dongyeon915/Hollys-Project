package com.naver.ehd9567.hollys_backend.aop;

import com.naver.ehd9567.hollys_backend.dto.MenuDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBlank implements ConstraintValidator<NotBlankCopy, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        MenuDTO menuDTO = new MenuDTO();
        if (value instanceof MenuDTO) {
            menuDTO.setMenu_id(((MenuDTO) value).getMenu_id());
            menuDTO.setName(((MenuDTO) value).getName());
        }
        if (menuDTO.getMenu_id() <= 0) {
            return false;
        } else {
            return true;
        }

    }
}
