package com.javaSchool.eCare.model.dto.contract;

import com.javaSchool.eCare.model.entity.Contract;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContractViewForm {
    private int idContract;
    private String number;
    private String tariff_title;
    private String user_email;
    private boolean blocked;
    private boolean blocked_by_admin;

    public ContractViewForm(Contract contract){
        this.idContract=contract.getIdContract();
        this.number=contract.getNumber();
        this.tariff_title=contract.getTariff().getTitle();
//        this.user_email=contract.getUserEntity().getEmail(); Почему то не работает ????
        this.blocked=contract.isBlocked();
        this.blocked_by_admin=contract.isBlocked_by_admin();

    }
}

