package com.javaSchool.eCare.model.dto.option;

import com.javaSchool.eCare.model.entity.Option;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OptionViewForm {
    private int idOption;
    private String name;
    private double cost;
    private double conn_cost;

    public OptionViewForm(Option option){
        this.idOption=option.getIdOption();
        this.name=option.getName();
        this.cost=option.getCost();
        this.conn_cost=option.getConn_cost();
    }
}
