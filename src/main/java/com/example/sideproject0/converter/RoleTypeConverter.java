package com.example.sideproject0.converter;

import com.example.sideproject0.constant.RoleType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Converter
public class RoleTypeConverter implements AttributeConverter<RoleType, String> {

        @Override
        public String convertToDatabaseColumn(RoleType attribute) {
            if (Objects.isNull(attribute)) {
                return null;
            }
            return attribute.getValue();
        }

        @Override
        public RoleType convertToEntityAttribute(String dbData) {
            if (StringUtils.isBlank(dbData)) {
                return null;
            }
            return RoleType.fromCode(dbData);
        }

}
