package com.test.sber.mapper;

public interface Mapper<Input,Output> {
    Output mapperEntity(Input in);
    Input mapperDto(Output out);
}
