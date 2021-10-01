package com.ertugrul.springmvcrest.api.v1.mapper;

import com.ertugrul.springmvcrest.api.v1.model.CategoryDTO;
import com.ertugrul.springmvcrest.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    @Mapping(source = "id", target = "id")
    CategoryDTO categoryToCategoryDTO(Category category);
}
