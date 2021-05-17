package com.javaSchool.eCare.model.dto.contract;

import com.javaSchool.eCare.model.entity.Contract;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContractViewForm {
    private int idContract;
    private String number;
    private String tariff_id;
    private String user_id;

    public ContractViewForm(Contract contract){
        this.idContract=contract.getIdContract();
        this.number=contract.getNumber();
        this.tariff_id=contract.getTariff().getTitle();
        this.user_id=contract.getUserEntity().getEmail();
    }
}
